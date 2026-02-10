package com.smartsolutions.eschool.academic.facade;

import com.smartsolutions.eschool.academic.dto.request.StandardSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.SubjectGroupRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.SubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StandardSubjectResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.SubjectGroupResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.SubjectResponseDTO;
import com.smartsolutions.eschool.academic.service.StandardSubjectService;
import com.smartsolutions.eschool.academic.service.SubjectGroupService;
import com.smartsolutions.eschool.academic.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class CoreAcademicFacade {

    private final SubjectGroupService subjectGroupService;
    private final SubjectService subjectService;
    private final StandardSubjectService standardSubjectService;

    // Subject Group
    public SubjectGroupResponseDTO createGroup(SubjectGroupRequestDTO dto) { return subjectGroupService.create(dto); }
    public SubjectGroupResponseDTO updateGroup(Long id, SubjectGroupRequestDTO dto) { return subjectGroupService.update(id, dto); }
    public SubjectGroupResponseDTO getGroupById(Long id) { return subjectGroupService.getById(id); }
    public List<SubjectGroupResponseDTO> getAllActiveGroups() { return subjectGroupService.getAllActive(); }
    public void deleteGroup(Long id) { subjectGroupService.delete(id); }

    // Subject
    public SubjectResponseDTO createSubject(SubjectRequestDTO dto) { return subjectService.create(dto); }
    public SubjectResponseDTO updateSubject(Long id, SubjectRequestDTO dto) { return subjectService.update(id, dto); }
    public SubjectResponseDTO getSubjectById(Long id) { return subjectService.getById(id); }
    public List<SubjectResponseDTO> getAllActiveSubjects() { return subjectService.getAllActive(); }
    public List<SubjectResponseDTO> getSubjectsByGroup(Long groupId) { return subjectService.getByGroupId(groupId); }
    public void deleteSubject(Long id) { subjectService.delete(id); }

    // Standard Subject Assignment
    public StandardSubjectResponseDTO assignSubjectToStandard(StandardSubjectRequestDTO dto) { return standardSubjectService.assign(dto); }
    public List<StandardSubjectResponseDTO> getSubjectsByStandardAndYear(Long standardId, Long academicYearId) { return standardSubjectService.getByStandardAndYear(standardId, academicYearId); }
    public void unassignSubjectFromStandard(Long standardId, Long subjectId, Long academicYearId) { standardSubjectService.unassign(standardId, subjectId, academicYearId); }
}
