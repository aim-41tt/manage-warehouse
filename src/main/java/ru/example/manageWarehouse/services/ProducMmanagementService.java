package ru.example.manageWarehouse.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import ru.example.manageWarehouse.model.ProductType;

@Service
public class ProducMmanagementService {
	

	public  Map<Long, ProductType> MapProductType(Iterable<ProductType> iterable){
		
		Map<Long, ProductType> productTypeMap = new HashMap<>();
		for (ProductType type : iterable) {
		    productTypeMap.put(type.getId(), type);
		}
		return productTypeMap;
	}
	
}
