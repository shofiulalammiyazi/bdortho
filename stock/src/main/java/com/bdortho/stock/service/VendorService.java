package com.bdortho.stock.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bdortho.stock.model.VendorModel;
import com.bdortho.stock.repositories.VendorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendorService {

	private final VendorRepository vendorRepository;
	
	public VendorModel save(VendorModel vendorModel) {
		vendorRepository.save(vendorModel);
		return vendorModel;
	}
	
	public VendorModel getById(Long id) {
		VendorModel vendorModel = vendorRepository.getOne(id);
		return  vendorModel;
	}
	
	public List<VendorModel> getAll() {
		List<VendorModel> vendorModel = vendorRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
		return vendorModel;
	}
	
	public VendorModel delete(VendorModel vendorModel) {
		vendorRepository.delete(vendorModel);
		return vendorModel;
	}

}
