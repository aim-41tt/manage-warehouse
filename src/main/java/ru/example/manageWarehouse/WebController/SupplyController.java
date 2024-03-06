package ru.example.manageWarehouse.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.example.manageWarehouse.model.Product;
import ru.example.manageWarehouse.repositorys.ProductRepository;
import ru.example.manageWarehouse.repositorys.ProductTypeRepository;


@Controller("/")
public class SupplyController {
 
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductTypeRepository productTypeRepository;
    
  
    @GetMapping("/supply")
    public String showSupplyForm(Model model) {
   	model.addAttribute("productTypesList", productTypeRepository.findAll());
        return "supply"; 
    }



    @PostMapping("/processSupply")
    public String processSupplyForm(@RequestParam("productName") String productName,
                                    @RequestParam("price") double price,
                                    @RequestParam("productTypeId") Long typeId,
                                    @RequestParam("kol") Long kol,
                                    Model model) {   
        Product product = new Product();
        
        product.setPrice(price);
        product.setProductName(productName);
		product.setTypeId(typeId);
		product.setKol(kol);
        productRepository.save(product);
        
        return "redirect:/supply"; // Используйте перенаправление на страницу supply
    }

}
