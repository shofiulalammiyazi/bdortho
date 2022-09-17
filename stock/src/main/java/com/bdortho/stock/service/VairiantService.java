package com.bdortho.stock.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bdortho.stock.model.VairiantModel;
import com.bdortho.stock.repositories.VairiantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VairiantService {

	private final VairiantRepository vairiantRepository;
	
	public VairiantModel save(VairiantModel vairiantModel) {
		vairiantRepository.save(vairiantModel);
		return vairiantModel;
	}
	
	public VairiantModel getById(Long id) {
		VairiantModel vairiant = vairiantRepository.getOne(id);
		return  vairiant;
	}
	
	public List<VairiantModel> getAll() {
		List<VairiantModel> vairiant = vairiantRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
		return vairiant;
	}
	
	public VairiantModel delete(VairiantModel vairiant) {
		vairiantRepository.delete(vairiant);
		return vairiant;
	}

}
