package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.LanguageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {

    @Query("""
            SELECT l FROM LanguageEntity l
            WHERE l.id = :id
            """)
    Optional<LanguageEntity> findByIdJpql(@Param("id") Long id);

    @Query("""
            SELECT l FROM LanguageEntity l
            """)
    Page<LanguageEntity> findAllJpql(Pageable pageable);

    @Query("""
            SELECT l FROM LanguageEntity l
            WHERE (:keyword IS NULL OR :keyword = ''
                OR LOWER(l.isoCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(l.name) LIKE LOWER(CONCAT('%', :keyword, '%')))
            """)
    List<LanguageEntity> searchByKeyword(@Param("keyword") String keyword);
}
