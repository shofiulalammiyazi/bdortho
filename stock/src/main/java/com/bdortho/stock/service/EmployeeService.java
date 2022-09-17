package com.bdortho.stock.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bdortho.stock.model.EmployeeModel;
import com.bdortho.stock.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
		
	public EmployeeModel save(EmployeeModel employeeModel) {
		employeeRepository.save(employeeModel);
		return employeeModel;
	}
	
	public EmployeeModel getById(Long id) {
		EmployeeModel employee = employeeRepository.getOne(id);
		return  employee;
	}
	
	public List<EmployeeModel> getAll() {
		List<EmployeeModel> employee = employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
		return employee;
	}
	
	public EmployeeModel delete(EmployeeModel employee) {
		employeeRepository.delete(employee);
		return employee;
	}


}
