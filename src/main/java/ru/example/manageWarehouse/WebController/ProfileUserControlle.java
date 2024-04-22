package ru.example.manageWarehouse.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.example.manageWarehouse.repositorys.UserRepositorys;



@Controller
public class ProfileUserControlle {

	@Autowired
	private UserRepositorys userRepo;
	
	@GetMapping("/profile/{id}")
	public String getProfile(@RequestParam Long id) {
		return "/user/profile";
	}
	
	@GetMapping("/profile/userEdit")
	public String getUserEdit(@AuthenticationPrincipal UserDetails userDetails) {
		userRepo.findByUsername(userDetails.getUsername());
		return "/user/userEdit";
	}
	
	
	
	
	
}
