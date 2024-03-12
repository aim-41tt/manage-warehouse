package ru.example.manageWarehouse.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ru.example.manageWarehouse.model.Product;
import ru.example.manageWarehouse.model.ProductType;
import ru.example.manageWarehouse.repositorys.ProductRepository;

@Service
public class ProductTypeService {
	
	 @Autowired
	  private ProductRepository productRepository;
	 

	 @Cacheable("productMap")
	public  Map<Long, Product> MapProduct(Iterable<Product> iterable){
		
		Map<Long, Product> productMap = new HashMap<>();
		for (Product product : iterable) {
		    productMap.put(product.getId(), product);
		    System.out.println(product.getId());
		}
		return productMap;
	}

	 @Cacheable("productTypeMap")
	public  Map<Long, ProductType> MapProductType(Iterable<ProductType> iterable){
		
		Map<Long, ProductType> productTypeMap = new HashMap<>();
		for (ProductType type : iterable) {
		    productTypeMap.put(type.getId(), type);
		}
		return productTypeMap;
	}
	
	 @Cacheable("foundProducts")
	 public Iterable<Product> searchProducts(String searchByName, Long searchByType) {
		    // Метод для поиска продуктов по имени или типу
		    Iterable<Product> foundProducts = new ArrayList<>();
		    if (!searchByName.isEmpty()) {
		        foundProducts = productRepository.findByProductName(searchByName);
		    } else if (searchByType > 0) {
		        foundProducts = productRepository.findByTypeId(searchByType);
		    } else {
		        foundProducts = productRepository.findAll();
		    }
		    return foundProducts;
		  }
	
}
