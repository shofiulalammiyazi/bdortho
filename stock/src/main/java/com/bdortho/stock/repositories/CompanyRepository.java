package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.CompanyModel;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

}
