package com.springboot.basic.repository;

import com.springboot.basic.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

     EmployeeEntity findByName(String name);
}
