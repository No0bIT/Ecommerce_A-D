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

import com.example.store.model.Book;
import com.example.store.model.Clothes;
import com.example.store.model.MobilePhone;
import com.example.store.model.Product;
import com.example.store.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired 
	ProductService productService;
	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product)
	{
		return productService.createProduct(product);
	}
	@PostMapping("/createBook")
	public Book createBook(@RequestBody Book book)
	{
		return productService.createBook(book);
	}
	@PostMapping("/createClothes")
	public Clothes createClothes(@RequestBody Clothes clothes)
	{
		return productService.createClothes(clothes);
	}
	@PostMapping("/createMobilePhone")
	public MobilePhone createMobilePhone(@RequestBody MobilePhone mobilePhone)
	{
		return productService.createMobilePhone(mobilePhone);
	}
	@PostMapping("/editProduct")
	public Product editProduct(@RequestBody Product product)
	{
		return productService.editProduct(product);
	}
	@PostMapping("/editBook")
	public Book editBook(@RequestBody Book book)
	{
		return productService.editBook(book);
	}
	@PostMapping("/editClothes")
	public Clothes editClothes(@RequestBody Clothes clothes)
	{
		return productService.editClothes(clothes);
	}
	@PostMapping("/editMobilePhone")
	public MobilePhone editMobilePhone(@RequestBody MobilePhone mobilePhone)
	{
		return productService.editMobilePhone(mobilePhone);
	}
	@GetMapping("/searchProduct")
	public List<Product> searchByName(@RequestParam("str") String str){ 
		return productService.searchProductByName(str);
	}
	@DeleteMapping("/deleteProduct/{id}")
	public boolean deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	
}
