package ru.example.manageWarehouse.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ru.example.manageWarehouse.repositorys.ProductRepository;


@Controller
public class WarehouseController {
	
	@Autowired 
	private ProductRepository productRepository;
	
    @GetMapping("/warehouse")
    public String showWarehouseForm(Model model) {
    	model.addAttribute("foundProducts",productRepository.findAll());
        return "warehouse";
    }
   
    

    @PostMapping("/searchWarehouse")
    public String searchWarehouse(Model model, String searchByName, String searchByType) {
    	if(!searchByName.isEmpty()) {
         model.addAttribute("foundProducts", productRepository.findByProductName(searchByName));
    	}
    	else {
    		if (!searchByType.isEmpty()) {
    			 model.addAttribute("foundProducts", productRepository.findByProductType(searchByType));	
    		}
    		else {
    		model.addAttribute("foundProducts", productRepository.findAll());
    		}
    	}
    		        return "warehouse";
    }
    
    
}
