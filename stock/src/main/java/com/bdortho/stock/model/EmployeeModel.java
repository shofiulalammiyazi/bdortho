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
public class EmployeeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String employee_id;
	private String full_name;
	private String user_name;
	private String password;
	private Timestamp updatedAt;
	
	public EmployeeModel() {
		this.updatedAt = new Timestamp(System.currentTimeMillis());
	}
	

}
