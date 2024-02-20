package ru.warehouse.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.warehouse.repositorys.ProductRepository;




@Controller
public class WarehouseController {
	
	@Autowired 
	private ProductRepository productRepository;
	
    @RequestMapping("/warehouse")
    public String showWarehouseForm(Model model) {
    	model.addAttribute("foundProducts",productRepository.findAll());
        return "warehouse";
    }

    @PostMapping("/searchWarehouse")
    public String searchWarehouse(Model model, String searchByName, String searchByType) {

         model.addAttribute("foundProducts", productRepository.findByProductNameAndProductType(searchByName));

    		        return "warehouse";
    }
}
