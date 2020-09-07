package com.prueba.tecnica.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.prueba.tecnica.dto.UserDto;
import com.prueba.tecnica.service.UserService;

@Scope(value = "session")
@Component(value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/user", to = "/pages/user-info.jsf")
public class UserController {

	@Autowired
	UserService userService;

	private UserDto user = new UserDto();

	/**
	 * Método para guardar un nuevo usuario.
	 * 
	 * @return La url del listado de usuarios
	 */
	public String saveUser() {

		userService.saveUser(user);
		user = new UserDto();
		return "/pages/user-list.xhtml?faces-redirect=true";
	}

	/**
	 * Obtiene el usuario con el id envíado.
	 * 
	 * @param userId Identificador del usuario.
	 * @return Información del usuario.
	 */
	public UserDto getUser() {

		return userService.getUser(null);

	}

}
