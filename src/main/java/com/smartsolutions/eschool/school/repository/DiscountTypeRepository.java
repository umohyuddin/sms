package com.smartsolutions.eschool.school.repository;

import com.smartsolutions.eschool.school.model.DiscountTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface DiscountTypeRepository extends JpaRepository<DiscountTypeEntity, Long> {

}


