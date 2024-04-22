package ru.example.manageWarehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ru.example.manageWarehouse.model.User;
import ru.example.manageWarehouse.repositorys.UserRepositorys;

@Service
@Primary
public class UserServices {

	@Autowired
	private UserRepositorys userRepo;
	
	public Model addUserToProfile(UserDetails userDetails, Model model) {
		model.addAttribute("user", userDetails);
		return model;
	}
	
	
	public Model upData(UserDetails userDetails, User userUp, Model model) {
		User userDoUp = userRepo.findByUsername(userDetails.getUsername());
		
		if(userDoUp != null) {
			if(!userUp.getUsername().isEmpty()) {
				userDoUp.setUsername(userUp.getUsername());
			}
			if(!userUp.getPassword().isEmpty()) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				userDoUp.setPassword(encoder.encode(userUp.getPassword()));
			}
		}
		return model;
	
	}
	
}
