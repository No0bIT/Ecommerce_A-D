package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.DAO.AdminDAO;
import com.example.store.DAO.CustomerDAO;
import com.example.store.DAO.UserDAO;
import com.example.store.model.Admin;
import com.example.store.model.Customer;
import com.example.store.model.User;
import com.example.store.service.UserService;

import jakarta.websocket.server.PathParam;

@RequestMapping("/api/customer")
@RestController
public class CustomerController {

	@Autowired
	UserService userService;

	
//	
//	@PostMapping("/createAdmin")
//	public Admin createAdmin() {
//
//	}
	@PostMapping("/createCustomer")
	public  Customer createCustomer( @RequestBody Customer customer) {		
		return userService.createCustomer(customer);
	}
//	@GetMapping("/getUser/{idCustomer}")
//	public  Customer getCustomer( @PathVariable int idCustomer) {		
//
//	}
	@GetMapping("/searchCustomerbyEmail/query")
	public  List<Customer> searchCustomer(@RequestParam String strSearch) {	
		return userService.searchCustomerByEmail(strSearch);
	}
}
