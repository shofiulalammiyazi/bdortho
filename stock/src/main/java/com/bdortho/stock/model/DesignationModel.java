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
public class DesignationModel {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private Timestamp updatedAt;
	
	public DesignationModel() {
		this.updatedAt = new Timestamp(System.currentTimeMillis());
	}

}
