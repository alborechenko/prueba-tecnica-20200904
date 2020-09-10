package com.prueba.tecnica.controller;

import com.prueba.tecnica.dto.UserDto;
import com.prueba.tecnica.dto.UserFilterDto;
import com.prueba.tecnica.service.UserService;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Scope(value = "session")
@Component(value = "usersList")
@ELBeanName(value = "usersList")
@Join(path = "/", to = "/pages/user-list.jsf")
public class UsersListController {
	@Autowired
	private UserService userService;

	private List<UserDto> users = new ArrayList<UserDto>();

	private UserFilterDto userFilter = new UserFilterDto();

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		users = userService.getUsers(userFilter.getDateFrom(), userFilter.getDateTo(), userFilter.getEmail());
	}

	/**
	 * Obtiene el listado completo de usuarios.
	 * 
	 * @return
	 */
	public List<UserDto> getUsers() {
//		System.out.println("UsersListController.getUsers()");
		return users;
	}

	/**
	 * Obtiene el listado de usuarios en base al filtro.
	 * 
	 * @return
	 */
	public void search() {
//		System.out.println("UsersListController.search()");
		users = userService.getUsers(userFilter.getDateFrom(), userFilter.getDateTo(), userFilter.getEmail());
	}

	/**
	 * Elimina el usuario con el id envíado.
	 * 
	 * @param userId Identificador del usuario.
	 */
	public String delete(Long id) {
//		System.out.println("UsersListController.delete()");
		userService.removeUser(id);
		loadData();
		return null;
	}

	/**
	 * Obtiene la información del filtro.
	 * 
	 * @return filtro.
	 */
	public UserFilterDto getUserFilter() {
//		System.out.println("UsersListController.getUserFilter()");
		return userFilter;
	}

}
