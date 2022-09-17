package com.bdortho.stock.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bdortho.stock.model.CompanyModel;
import com.bdortho.stock.repositories.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanySevice {
	
    private final CompanyRepository companyRepository;
	
	public CompanyModel save(CompanyModel CompanyModel) {
		companyRepository.save(CompanyModel);
		return CompanyModel;
	}
	
	public CompanyModel getById(Long id) {
		CompanyModel company = companyRepository.getOne(id);
		return  company;
	}
	
	public List<CompanyModel> getAll() {
		List<CompanyModel> companies = companyRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
		return companies;
	}
	
	public CompanyModel delete(CompanyModel company) {
		companyRepository.delete(company);
		return company;
	}

}
