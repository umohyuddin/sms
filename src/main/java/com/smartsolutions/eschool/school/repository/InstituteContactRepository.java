package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.InstituteContactEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituteContactRepository extends JpaRepository<InstituteContactEntity, Long> {

    @Query("""
            SELECT c FROM InstituteContactEntity c
            WHERE c.id = :id
            """)
    Optional<InstituteContactEntity> findByIdJpql(@Param("id") Long id);


    @Query("""
    SELECT c FROM InstituteContactEntity c
    WHERE c.id = :id AND c.institute.id = :instituteId
""")
    Optional<InstituteContactEntity> findByIdAndOrganizationId(
            @Param("id") Long id,
            @Param("instituteId") Long instituteId
    );

    @Query("""
            SELECT c FROM InstituteContactEntity c
            """)
    Page<InstituteContactEntity> findAllJpql(Pageable pageable);

    @Query("""
            SELECT c FROM InstituteContactEntity c
            WHERE c.institute.id = :instituteId
            """)
    Page<InstituteContactEntity> findByInstituteId(@Param("instituteId") Long instituteId, Pageable pageable);

    @Query("""
            SELECT c FROM InstituteContactEntity c
            WHERE c.institute.id = :instituteId
            """)
    List<InstituteContactEntity> findByInstituteIdList(@Param("instituteId") Long instituteId);

    @Query("""
            SELECT c FROM InstituteContactEntity c
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(c.contactPersonName) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(c.role) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(c.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(c.phone) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<InstituteContactEntity> searchByKeyword(@Param("keyword") String keyword);
}
