package com.bdortho.stock.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bdortho.stock.model.CustomerModel;
import com.bdortho.stock.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
	
	private final  CustomerRepository customerRepository;
	
	public CustomerModel save(CustomerModel CustomerModel) {
		customerRepository.save(CustomerModel);
		return CustomerModel;
	}
	
	public CustomerModel getById(Long id) {
		CustomerModel customerModel = customerRepository.getOne(id);
		return  customerModel;
	}

	
	
	public List<CustomerModel> getAll() {
		List<CustomerModel> customer = customerRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
		return customer;
	}
	
	public CustomerModel delete(CustomerModel customer) {
		customerRepository.delete(customer);
		return customer;
	}

}
