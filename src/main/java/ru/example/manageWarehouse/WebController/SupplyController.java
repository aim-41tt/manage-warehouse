package ru.example.manageWarehouse.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.example.manageWarehouse.model.Product;
import ru.example.manageWarehouse.repositorys.ProductRepository;
import ru.example.manageWarehouse.repositorys.ProductTypeRepository;
import ru.example.manageWarehouse.services.UserServices;

@Controller()
public class SupplyController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	private UserServices userSe;
	
	@GetMapping("/supply")
	public String showSupplyForm(@AuthenticationPrincipal UserDetails userDetails,Model model) {
		userSe.addUserToProfile(userDetails, model);
		model.addAttribute("productTypesList", productTypeRepository.findAll());
		return "supply";
	}

	@PostMapping("/supply")
	public String processSupplyForm(@RequestParam("productName") String productName,
			@RequestParam("price") double price, @RequestParam("productTypeId") Long typeId,
			@RequestParam("kol") Long kol, Model model) {
		Product product = new Product();

		product.setPrice(price);
		product.setProductName(productName);
		product.setTypeId(typeId);
		product.setKol(kol);
		productRepository.save(product);

		return "redirect:/supply"; // Используйте перенаправление на страницу supply
	}

}
