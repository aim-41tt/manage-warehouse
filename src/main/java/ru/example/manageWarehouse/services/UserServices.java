package ru.example.manageWarehouse.services;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Primary
public class UserServices {

	public Model addUserToProfile(UserDetails userDetails, Model model) {
		model.addAttribute("user", userDetails);
		return model;
	}
	
}
