package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.DesignationModel;

@Repository
public interface DesignationRepository extends JpaRepository<DesignationModel, Long> {

}
