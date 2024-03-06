package ru.example.manageWarehouse.repositorys;

import org.springframework.data.repository.CrudRepository;

import ru.example.manageWarehouse.model.ProductType;

public interface ProductTypeRepository extends CrudRepository<ProductType, Long>{
	
}