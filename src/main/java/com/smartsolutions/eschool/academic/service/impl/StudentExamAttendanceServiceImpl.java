package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.academic.dto.request.StudentExamAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentExamAttendanceResponseDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import com.smartsolutions.eschool.academic.mapper.ExamAssessmentMapper;
import com.smartsolutions.eschool.academic.repository.StudentExamAttendanceRepository;
import com.smartsolutions.eschool.academic.service.StudentExamAttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentExamAttendanceServiceImpl implements StudentExamAttendanceService {

    private final StudentExamAttendanceRepository studentExamAttendanceRepository;

    @Override
    @Transactional
    public List<StudentExamAttendanceResponseDTO> markAttendance(List<StudentExamAttendanceRequestDTO> requests,
            Long orgId) {
        log.info("Service: Marking attendance for {} students in organization: {}", requests.size(), orgId);
        List<StudentExamAttendanceEntity> resultEntities = new ArrayList<>();

        for (StudentExamAttendanceRequestDTO request : requests) {
            log.debug("Service: Processing attendance for student: {}, examSubject: {}", request.getStudentId(),
                    request.getExamSubjectId());

            StudentExamAttendanceEntity existing = studentExamAttendanceRepository
                    .findByExamSubjectIdAndStudentIdAndOrganizationId(
                            request.getExamSubjectId(), request.getStudentId(), orgId);

            if (existing != null) {
                log.debug("Service: Updating existing attendance record for student: {}", request.getStudentId());
                existing.setStatus(request.getStatus());
                resultEntities.add(studentExamAttendanceRepository.save(existing));
            } else {
                log.debug("Service: Creating new attendance record for student: {}", request.getStudentId());
                StudentExamAttendanceEntity entity = ExamAssessmentMapper.toEntity(request);
                entity.setOrganizationId(orgId);
                resultEntities.add(studentExamAttendanceRepository.save(entity));
            }
        }

        log.info("Service: Successfully marked attendance for {} students", resultEntities.size());
        return resultEntities.stream()
                .map(ExamAssessmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentExamAttendanceResponseDTO> getAttendanceByExamSubject(Long examSubjectId, Long orgId) {
        log.info("Service: Fetching attendance for examSubject: {}, orgId: {}", examSubjectId, orgId);
        List<StudentExamAttendanceEntity> entities = studentExamAttendanceRepository
                .findByExamSubjectIdAndOrganizationId(examSubjectId, orgId);
        log.info("Service: Found {} attendance records", entities.size());
        return ExamAssessmentMapper.toAttendanceResponseList(entities);
    }
}
