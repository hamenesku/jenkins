package com.finalProject.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.finalProject.project.entity.User;

public interface UsersCRUDRepository extends CrudRepository<User, Integer> {

	@Query(" from User as u where u.user=:user and u.password=:password")
	//Solo puede dar un ÚNICO objeto con la misma clave y la misma contraseña
	public User getLogin(String user, String password);
	


}