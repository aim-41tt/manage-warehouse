package ru.example.manageWarehouse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServices extends UserServices {
	
	@Autowired
	private RegistrationServis registrationServis;
	
	
	
}
