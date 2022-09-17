package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.DesignationModel;

@Repository
public interface DesignationRepository extends JpaRepositoryImplementation<DesignationModel, Long> {

}
