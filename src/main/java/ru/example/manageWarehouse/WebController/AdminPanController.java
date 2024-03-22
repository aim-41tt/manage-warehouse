package ru.example.manageWarehouse.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.example.manageWarehouse.services.AdminServices;
import org.springframework.web.bind.annotation.RequestParam;



@Controller()
@RequestMapping("/admin")
public class AdminPanController {

	@Autowired
	private AdminServices adminServices;
	
	@GetMapping("/panel")
	public String panelAdmin(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		adminServices.addUserToProfile(userDetails, model);
		return "admin/adminPanel";
	}
	
	@GetMapping("path")
	public String panel(Model model) {
		return "";
	}
	
		
	
}
