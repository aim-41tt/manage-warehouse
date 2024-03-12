package ru.example.manageWarehouse.WebController;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ru.example.manageWarehouse.model.Role;
import ru.example.manageWarehouse.model.User;
import ru.example.manageWarehouse.repositorys.UserRepositorys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {
	@Autowired
	private UserRepositorys userRepositorys;
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String addUser(User user , Map<String , Object> model) {
		User userFromDB = userRepositorys.findByUsername(user.getUsername());
		
		if(userFromDB != null) {
			model.put("message", "error");
			return "registration";
		}
		
		user.setRoles(Collections.singleton(Role.USER));
		userRepositorys.save(user);
		return "registration";
	}
	
	
}
