package com.bdortho.stock.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bdortho.stock.model.ProductModel;
import com.bdortho.stock.repositories.ProductRepository;
import com.bdortho.stock.repositories.VairiantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	private final VairiantRepository vairiantRepository;
	
	public ProductModel save(ProductModel productModel) {
		productRepository.save(productModel);
		
		productModel.getVairiantModel().setProductId(productModel.getId());
		productModel.getVairiantModel().setProduct(true);
		
		vairiantRepository.save(productModel.getVairiantModel());
		return productModel;
	}
	
	public ProductModel getById(Long id) {
		ProductModel product = productRepository.getOne(id);
		return  product;
	}
	
	public List<ProductModel> getAll() {
		List<ProductModel> product = productRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
		return product;
	}
	
	public ProductModel delete(ProductModel product) {
		productRepository.delete(product);
		return product;
	}


}
