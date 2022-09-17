package com.bdortho.stock.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Timestamp updatedAt;
	
	@Transient
	private VairiantModel vairiantModel;
	
	public ProductModel() {
		this.updatedAt = new Timestamp(System.currentTimeMillis());
	}

}
