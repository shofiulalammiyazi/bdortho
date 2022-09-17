package com.bdortho.stock.service;

import org.springframework.stereotype.Service;

import com.bdortho.stock.model.SalesModel;
import com.bdortho.stock.repositories.SalesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalesService {
	
    private final SalesRepository salesRepository;
	
	public SalesModel save(SalesModel salesModel) {
		salesRepository.save(salesModel);
		return salesModel;
	}
	
	public SalesModel getById(Long id) {
		SalesModel Sales = salesRepository.getOne(id);
		return  Sales;
	}

}
