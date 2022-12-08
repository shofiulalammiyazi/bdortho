package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.PurchaseModel;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseModel, Long> {

}
