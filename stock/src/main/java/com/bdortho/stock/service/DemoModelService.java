package com.bdortho.stock.service;

import org.springframework.stereotype.Service;

import com.bdortho.stock.model.DemoModel;
import com.bdortho.stock.repositories.DemoModelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DemoModelService {
	
	private final DemoModelRepository demoModelRepository;
	
	public DemoModel save(DemoModel demoModel) {
		demoModelRepository.save(demoModel);
		return demoModel;
	}
	
	public DemoModel getById(Long id) {
		DemoModel model = demoModelRepository.getOne(id);
		return  model;
	}
}
