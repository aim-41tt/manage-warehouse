package ru.warehouse.webController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.warehouse.db.HibernateUtil;
import ru.warehouse.model.ProductEntitiy;


@Controller
public class SupplyController {

    @RequestMapping("/supply")
    public String showSupplyForm(Model model) {
        return "supply";
    }

    @PostMapping("/processSupply")
    public String processSupplyForm(@RequestParam("productName") String productName,
						            @RequestParam("price") double price,
						            @RequestParam("productType") String productType,
						            Model model) {   
    	ProductEntitiy product = new ProductEntitiy();
		 
		 product.setPrice(price);
		 product.setProductName(productName);
		 product.setProductType(productType);
		 HibernateUtil.saveOrUpdateEntity(product);
        return "supply";
    }
}
