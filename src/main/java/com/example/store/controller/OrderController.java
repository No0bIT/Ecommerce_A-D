package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.DAO.CartDAO;
import com.example.store.model.Cart;
import com.example.store.model.Order;
import com.example.store.model.PayCard;
import com.example.store.model.PayCash;
import com.example.store.model.Payment;
import com.example.store.model.Shipment;
import com.example.store.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	CartDAO cartDAO;
	
	@PostMapping("/createCart")
	public Cart createCart(@RequestBody Cart cart)
	{
		Cart result= orderService.createCart(cart.getCustomer().getId(), cart.getProduct().getId(), cart.getQuantity());
		return result;
	}
	@PostMapping("/createOrder")
	public Order createOrder(@RequestBody Order order)
	{
		Shipment shipment= orderService.createShipment(order.getShipment());
		Payment payment=orderService.createPayment(order.getPayment());
		return orderService.createOder(order.getCustomer().getId(), shipment.getId(),payment.getId());
	}
	@GetMapping("/viewCart")
	public List<Cart> viewCart(@RequestParam int idCus)
	{
		return orderService.viewCart(idCus);
	}
	@PostMapping("/createShipment")
	public Shipment createShipment(@RequestBody Shipment shipment)
	{
		return orderService.createShipment(shipment);
	}
	@PostMapping("/createPayCash")
	public PayCash createPayCash(@RequestBody PayCash payCash)
	{
		return orderService.createPayCash(payCash);
	}
	@PostMapping("/createPayCard")
	public PayCard createPayCard(@RequestBody PayCard payCard)
	{
		return orderService.createPayCard(payCard);
	}
	@GetMapping("/viewCart/{id}")
	public Cart view(@PathVariable int id)
	{ 
		return cartDAO.getById(id);
	}
	@DeleteMapping("/deleteCart/{id}")
	public boolean delete(@PathVariable int id)
	{ 
		return orderService.deleteCart(id);
	}
	@GetMapping("/viewOrder/{id}")
	public Order viewOrder(@PathVariable int id)
	{ 
		return orderService.viewOrderById(id);
	}
	
	@GetMapping("/viewAllOrderCus/{id}")
	public List<Order> viewAllOrderCus(@PathVariable int id){
		return orderService.getOrderCust(id);
	}
	
}
