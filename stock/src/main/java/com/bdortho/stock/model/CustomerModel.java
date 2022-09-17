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
public class CustomerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fullName;
	private String address;
	private String mobile;
	private String representative;
	private String mobile1;
	private String type;
	private Timestamp updatedAt;
	
	public CustomerModel() {
		this.updatedAt = new Timestamp(System.currentTimeMillis());
	}
	

}
