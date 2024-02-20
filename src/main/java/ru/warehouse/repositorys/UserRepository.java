package ru.warehouse.repositorys;

import org.springframework.data.repository.CrudRepository;

import ru.warehouse.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	

}