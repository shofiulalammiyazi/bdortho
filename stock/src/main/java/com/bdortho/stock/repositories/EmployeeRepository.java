package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepositoryImplementation<EmployeeModel, Long> {

}
