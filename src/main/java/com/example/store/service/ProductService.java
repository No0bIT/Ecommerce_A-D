package com.example.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.DAO.BookDAO;
import com.example.store.DAO.ClothesDAO;
import com.example.store.DAO.MobilePhoneDAO;
import com.example.store.DAO.ProductDAO;
import com.example.store.model.Book;
import com.example.store.model.Clothes;
import com.example.store.model.MobilePhone;
import com.example.store.model.Product;

@Service
public class ProductService {

	
	@Autowired
	ProductDAO productDAO;
	@Autowired 
	BookDAO bookDAO;
	@Autowired 
	ClothesDAO clothesDAO;
	@Autowired
	MobilePhoneDAO mobilePhoneDAO;
	
	// create
	public Product createProduct(Product product) 
	{
		productDAO.save(product);
		return product;
	}
	public Book createBook(Book book) 
	{
		bookDAO.save(book);
		return book;
	}
	public Clothes createClothes(Clothes clothes) 
	{
		clothesDAO.save(clothes);
		return clothes;
	}
	public MobilePhone createMobilePhone(MobilePhone mobilePhone)
	{
		mobilePhoneDAO.save(mobilePhone);
		return mobilePhone;
	}
	// Edit
	public Product editProduct(Product product) 
	{
		productDAO.save(product);
		return product;
	}
	public Book editBook(Book book) 
	{
		bookDAO.save(book);
		return book;
	}
	public Clothes editClothes(Clothes clothes) 
	{
		clothesDAO.save(clothes);
		return clothes;
	}
	public MobilePhone editMobilePhone(MobilePhone mobilePhone)
	{
		mobilePhoneDAO.save(mobilePhone);
		return mobilePhone;
	}
	//getAll
	public  List<Product> getAllProduct() {
		return productDAO.findAll();
	}
	public  List<MobilePhone> getAllMobilePhones() {
		return mobilePhoneDAO.findAll();
	}
	public  List<Book> getAllBook() {
		return bookDAO.findAll();
	}
	public  List<Clothes> getAllClothes() {
		return clothesDAO.findAll();
	}
	//Search or getAll bang cach cho string ="" or null
	public List<Product> searchProductByName(String string)
	{
		if(string.equals("")||string.equals(null))
			return productDAO.findAll();
		else
		return productDAO.searchProductByName(string);
	}
	public List<Book> searchBookByName(String string)
	{
		if(string.equals("")||string.equals(null))
			return bookDAO.findAll();
		else
		return bookDAO.searchBookByName(string);
	}
	public List<Clothes> searchClothesByName(String string)
	{
		if(string.equals("")||string.equals(null))
			return clothesDAO.findAll();
		else
		return clothesDAO.searchClothesByName(string);
	}
	public List<MobilePhone> searchMobilePhoneByName(String string)
	{
		if(string.equals("")||string.equals(null))
			return mobilePhoneDAO.findAll();
		else
		return mobilePhoneDAO.searchMobilePhoneByName(string);
	}
	//delete
	public boolean deleteProduct(int id) {
		productDAO.deleteById(id);
		return true;
	}
}
