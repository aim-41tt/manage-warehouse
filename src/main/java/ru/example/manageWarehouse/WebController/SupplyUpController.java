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
import ru.example.manageWarehouse.services.ProductTypeService;

@Controller
public class SupplyUpController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	private ProductTypeService producMmanagement;

	
	@GetMapping("/supplyUp")
	public String showSupplyForm(Model model) {
		model.addAttribute("productList", productRepository.findAll());
		 model.addAttribute("product", new Product());
		return "supplyUp";
	}
	

	
	@PostMapping("/processsupplyUp")
	public String processSupplyForm(@RequestParam("productName") String productName,
									@RequestParam("price") double price, 
									@RequestParam("productTypeId") Long typeId,
									@RequestParam("kol") Long kol,
									@RequestParam("productId") Long Id,
									@RequestParam("product") Product product, Model model) {
//		Product product = new Product() ;

		product.setPrice(price);
		product.setProductName(productName);
		product.setTypeId(typeId);
		product.setKol(kol);
		productRepository.save(product);

		return "redirect:/supplyUp"; // Используйте перенаправление на страницу supply
	}

}
