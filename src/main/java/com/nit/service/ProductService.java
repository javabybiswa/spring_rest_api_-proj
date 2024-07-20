package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.product.Product;
import com.nit.repository.ProductRepository;

@Service
public class ProductService {

	
	 @Autowired
	 ProductRepository repository;
	 
	 public Product createProduct(Product product)
	 {
		 return repository.save(product);
	 }
	  
	  public List<Product> getAllProduct(){
		  return repository.findAll();
	  }
	   
	   public Optional<Product> getProductById(long id){
		   return repository.findById(id);
	   }
	   


	    public Product updateProduct(Long id, Product product) {
	        if (repository.existsById(id)) {
	            product.setId(id);
	            return repository.save(product);
	        }
	        return null;
	    }


	 
}
