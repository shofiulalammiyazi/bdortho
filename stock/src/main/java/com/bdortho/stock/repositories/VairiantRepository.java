package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.VairiantModel;

@Repository
public interface VairiantRepository extends JpaRepository<VairiantModel, Long> {

}
