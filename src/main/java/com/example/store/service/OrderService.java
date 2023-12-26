	package com.example.store.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.DAO.CartDAO;
import com.example.store.DAO.CustomerDAO;
import com.example.store.DAO.OrderDAO;
import com.example.store.DAO.PayCardDAO;
import com.example.store.DAO.PayCashDAO;
import com.example.store.DAO.PaymentDAO;
import com.example.store.DAO.ProductDAO;
import com.example.store.DAO.ShipmentDAO;
import com.example.store.model.Cart;
import com.example.store.model.Customer;
import com.example.store.model.Order;
import com.example.store.model.PayCard;
import com.example.store.model.PayCash;
import com.example.store.model.Payment;
import com.example.store.model.Product;
import com.example.store.model.Shipment;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	OrderDAO orderDAO;
	@Autowired
	ShipmentDAO shipmentDAO;
	@Autowired
	PaymentDAO paymentDAO;
	@Autowired
	PayCashDAO payCashDAO;
	@Autowired
	PayCardDAO payCardDAO;
	
	// them san pham vao gio hang
	public Cart createCart(int idCus,int idPro,int quatity)
	{
		Cart cart= new Cart();
		cartDAO.save(cart);
		Customer customer= customerDAO.getById(idCus);
		Product product= productDAO.getById(idPro);
		cart.setCustomer(customer);
		cart.setProduct(product);
		cart.setQuantity(quatity);
		
		cartDAO.save(cart);
		
		return cart;
	}
	
	// tao order 
	public Order createOder(int idCus,int idShip,int idPay )
	{
		Customer customer= customerDAO.getById(idCus);
		Order order= new Order();
		order.setCustomer(customer);
		order.setDateCreate(LocalDate.now());
		orderDAO.save(order);
		
		Shipment shipment=shipmentDAO.getById(idShip);
		order.setShipment(shipment);
		order.setTotalAmount(shipment.getPrice());
		//Lay ra list Cart cua customer add nhung cart co status=0 vao order va set status=1
		List<Cart> carts= customer.getCarts();
		List<Cart> cartsOrder= new ArrayList<>();
		for(Cart cart:carts) {
			if(cart.getStatus()==0)
			{
				int total=order.getTotalAmount();
				order.setTotalAmount(total+cart.getProduct().getPrice()*cart.getQuantity());
				cart.setStatus(1);
				cart.setOrderr(order);
				cartsOrder.add(cart);
				cartDAO.save(cart);
			}
		}
		if(order.getTotalAmount()==shipment.getPrice())
				return null;
		order.setPayment(paymentDAO.getById(idPay));
		orderDAO.save(order);
		order.setCarts(cartsOrder);
		orderDAO.save(order);
		return order;
	}
	// view cart
	public List<Cart> viewCart(int idCus)
	{
		Customer customer= customerDAO.getById(idCus);
		
		List<Cart> carts = customer.getCarts();
		List<Cart> result = new ArrayList<>();
		for(Cart cart:carts) {
			if(cart.getStatus()==0)
			{
				result.add(cart);
			}
		}
		return result;
	}
	//delete cart
	public boolean deleteCart(int id) {
		cartDAO.deleteById(id);
		return true;
	}
	//addShipment
	public Shipment createShipment(Shipment shipment)
	{
		shipmentDAO.save(shipment);
		return shipment;
	}
	//addShipment
	public PayCash createPayCash(PayCash payCash)
	{
		payCashDAO.save(payCash);
		return payCash;
	}
	//addShipment
	public PayCard createPayCard(PayCard payCard)
	{
		payCardDAO.save(payCard);
		return payCard;
	}
	public Payment createPayment(Payment payment) {
		paymentDAO.save(payment);
		return payment;
	}
	//view order by id
	public Order viewOrderById(int id) {
		return orderDAO.getById(id);
	}
	//view All order cua customer
	public List<Order> getOrderCust(int id) {
		Customer customer = customerDAO.getById(id);
		return customer.getOrders();
	}
}
