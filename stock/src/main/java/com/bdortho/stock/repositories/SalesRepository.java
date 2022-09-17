package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.SalesModel;

@Repository
public interface SalesRepository extends JpaRepositoryImplementation<SalesModel, Long> {

}
