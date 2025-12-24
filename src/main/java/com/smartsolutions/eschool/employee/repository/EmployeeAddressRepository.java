package com.smartsolutions.eschool.employee.repository;

import com.smartsolutions.eschool.employee.model.EmployeeAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddressEntity, Long> {

    @Query("""
            SELECT ea
            FROM EmployeeAddressEntity ea
            JOIN FETCH ea.city
            LEFT JOIN FETCH ea.province
            JOIN FETCH ea.country
            WHERE ea.employee.id = :employeeId
            """)
    List<EmployeeAddressEntity> findEmployeeAddresses(@Param("employeeId") Long employeeId);

    @Query("""
            SELECT ea
            FROM EmployeeAddressEntity ea
            JOIN FETCH ea.city
            LEFT JOIN FETCH ea.province
            JOIN FETCH ea.country
            WHERE ea.id = :addressId
            """)
    Optional<EmployeeAddressEntity> findByAddressId(@Param("addressId") Long addressId);


}
