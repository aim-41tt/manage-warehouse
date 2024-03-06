package ru.example.manageWarehouse.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.example.manageWarehouse.repositorys.ProductRepository;
import ru.example.manageWarehouse.repositorys.ProductTypeRepository;
import ru.example.manageWarehouse.services.ProducMmanagementService;

@Controller
public class WarehouseController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	private ProducMmanagementService producMmanagement;

	@GetMapping("/warehouse")
	public String showWarehouseForm(Model model) {


		model.addAttribute("productTypesList", productTypeRepository.findAll());
		model.addAttribute("productTypeMap", producMmanagement.MapProductType(productTypeRepository.findAll()));
		model.addAttribute("foundProducts", productRepository.findAll());

		return "warehouse";
	}

	@PostMapping("/searchWarehouse")
	public String searchWarehouse(Model model, @RequestParam("searchByName") String searchByName,
											   @RequestParam("searchByType") Long searchByType) {
		model.addAttribute("productTypesList", productTypeRepository.findAll());
		model.addAttribute("productTypeMap", producMmanagement.MapProductType(productTypeRepository.findAll()));

		if (!searchByName.isEmpty()) {
			model.addAttribute("foundProducts", productRepository.findByProductName(searchByName));
		} else {
			if (searchByType > 0) {
				model.addAttribute("foundProducts", productRepository.findByTypeId(searchByType));
				
			} else {
				model.addAttribute("foundProducts", productRepository.findAll());
			}
		}
		
		return "warehouse";
	}

}
