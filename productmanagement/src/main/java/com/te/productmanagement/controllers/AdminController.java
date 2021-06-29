package com.te.productmanagement.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


import com.te.productmanagement.beans.AdminInfoBean;
import com.te.productmanagement.beans.ProductInfoBean;
import com.te.productmanagement.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	private ProductService  service;

	
	
	@GetMapping("/login")
	public String getAdminForm() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map) {
		AdminInfoBean infoBean = service.authenticate(id, password);
		System.out.println(infoBean);
		if (infoBean != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", infoBean);
//			session.setMaxInactiveInterval(3600);
			map.addAttribute("name", infoBean.getName());
			return "home";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout successfull");
		return "login";
	}// logout

	@GetMapping("/deleteform")
	public String getDeleteForm(@SessionAttribute(name = "loggedIn", required = false) ProductInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			return "delete";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}
	}
	@GetMapping("/delete")
	public String deleteData(int id, @SessionAttribute(name = "loggedIn", required = false) ProductInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			if (service.deleteProductData(id)) {
				map.addAttribute("msg", "Data Deleted successfully for id : " + id);
			} else {
				map.addAttribute("msg", "Could not find Record for id : " + id);
			}
			return "delete";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}

	}
	
	@GetMapping("/addform")
	public String getAddFrom(@SessionAttribute(name = "loggedIn", required = false) AdminInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			return "add";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}

	}
	@GetMapping("/add")
	public String addProduct(ProductInfoBean productInfoBean,
			@SessionAttribute(name = "loggedIn", required = false) AdminInfoBean infoBean, ModelMap map) {
		if (infoBean != null) {
			if (service.addProduct(productInfoBean)) {
				map.addAttribute("msg", "Successfully Inserted");
			} else {
				map.addAttribute("msg", "Failed to Insert");
			}
			return "add";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}

	}
	@GetMapping("/updateEmployeeform")
	public String getUpadatePage(@SessionAttribute(name = "loggedIn", required = false) ProductInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			map.addAttribute("id", infoBean);
			return "update";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";

		}
	}
	@PostMapping("/update")
	public String updateEmployeeData(@SessionAttribute(name = "loggedIn", required = false) ProductInfoBean infoBean,
			ModelMap map,  ProductInfoBean productInfoBean) {
		if (infoBean != null) {
			if (service.updateRecord(infoBean)) {
				map.addAttribute("msg", "Updated Successfully");
				map.addAttribute("id", productInfoBean);
			} else {
				map.addAttribute("msg", "Updation Failed");
				map.addAttribute("id", infoBean);
			}
			return "update";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}
	}
	
	@GetMapping("/all")
	public String getAllRecords(@SessionAttribute(name = "loggedIn", required = false) ProductInfoBean infoBean,
			ModelMap map) {
		if (infoBean != null) {
			List<ProductInfoBean> productInfoBeans = service.getAllProduct();
			if (productInfoBeans != null) {
				
				map.addAttribute("list", productInfoBeans);
			}else {
				map.addAttribute("errMsg", "No Records Found");
			}
			map.addAttribute("name", infoBean.getPname());	
			return "home";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "login";
		}
	}
	
	
	
	
	

}
