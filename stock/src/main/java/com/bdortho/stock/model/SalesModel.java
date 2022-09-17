package com.bdortho.stock.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class SalesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String supplier;
	private String address;
	private String invoice_no;
	private String purchase_no;
	private String date;
	private String sales_id;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<SalesDetailsModel> salesDetailsModel;
	
	private Timestamp updatedAt;
	public SalesModel() {
		this.updatedAt = new Timestamp(System.currentTimeMillis());
	}

}
