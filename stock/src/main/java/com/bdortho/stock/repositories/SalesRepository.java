package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.SalesModel;

@Repository
public interface SalesRepository extends JpaRepository<SalesModel, Long> {

}
