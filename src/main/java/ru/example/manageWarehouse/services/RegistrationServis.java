package ru.example.manageWarehouse.services;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ru.example.manageWarehouse.model.Role;
import ru.example.manageWarehouse.model.User;
import ru.example.manageWarehouse.repositorys.UserRepositorys;

@Service
public class RegistrationServis {

	@Autowired
	private UserRepositorys userRepositorys;
	
	public Map User(User user , Map<String , Object> model) {
		User userFromDB = userRepositorys.findByUsername(user.getUsername());
		
		if(userFromDB != null) {
			model.put("message", "error");
			
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles(Collections.singleton(Role.USER));
		
		userRepositorys.save(user);
		return model;
	}
	
	public Model UpdataUserData(User userUp, Model model) {
		User user = userRepositorys.findByUsername(userUp.getUsername());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(user != null) {
		try {
			if(userUp.pravOnNullUserName() && userUp.getUsername() != user.getUsername()) {
				user.setUsername(userUp.getUsername());
			}
			if(userUp.pravOnNullPassword()) {
				user.setPassword(encoder.encode(userUp.getPassword()));
			}
			userRepositorys.save(user);
			model.addAttribute("status","OK:200");	

		} catch (Exception e) {

			model.addAttribute("status","ERROR:504");	
		}
		
		}
		else {
			model.addAttribute("status", "ERROR:504");
		}
		
		return model;
	}
	
	
	
}
