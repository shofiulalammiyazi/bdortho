package com.bdortho.stock.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bdortho.stock.model.DesignationModel;
import com.bdortho.stock.repositories.DesignationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DesignationService {
	
	private final DesignationRepository designationRepository;
		
	public DesignationModel save(DesignationModel designationModel) {
		designationRepository.save(designationModel);
		return designationModel;
	}
	
	public DesignationModel getById(Long id) {
		DesignationModel designation = designationRepository.getOne(id);
		return  designation;
	}
	
	public List<DesignationModel> getAll() {
		List<DesignationModel> designation = designationRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
		return designation;
	}
	
	public DesignationModel delete(DesignationModel designation) {
		designationRepository.delete(designation);
		return designation;
	}


}
