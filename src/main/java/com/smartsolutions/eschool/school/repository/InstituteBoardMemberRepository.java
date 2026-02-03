package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteBoardMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteBoardMemberRepository extends JpaRepository<InstituteBoardMemberEntity, Long> {

    @Query("""
            SELECT b FROM InstituteBoardMemberEntity b
            WHERE b.id = :id
            """)
    Optional<InstituteBoardMemberEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT b FROM InstituteBoardMemberEntity b
            """)
    List<InstituteBoardMemberEntity> findAllJpql();

    @Query("""
            SELECT b FROM InstituteBoardMemberEntity b
            WHERE b.institute.id = :instituteId
            """)
    List<InstituteBoardMemberEntity> findByInstituteId(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT b FROM InstituteBoardMemberEntity b
            WHERE b.isActive = true
            """)
    List<InstituteBoardMemberEntity> findAllActive();

    @Query("""
            SELECT b FROM InstituteBoardMemberEntity b
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(b.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(b.role) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(b.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(b.contactNumber) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteBoardMemberEntity> searchByKeyword(@Param("keyword") String keyword);
}
