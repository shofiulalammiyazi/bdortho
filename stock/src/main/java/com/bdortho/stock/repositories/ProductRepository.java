package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

        //JpaRepositoryImplementation

}
