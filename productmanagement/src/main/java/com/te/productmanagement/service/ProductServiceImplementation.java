package com.te.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.productmanagement.beans.AdminInfoBean;
import com.te.productmanagement.beans.ProductInfoBean;
import com.te.productmanagement.dao.ProductDAO;

@Service
public class ProductServiceImplementation implements ProductService{

	
	@Autowired
	ProductDAO dao;
	
	@Override
	public AdminInfoBean authenticate(int id, String password) {
		
		
		
		if (id <= 0) {
			return null;
		} else {
			return dao.authenticate(id, password);
		}
	}

	@Override
	public boolean deleteProductData(int id) {
		
		return dao.deleteProductData(id);
	}

	@Override
	public boolean addProduct(ProductInfoBean productInfoBean) {
		
	return	dao.addProduct(productInfoBean);
		
	}

	@Override
	public boolean updateRecord(ProductInfoBean productInfoBean) {
		
		return dao.updateRecord(productInfoBean);
	}

	@Override
	public List<ProductInfoBean> getAllProduct() {
		
		return dao.getAllProduct();
	}

}
