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
public class PurchaseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String supplier;
	private String address;
	private String invoice_no;
	private String purchase_no;
	private String date;
	private String purchase_id;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<PurchaseDitalsModel> purchaseDitalsModel;
	
	private Timestamp updatedAt;
	public PurchaseModel() {
		this.updatedAt = new Timestamp(System.currentTimeMillis());
	}

}
