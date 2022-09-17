package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.PurchaseModel;

@Repository
public interface PurchaseRepository extends JpaRepositoryImplementation<PurchaseModel, Long> {

}
