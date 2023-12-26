package com.example.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.DAO.AddressDAO;
import com.example.store.DAO.AdminDAO;
import com.example.store.DAO.CustomerDAO;
import com.example.store.DAO.UserDAO;
import com.example.store.model.Admin;
import com.example.store.model.Customer;
import com.example.store.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	AddressDAO addressDAO;
	
	
	// create
	public Customer createCustomer(Customer customer)
	{
		customer.setRole("customer");
		customer.setCarts(new ArrayList<>());
		customer.setFeedbacks( new ArrayList<>());
		customer.setOrders(new ArrayList<>());
		customerDAO.save(customer);
		return customer;
	}
	public Admin createAdmin(int id,Admin admin) 
	{
		User user= userDAO.getById(id);
		if(user.getRole().equals("admin"))
		{
			admin.setRole("admin");
			adminDAO.save(admin);
			return admin;
		}
		else
			// xu ly neu id truyen vao khong phai cua admin vi khong co quyen
			return null;
	}
	//Search
	public List<Customer> searchCustomerByEmail(String string)
	{
		if(string.equals("")||string.equals(null))
			return customerDAO.findAll();
		else
			return customerDAO.searchCustomerByEmail(string);
	}
	
}
