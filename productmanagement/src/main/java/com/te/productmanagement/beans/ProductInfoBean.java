package com.te.productmanagement.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="product")
public class ProductInfoBean implements Serializable{
	
	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	@Column
	private Date mfd;
	@Column
	private Date exp;
	@Column
	private int price;
	@Column
	private int quant;

}
