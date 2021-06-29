package com.te.productmanagement.service;


import java.util.List;

import com.te.productmanagement.beans.AdminInfoBean;
import com.te.productmanagement.beans.ProductInfoBean;

public interface ProductService {
	
	public AdminInfoBean authenticate(int id, String password);
	
	public boolean deleteProductData(int id);
	
//	public ProductInfoBean getProductData(int id);

	public boolean addProduct(ProductInfoBean productInfoBean);

	public boolean updateRecord(ProductInfoBean productInfoBean);
	
	public List<ProductInfoBean> getAllProduct();

}
