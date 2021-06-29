package com.te.productmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.te.productmanagement.beans.AdminInfoBean;
import com.te.productmanagement.beans.ProductInfoBean;
import com.te.productmanagement.customexception.LoginException;

@Repository
public class ProductDAOHibernateImplementation implements ProductDAO {

	@Override
	public AdminInfoBean authenticate(int id, String password) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		AdminInfoBean infoBean = manager.find(AdminInfoBean.class, id);

		if (infoBean != null) {
			if (infoBean.getPassword().equals(password)) {
				return infoBean;
			} else {
				throw new LoginException("Password is wrong");				
			}
		} else {
			throw new LoginException("Invalid ID");
		}

	}

	@Override
	public boolean deleteProductData(int id) {
		boolean isDeleted = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			ProductInfoBean infoBean = manager.find(ProductInfoBean.class, id);
			manager.remove(infoBean);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		return isDeleted;
	}

	@Override
	public boolean addProduct(ProductInfoBean productInfoBean) {
		boolean isInserted = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(productInfoBean);
			transaction.commit();
			isInserted = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isInserted;
	}

	@Override
	public boolean updateRecord(ProductInfoBean productInfoBean) {
		
		boolean isUpdated = false;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			ProductInfoBean actualInfo = manager.find(ProductInfoBean.class, productInfoBean.getPid());

			if (productInfoBean.getPname() != null && productInfoBean.getPname() != "") {
				actualInfo.setPname(productInfoBean.getPname());
			}

			if (productInfoBean.getMfd() != null) {
				actualInfo.setMfd(productInfoBean.getMfd());
			}
			if (productInfoBean.getExp() != null) {
				actualInfo.setExp(productInfoBean.getExp());
			}
			if (productInfoBean.getPrice() >0) {
				actualInfo.setPrice(productInfoBean.getPrice());
			}
			if (productInfoBean.getQuant() >0) {
				actualInfo.setQuant(productInfoBean.getQuant());
			}
			

			

			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isUpdated;
		
	}

	@Override
	public List<ProductInfoBean> getAllProduct() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from EmployeeInfoBean");
		ArrayList<ProductInfoBean> employeeInfoBeans = new ArrayList<ProductInfoBean>();
		try {
			employeeInfoBeans = (ArrayList<ProductInfoBean>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			employeeInfoBeans = null;
		}

		return employeeInfoBeans;
	}
}


