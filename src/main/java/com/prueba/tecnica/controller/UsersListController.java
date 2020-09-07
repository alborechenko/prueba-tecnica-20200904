package com.prueba.tecnica.controller;

import com.prueba.tecnica.dto.UserDto;
import com.prueba.tecnica.service.UserService;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Scope (value = "session")
@Component (value = "usersList")
@ELBeanName(value = "usersList")
@Join(path = "/", to = "/pages/user-list.jsf")
public class UsersListController {
	@Autowired
	private UserService userService;

	private List<UserDto> users;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		users = userService.getUsers(null, null, null);
	}

	/**
	 * Obtiene el listado de usuarios.
	 * 
	 * @return
	 */
	public List<UserDto> getUsers() {
		return users;
	}

	/**
	 * Elimina el usuario con el id envíado.
	 * 
	 * @param userId Identificador del usuario.
	 */
	public String delete(Long id) {		
		userService.removeUser(id);
		loadData();
		return null;
	}
}
