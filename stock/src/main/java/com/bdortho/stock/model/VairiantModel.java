package com.bdortho.stock.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class VairiantModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long productId;
	private boolean isProduct;
	
	private String name;
	private String uom;
	private String type;
	private String product_sub_type;
	private String size;
	
	private Timestamp updatedAt;
	
	public VairiantModel() {
		this.updatedAt = new Timestamp(System.currentTimeMillis());
	}

}
