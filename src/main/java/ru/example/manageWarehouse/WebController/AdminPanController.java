package ru.example.manageWarehouse.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.example.manageWarehouse.model.User;
import ru.example.manageWarehouse.services.AdminServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@Controller()
@RequestMapping("/admin")
public class AdminPanController {

	@Autowired
	private AdminServices adminServices;
	
	@GetMapping()
	public String panelAdmin(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		adminServices.addUserToProfile(userDetails, model);
		return "admin/adminPanel";
	}
	
	@GetMapping("path")
	public String panel(Model model) {
		return "";
	}
	
	
	
	
	@Controller
	@RequestMapping("/admin/supply")
	class AdminSupply {
		@PostMapping("supply")
		public String postMethodName(Model model) {
			return "admine/supply";
		}
		
		@GetMapping()
		public String adminSupply(Model model) {
			return "admine/supply";
		}
		
	}
	
	@Controller
	@RequestMapping("/admin/userEdit")
	class userEdit {
		
		@GetMapping()
		public String userEditer(Model model) {
			model.addAttribute("User",new User());
			
			return "admine/userEdit";
		}
		
		@PostMapping("userEdit")
		public String userEdit(User user, Model model) {
			adminServices.UpdataUserData(user, model);
			model.addAttribute("status","Ok");
			return "admine/userEdit";
		}
		
	}
	
	
	@Controller
	@RequestMapping("/admin/statics")
	class statics {
		// добавить и расскоментирыать
		//private StaticsRepo staticsRepo;
		
		@GetMapping()
		public String getStatics() {
			return "admine/statics";
		}
		
		@PostMapping()
		public String postMethodName(@RequestBody String entity) {
			
			return entity;
		}
		
	}
	
	@Controller
	@RequestMapping("/admin/addTypeProduct")
	class addTypeProduct{
		
	}
	
}
