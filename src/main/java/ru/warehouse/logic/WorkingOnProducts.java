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
		List<ProductEntitiy> List = HibernateUtil.getEntities(ProductEntitiy.class);
	   	for(ProductEntitiy product:List ) {
	   		if(product.getProductName().contains(text)) {
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