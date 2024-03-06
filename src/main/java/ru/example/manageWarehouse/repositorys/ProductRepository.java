package ru.example.manageWarehouse.repositorys;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.example.manageWarehouse.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	  
	List<Product> findByProductName(String productName);
	List<Product> findByTypeId(Long typeID);
}

