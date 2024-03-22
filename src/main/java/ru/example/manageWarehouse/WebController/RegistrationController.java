package ru.example.manageWarehouse.WebController;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ru.example.manageWarehouse.model.User;
import ru.example.manageWarehouse.services.RegistrationServis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

	@Autowired
	private RegistrationServis registrationServis;
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String addUser(User user , Map<String , Object> model) {
		registrationServis.User(user, model);
		return "registration";
	}
	
	
}
