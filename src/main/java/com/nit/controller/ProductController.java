package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.product.Product;
import com.nit.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping("/create")
	public Product createProductDetails(@RequestBody Product product) {
		
		      return  service.createProduct(product);
		      
	}
	
	@GetMapping("/allProduct")
	 public List<Product> getAllProducts() {
        return service.getAllProduct();
		
	}

	  @GetMapping("/{id}")
	   public ResponseEntity<Product> getProductById(@PathVariable Long id){
		 return  service.getProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	  }
	  
	  @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        Product updatedProduct = service.updateProduct(id, product);
	        if (updatedProduct != null) {
	            return ResponseEntity.ok(updatedProduct);
	        }
	        return ResponseEntity.notFound().build();
	    }
}
