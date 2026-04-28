package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

  @Query("""
      SELECT c
      FROM CountryEntity c
      WHERE c.id = :id
        AND c.deletedAt IS NULL
      """)
  Optional<CountryEntity> findByIdAndDeletedFalse(@Param("id") Long id);

  @Query("""
      SELECT c
      FROM CountryEntity c
      WHERE c.deletedAt IS NULL
      ORDER BY c.countryName ASC
      """)
  List<CountryEntity> findAllNotDeleted();

  @Query("""
      SELECT c
      FROM CountryEntity c
      WHERE (LOWER(c.countryName) LIKE LOWER(CONCAT('%', :keyword, '%'))
         OR LOWER(c.countryCode) LIKE LOWER(CONCAT('%', :keyword, '%')))
        AND c.deletedAt IS NULL
      ORDER BY c.countryName ASC
      """)
  List<CountryEntity> searchByKeyword(@Param("keyword") String keyword);

  @Modifying
  @Transactional
  @Query("""
      UPDATE CountryEntity c
      SET c.deletedAt = CURRENT_TIMESTAMP
      WHERE c.id = :id
      """)
  int softDeleteById(@Param("id") Long id);

  @Query("SELECT COUNT(c) FROM CountryEntity c WHERE c.deletedAt IS NULL")
  Long countAllNotDeleted();

  @Query("SELECT (COUNT(c) > 0) FROM CountryEntity c WHERE c.countryCode = :countryCode AND c.deletedAt IS NULL")
  boolean existsByCountryCode(@Param("countryCode") String countryCode);

  @Query("SELECT (COUNT(c) > 0) FROM CountryEntity c WHERE c.countryCode = :countryCode AND c.id <> :id AND c.deletedAt IS NULL")
  boolean existsByCountryCodeAndIdNot(@Param("countryCode") String countryCode, @Param("id") Long id);
}
