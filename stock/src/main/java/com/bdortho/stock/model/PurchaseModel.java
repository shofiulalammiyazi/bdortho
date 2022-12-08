package com.bdortho.stock.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

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

	@Transient
	private List<String> product;

	@Transient
	private String qty;

	@Transient
	private String price;

	@Transient
	private String discount;

	@Transient
	private String total;

	@OneToMany(mappedBy = "purchaseModel")
	private List<PurchaseDetails> PurchaseDetails;
	
	private Timestamp updatedAt;
	public PurchaseModel() {
		this.updatedAt = new Timestamp(System.currentTimeMillis());
	}

}
