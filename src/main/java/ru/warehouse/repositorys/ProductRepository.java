package ru.warehouse.repositorys;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import ru.warehouse.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	 List<Product> findByProductNameAndProductType(String name);
}
