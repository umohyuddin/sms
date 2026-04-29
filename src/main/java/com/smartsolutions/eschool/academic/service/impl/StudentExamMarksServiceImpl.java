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
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.util.SecurityUtils;
import com.smartsolutions.eschool.academic.service.StudentExamMarksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

        @Override
        @Transactional
        public void recordMarks(List<StudentExamMarksRequestDTO> dtos) {
                for (StudentExamMarksRequestDTO dto : dtos) {
                        // Validate presence check would go here...

                        StudentExamMarksEntity entity = ResultsMapper.toEntity(dto);
                        // organizationId is handled automatically by AuditableEntity
                        marksRepository.save(entity);
                }
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
                                        .build();
                }).collect(Collectors.toList());
        }
}
