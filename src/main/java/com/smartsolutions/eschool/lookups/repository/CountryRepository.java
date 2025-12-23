package com.smartsolutions.eschool.lookups.repository;

import com.smartsolutions.eschool.lookups.model.CountryEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Long>  {
    @Query("SELECT c FROM CountryEntity c")
    List<CountryEntity> findAllCountries();

}
