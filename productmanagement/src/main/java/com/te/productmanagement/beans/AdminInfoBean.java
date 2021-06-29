package com.te.productmanagement.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="admin")
public class AdminInfoBean implements Serializable {
	
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String password;
}
