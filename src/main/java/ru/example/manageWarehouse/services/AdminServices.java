package ru.example.manageWarehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ru.example.manageWarehouse.model.User;
import ru.example.manageWarehouse.repositorys.UserRepositorys;

@Service
public class AdminServices extends UserServices  {
	
	@Autowired
	private RegistrationServis registrationServis;
	
	@Autowired
	private UserRepositorys userRepositorys;
	
	public Model UpdataUserData(User userUp, Model model) {
		registrationServis.UpdataUserData(userUp, model);
		return model;
	}	
	

	
}
