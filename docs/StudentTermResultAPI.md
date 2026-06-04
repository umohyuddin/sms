# Student Term Result API Documentation

## Overview
This document provides comprehensive information about the Student Term Result service, including API endpoints, request/response formats, and example queries.

## Service Implementation

### StudentTermResultServiceImpl

The service provides three main operations:

1. **Process Results** - Calculate and save term results for all students in a section
2. **Get Section Results** - Retrieve results for all students in a section
3. **Get Student Result** - Retrieve result for a specific student

---

## API Endpoints

### 1. Process Term Results

**Endpoint:** `POST /api/academic/results/process`

**Description:** Calculates and saves term results for all students in a section based on their exam marks and weightages.

**Parameters:**
- `standardId` (Long, required) - Standard/Class ID
- `sectionId` (Long, required) - Section ID
- `examTermId` (Long, required) - Exam Term ID

**Request Example:**
```http
POST /api/academic/results/process?standardId=1&sectionId=2&examTermId=3
Content-Type: application/json
```

**Response:**
```json
{
  "message": "Results processed successfully",
  "status": "SUCCESS"
}
```

**cURL Example:**
```bash
curl -X POST "http://localhost:8080/api/academic/results/process?standardId=1&sectionId=2&examTermId=3" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -H "Content-Type: application/json"
```

---

### 2. Get Section Results

**Endpoint:** `GET /api/academic/results/section`

**Description:** Retrieves term results for all students in a specific section.

**Parameters:**
- `standardId` (Long, required) - Standard/Class ID
- `sectionId` (Long, required) - Section ID
- `examTermId` (Long, required) - Exam Term ID

**Request Example:**
```http
GET /api/academic/results/section?standardId=1&sectionId=2&examTermId=3
```

**Response:**
```json
[
  {
    "studentId": 101,
    "studentName": "John Doe",
    "academicYearId": 5,
    "academicYearName": "2023-2024",
    "examTermId": 3,
    "examTermName": "First Term",
    "totalMarks": 500.00,
    "obtainedMarks": 425.50,
    "percentage": 85.10,
    "grade": "A",
    "rank": null,
    "isActive": true
  },
  {
    "studentId": 102,
    "studentName": "Jane Smith",
    "academicYearId": 5,
    "academicYearName": "2023-2024",
    "examTermId": 3,
    "examTermName": "First Term",
    "totalMarks": 500.00,
    "obtainedMarks": 465.00,
    "percentage": 93.00,
    "grade": "A+",
    "rank": null,
    "isActive": true
  }
]
```

**cURL Example:**
```bash
curl -X GET "http://localhost:8080/api/academic/results/section?standardId=1&sectionId=2&examTermId=3" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -H "Accept: application/json"
```

---

### 3. Get Student Result

**Endpoint:** `GET /api/academic/results/student/{id}`

**Description:** Retrieves term result for a specific student.

**Path Parameters:**
- `id` (Long, required) - Student ID

**Query Parameters:**
- `examTermId` (Long, required) - Exam Term ID

**Request Example:**
```http
GET /api/academic/results/student/101?examTermId=3
```

**Response:**
```json
{
  "studentId": 101,
  "studentName": "John Doe",
  "academicYearId": 5,
  "academicYearName": "2023-2024",
  "examTermId": 3,
  "examTermName": "First Term",
  "totalMarks": 500.00,
  "obtainedMarks": 425.50,
  "percentage": 85.10,
  "grade": "A",
  "rank": null,
  "isActive": true
}
```

**cURL Example:**
```bash
curl -X GET "http://localhost:8080/api/academic/results/student/101?examTermId=3" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -H "Accept: application/json"
```

---

## Database Queries

### Repository Methods

#### StudentTermResultRepository

1. **findBySectionIdAndExamTerm**
```java
@Query("SELECT str FROM StudentTermResultEntity str " +
       "JOIN FETCH str.student s " +
       "JOIN FETCH str.academicYear ay " +
       "JOIN FETCH str.examTerm et " +
       "WHERE s.standard.id = :standardId " +
       "AND s.section.id = :sectionId " +
       "AND str.id.examTermId = :examTermId " +
       "AND str.deleted = false")
List<StudentTermResultEntity> findBySectionIdAndExamTerm(@Param("standardId") Long standardId,
                                                        @Param("sectionId") Long sectionId,
                                                        @Param("examTermId") Long examTermId);
```

**SQL Equivalent:**
```sql
SELECT str.*, s.*, ay.*, et.*
FROM student_term_result str
INNER JOIN students s ON str.student_id = s.id
INNER JOIN academic_years ay ON str.academic_year_id = ay.id
INNER JOIN exam_terms et ON str.exam_term_id = et.id
WHERE s.standard_id = ?
  AND s.section_id = ?
  AND str.exam_term_id = ?
  AND str.is_deleted = false;
```

2. **findByStudentIdAndExamTerm**
```java
@Query("SELECT str FROM StudentTermResultEntity str " +
       "JOIN FETCH str.student s " +
       "JOIN FETCH str.academicYear ay " +
       "JOIN FETCH str.examTerm et " +
       "WHERE str.id.studentId = :studentId " +
       "AND str.id.examTermId = :examTermId " +
       "AND str.deleted = false")
Optional<StudentTermResultEntity> findByStudentIdAndExamTerm(@Param("studentId") Long studentId,
                                                             @Param("examTermId") Long examTermId);
```

**SQL Equivalent:**
```sql
SELECT str.*, s.*, ay.*, et.*
FROM student_term_result str
INNER JOIN students s ON str.student_id = s.id
INNER JOIN academic_years ay ON str.academic_year_id = ay.id
INNER JOIN exam_terms et ON str.exam_term_id = et.id
WHERE str.student_id = ?
  AND str.exam_term_id = ?
  AND str.is_deleted = false
LIMIT 1;
```

#### ExamWeightageRepository

**findByStandardAndExamTerm**
```java
@Query("SELECT ew FROM ExamWeightageEntity ew " +
       "JOIN FETCH ew.subject s " +
       "JOIN FETCH ew.examTerm et " +
       "WHERE ew.id.standardId = :standardId " +
       "AND ew.id.examTermId = :examTermId " +
       "AND ew.deleted = false " +
       "AND ew.active = true")
List<ExamWeightageEntity> findByStandardAndExamTerm(@Param("standardId") Long standardId,
                                                     @Param("examTermId") Long examTermId);
```

**SQL Equivalent:**
```sql
SELECT ew.*, s.*, et.*
FROM exam_weightage ew
INNER JOIN subjects s ON ew.subject_id = s.id
INNER JOIN exam_terms et ON ew.exam_term_id = et.id
WHERE ew.standard_id = ?
  AND ew.exam_term_id = ?
  AND ew.is_deleted = false
  AND ew.is_active = true;
```

#### StudentExamMarksRepository

**findByStudentIdAndExamId**
```java
@Query("SELECT sem FROM StudentExamMarksEntity sem " +
       "JOIN FETCH sem.student s " +
       "JOIN FETCH sem.examSubject es " +
       "JOIN FETCH es.subject subj " +
       "WHERE sem.student.id = :studentId " +
       "AND es.exam.id = :examId " +
       "AND sem.deleted = false")
List<StudentExamMarksEntity> findByStudentIdAndExamId(@Param("studentId") Long studentId,
                                                       @Param("examId") Long examId);
```

**SQL Equivalent:**
```sql
SELECT sem.*, s.*, es.*, subj.*
FROM student_exam_marks sem
INNER JOIN students s ON sem.student_id = s.id
INNER JOIN exam_subjects es ON sem.exam_subject_id = es.id
INNER JOIN subjects subj ON es.subject_id = subj.id
WHERE sem.student_id = ?
  AND es.exam_id = ?
  AND sem.is_deleted = false;
```

---

## Business Logic

### Result Calculation Process

The `processResults` method performs the following steps:

1. **Fetch Exam Term**
   - Retrieves the exam term entity by ID
   - Validates that the term exists

2. **Get Students**
   - Fetches all students enrolled in the specified section
   - Validates that students exist

3. **Get Weightages**
   - Retrieves configured exam weightages for the standard and term
   - Weightages define the importance/percentage of each subject

4. **Process Each Student**
   - For each student:
     - Fetch all exam marks for the term
     - Apply weightages to calculate weighted marks
     - Calculate total marks and obtained marks
     - Calculate percentage: `(obtainedMarks / totalMarks) * 100`
     - Determine grade based on percentage
     - Save or update the result

### Grade Calculation

The grading scale used:
- **A+**: 90% and above
- **A**: 80% to 89%
- **B**: 70% to 79%
- **C**: 60% to 69%
- **D**: 50% to 59%
- **F**: Below 50%

---

## Testing Examples

### Using Postman

**Collection Structure:**
```
Student Term Results
├── Process Results
├── Get Section Results
└── Get Student Result
```

**Environment Variables:**
```json
{
  "base_url": "http://localhost:8080",
  "auth_token": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "standard_id": "1",
  "section_id": "2",
  "exam_term_id": "3",
  "student_id": "101"
}
```

### Using REST Client (VS Code Extension)

Create a file `student-term-results.http`:

```http
### Variables
@baseUrl = http://localhost:8080
@token = Bearer YOUR_TOKEN_HERE
@standardId = 1
@sectionId = 2
@examTermId = 3
@studentId = 101

### Process Results
POST {{baseUrl}}/api/academic/results/process?standardId={{standardId}}&sectionId={{sectionId}}&examTermId={{examTermId}}
Authorization: {{token}}
Content-Type: application/json

### Get Section Results
GET {{baseUrl}}/api/academic/results/section?standardId={{standardId}}&sectionId={{sectionId}}&examTermId={{examTermId}}
Authorization: {{token}}
Accept: application/json

### Get Student Result
GET {{baseUrl}}/api/academic/results/student/{{studentId}}?examTermId={{examTermId}}
Authorization: {{token}}
Accept: application/json
```

---

## Error Handling

### Common Errors

1. **Exam Term Not Found**
```json
{
  "status": "ERROR",
  "message": "Exam Term not found",
  "timestamp": "2024-02-10T10:30:00"
}
```

2. **No Students Found**
```json
{
  "status": "WARNING",
  "message": "No students found for section 2"
}
```

3. **Result Not Found**
```json
{
  "status": "ERROR",
  "message": "Result not found",
  "timestamp": "2024-02-10T10:30:00"
}
```

4. **No Weightages Configured**
```json
{
  "status": "WARNING",
  "message": "No weightages configured for standard 1 and term 3"
}
```

---

## Integration Examples

### Java Service Integration

```java
@Service
@RequiredArgsConstructor
public class AcademicReportService {
    
    private final StudentTermResultService resultService;
    
    public void generateTermReports(Long standardId, Long sectionId, Long examTermId) {
        // Process results first
        resultService.processResults(standardId, sectionId, examTermId);
        
        // Fetch processed results
        List<StudentTermResultResponseDTO> results = 
            resultService.getSectionResults(standardId, sectionId, examTermId);
        
        // Generate reports
        results.forEach(result -> {
            log.info("Student: {} - Grade: {} - Percentage: {}%", 
                result.getStudentName(), 
                result.getGrade(), 
                result.getPercentage());
        });
    }
}
```

### Scheduled Processing

```java
@Component
public class ResultProcessingScheduler {
    
    @Autowired
    private StudentTermResultService resultService;
    
    @Scheduled(cron = "0 0 2 * * ?") // Run daily at 2 AM
    public void processResults() {
        // Fetch active terms
        List<ExamTerm> activeTerms = getActiveTerms();
        
        activeTerms.forEach(term -> {
            List<Section> sections = getSectionsByTerm(term);
            sections.forEach(section -> {
                try {
                    resultService.processResults(
                        section.getStandardId(), 
                        section.getId(), 
                        term.getId()
                    );
                } catch (Exception e) {
                    log.error("Error processing results for section {}", section.getId(), e);
                }
            });
        });
    }
}
```

---

## Performance Considerations

### Optimization Tips

1. **Batch Processing**
   - Process results for multiple sections in parallel
   - Use batch inserts for better performance

2. **Caching**
   - Cache weightages as they don't change frequently
   - Cache grade scale configurations

3. **Indexing**
   - Ensure proper indexes on foreign keys
   - Index on frequently queried columns (student_id, exam_term_id)

4. **Query Optimization**
   - Use JOIN FETCH to avoid N+1 queries
   - Fetch only required columns when possible

### Recommended Indexes

```sql
-- Student Term Result
CREATE INDEX idx_str_student_term ON student_term_result(student_id, exam_term_id);
CREATE INDEX idx_str_academic_year ON student_term_result(academic_year_id);

-- Student Exam Marks
CREATE INDEX idx_sem_student_exam ON student_exam_marks(student_id, exam_subject_id);

-- Exam Weightage
CREATE INDEX idx_ew_standard_term ON exam_weightage(standard_id, exam_term_id);
```

---

## Additional Resources

### Related Entities

- `StudentTermResultEntity` - Main result entity
- `StudentExamMarksEntity` - Individual exam marks
- `ExamWeightageEntity` - Subject weightage configuration
- `ExamTermEntity` - Exam term definition
- `StudentEntity` - Student information

### Related Services

- `StudentExamMarksService` - For managing exam marks
- `ExamWeightageService` - For managing weightages
- `ReportCardService` - For generating report cards
- `GradeScaleService` - For grade scale configuration

### Configuration

Add to `application.properties`:
```properties
# Result Processing Configuration
academic.results.default-grade-scale=PERCENTAGE
academic.results.enable-auto-processing=true
academic.results.batch-size=50
academic.results.async-processing=true
```

---

## Version History

- **v1.0.0** (2024-02-10) - Initial implementation
  - Basic result processing
  - Section and student result retrieval
  - Grade calculation

---

## Contact & Support

For issues or questions:
- Email: support@example.com
- Slack: #academic-module
- JIRA: SMS-PROJECT

---

*Last Updated: February 10, 2024*
