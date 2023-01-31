package com.example.enesbaskale.data.repository;

import com.example.enesbaskale.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//JpaRepository>CrudRepository
@Repository
public interface EmployeeRepository extends CrudRepository <EmployeeEntity, Long>{
}

