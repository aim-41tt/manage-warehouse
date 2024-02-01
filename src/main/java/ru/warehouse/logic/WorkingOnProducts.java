package ru.warehouse.logic;

import java.util.ArrayList;
import java.util.List;

import ru.warehouse.db.HibernateUtil;
import ru.warehouse.model.ProductEntitiy;


/**
 *  соритровка по типу, имини по  словам!
 */
public class WorkingOnProducts {

	/**
	 * @param text from the product name 
	 * @return Sorted list of products
	 */
    public static List<ProductEntitiy> getSortList(String text) {
		
		List<ProductEntitiy> sortList = new ArrayList<ProductEntitiy>();
	   	 
	   	for(ProductEntitiy product: HibernateUtil.getEntities(ProductEntitiy.class)) {
	   		if(product.getProductName().contains(text) || text != null && text.trim().isEmpty() ) {
	   			sortList.add(product);
	   		}
	   	}
			return sortList;
	}
    
    /**
     * @return list of products
     */
    public static List<ProductEntitiy> getList() {
    	return HibernateUtil.getEntities(ProductEntitiy.class);
    }

}