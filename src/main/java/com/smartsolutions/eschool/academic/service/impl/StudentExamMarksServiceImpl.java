package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.academic.dto.request.StudentExamMarksRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentExamMarksResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentMarkEntryResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.ExamSubjectEntity;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamMarksEntity;
import com.smartsolutions.eschool.academic.mapper.ResultsMapper;
import com.smartsolutions.eschool.academic.repository.ExamSubjectRepository;
import com.smartsolutions.eschool.academic.repository.StudentExamAttendanceRepository;
import com.smartsolutions.eschool.academic.repository.StudentExamMarksRepository;
import com.smartsolutions.eschool.academic.repository.StudentTermResultRepository;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.global.error.AppModule;
import com.smartsolutions.eschool.global.error.BaseErrorCode;
import com.smartsolutions.eschool.global.error.ErrorCategory;
import com.smartsolutions.eschool.global.utils.EntityReferenceValidator;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.service.StudentExamMarksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentExamMarksServiceImpl implements StudentExamMarksService {

    private final StudentExamMarksRepository marksRepository;
    private final ExamSubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final StudentExamAttendanceRepository attendanceRepository;
    private final EntityReferenceValidator entityReferenceValidator;
    private final StudentTermResultRepository termResultRepository;

    @Override
    @Transactional
    public void recordMarks(List<StudentExamMarksRequestDTO> dtos) {
        for (StudentExamMarksRequestDTO dto : dtos) {

            // Look up any existing record (active or soft-deleted) to avoid duplicate key errors
            java.util.Optional<StudentExamMarksEntity> existingOpt =
                    marksRepository.findByStudentIdAndExamSubjectIdIncludeDeleted(
                            dto.getStudentId(), dto.getExamSubjectId());

            if (existingOpt.isPresent()) {
                // Always update the existing row (restores soft-deleted records too)
                StudentExamMarksEntity entity = existingOpt.get();
                entity.setObtainedMarks(dto.getObtainedMarks());
                entity.setGraceMarks(dto.getGraceMarks());
                entity.setLocked(dto.isLocked());
                entity.setRemarks(dto.getRemarks());
                entity.setDeleted(false);          // un-delete if it was soft-deleted
                entity.setDeletedAt(null);
                entity.setActive(dto.getIsActive() == null || dto.getIsActive());
                marksRepository.save(entity);
            } else {
                // No record at all — only insert when there is meaningful data
                boolean hasData = dto.getObtainedMarks() != null
                        || (dto.getGraceMarks() != null
                        && dto.getGraceMarks().compareTo(java.math.BigDecimal.ZERO) != 0)
                        || (dto.getRemarks() != null && !dto.getRemarks().isBlank());

                if (hasData) {
                    StudentExamMarksEntity entity = ResultsMapper.toEntity(dto);
                    entity.setActive(dto.getIsActive() == null || dto.getIsActive());
                    marksRepository.save(entity);
                }
            }
        }
    }

    @Override
    public List<StudentExamMarksResponseDTO> getStudentExamMarksResponse() {

        List<StudentExamMarksEntity> list = marksRepository.findStudentAll();

        return ResultsMapper.toStudentExamMarksResponseList(list);
    }


    @Override
    public List<StudentExamMarksResponseDTO> getByExamSubject(Long examSubjectId) {
        return marksRepository.findByExamSubjectId(examSubjectId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentExamMarksResponseDTO> getStudentMarks(Long studentId, Long examId) {
        return marksRepository.findByStudentIdAndExamId(studentId, examId).stream()
                .map(ResultsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentMarkEntryResponseDTO> getStudentsForMarkEntry(Long examSubjectId) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();

        ExamSubjectEntity examSubject = subjectRepository.findById(examSubjectId)
                .orElseThrow(() -> new RuntimeException("Exam subject not found"));

        Long sectionId = examSubject.getExam().getSection().getId();

        // Fetch all students in the section
        List<StudentEntity> students = studentRepository.findBySectionId(sectionId);

        // Fetch existing marks
        List<StudentExamMarksEntity> existingMarks = marksRepository.findByExamSubjectId(examSubjectId);

        // Fetch attendance status
        List<StudentExamAttendanceEntity> attendanceRecords = attendanceRepository
                .findByExamSubjectIdAndOrganizationId(examSubjectId, orgId);

        return students.stream().map(student -> {
            StudentExamMarksEntity mark = existingMarks.stream()
                    .filter(m -> m.getStudent().getId().equals(student.getId()))
                    .findFirst().orElse(null);

            StudentExamAttendanceEntity attendance = attendanceRecords.stream()
                    .filter(a -> a.getStudent().getId().equals(student.getId()))
                    .findFirst().orElse(null);

            return StudentMarkEntryResponseDTO.builder()
                    .studentId(student.getId())
                    .studentName(
                            student.getFirstName() + " "
                                    + (student.getLastName() != null
                                    ? student.getLastName()
                                    : ""))
                    .studentCode(student.getStudentCode())
                    .attendanceStatus(attendance != null ? attendance.getStatus() : null)
                    .obtainedMarks(mark != null ? mark.getObtainedMarks() : null)
                    .graceMarks(mark != null ? mark.getGraceMarks() : null)
                    .locked(mark != null && mark.isLocked())
                    .remarks(mark != null ? mark.getRemarks() : null)
                    .markId(mark != null ? mark.getId() : null)
                    .active(mark != null ? mark.isActive() : true)
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentExamMarksResponseDTO> searchMarks(
            Long campusId, Long standardId, Long sectionId, Long examId, String keyword) {

        List<StudentExamMarksEntity> list = marksRepository.searchMarks(
                campusId, standardId, sectionId, examId, keyword);

        return ResultsMapper.toStudentExamMarksResponseList(list);
    }

//    @Override
//    @Transactional
//    public void deleteMark(Long id) {
//        // Load mark with full relations to get student + examTerm info
//        StudentExamMarksEntity mark = marksRepository.findByIdWithRelations(id)
//                .orElseThrow(() -> new RuntimeException("Student marks not found"));
//
//        // Block deletion if a StudentTermResult already exists for this student + exam term
//        Long studentId = mark.getStudent().getId();
//        Long examTermId = mark.getExamSubject().getExam().getExamTerm().getId();
//        Long examSubjectId = mark.getExamSubject().getId();
//
//        if (termResultRepository.existsByStudent_IdAndExamTerm_Id(studentId, examTermId)) {
//            throw new ApiException(
//                new BaseErrorCode() {
//                    @Override public AppModule module()
//                    { return AppModule.COMMON; }
//
//                    @Override public ErrorCategory category()
//                    { return ErrorCategory.BUSINESS; }
//                    @Override public int number()
//                    { return 999; }
//                    @Override public String message()
//                    {
//                        return "Unable to delete this Student Exam Mark. A Term Result has already been generated for this student. Please remove the Term Result first before attempting deletion.";
//                    }
//                },
//                HttpStatus.CONFLICT
//            );
//        }
//
//        entityReferenceValidator.ensureNotReferenced(StudentExamMarksEntity.class, id);
//        marksRepository.softDeleteById(id);
//    }
//}

    @Override
    @Transactional
    public void deleteMark(Long id) {

        // 1. Load entity with relations
        StudentExamMarksEntity mark = marksRepository.findByIdWithRelations(id)
                .orElseThrow(() -> new RuntimeException("Student marks not found"));

        Long studentId = mark.getStudent().getId();
        Long examTermId = mark.getExamSubject().getExam().getExamTerm().getId();
        Long examSubjectId = mark.getExamSubject().getId();

        // 2. BLOCK if Term Result already generated
        if (termResultRepository.existsByStudent_IdAndExamTerm_Id(studentId, examTermId)) {
            throw new ApiException(
                    new BaseErrorCode() {
                        @Override
                        public AppModule module() {
                            return AppModule.COMMON;
                        }

                        @Override
                        public ErrorCategory category() {
                            return ErrorCategory.BUSINESS;
                        }

                        @Override
                        public int number() {
                            return 999;
                        }

                        @Override
                        public String message() {
                            return "Cannot delete: Term Result already generated for this student.";
                        }
                    },
                    HttpStatus.CONFLICT
            );
        }

        // 3. BLOCK if Attendance exists
        if (attendanceRepository.existsByExamSubject_Id(examSubjectId)) {
            throw new ApiException(
                    new BaseErrorCode() {
                        @Override
                        public AppModule module() {
                            return AppModule.COMMON;
                        }

                        @Override
                        public ErrorCategory category() {
                            return ErrorCategory.BUSINESS;
                        }

                        @Override
                        public int number() {
                            return 998;
                        }

                        @Override
                        public String message() {
                            return "Cannot delete: Attendance already exists for this exam subject.";
                        }
                    },
                    HttpStatus.CONFLICT
            );
        }

        // 4. Optional: generic reference check
        entityReferenceValidator.ensureNotReferenced(StudentExamMarksEntity.class, id);

        // 5. Soft delete
        marksRepository.softDeleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentExamMarksResponseDTO> getMarksByFilters(
            Long studentId, Long campusId, Long standardId, Long sectionId) {
        List<StudentExamMarksEntity> list = marksRepository.findMarksByFilters(
                studentId, campusId, standardId, sectionId);
        return ResultsMapper.toStudentExamMarksResponseList(list);
    }
}


