package ru.example.manageWarehouse.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.example.manageWarehouse.model.User;

public interface UserRepositorys extends JpaRepository<User, Long>{
	User findByUsername(String userName);
}
