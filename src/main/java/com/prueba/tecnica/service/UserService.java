package com.prueba.tecnica.service;

import java.util.List;

import com.prueba.tecnica.dto.UserDto;

/**
 * Interfaz para la declaración de los servicios de usuario.
 * 
 * @author alborechenko
 *
 */
public interface UserService {

	/**
	 * Método para la obtención de un listado de usuarios.
	 * 
	 * @param dateFrom Filtro de fecha desde.
	 * @param dateTo   Filtro de fecha hasta.
	 * @param email    Filtro de correo.
	 * @return listado de usuarios.
	 */
	public List<UserDto> getUsers(String dateFrom, String dateTo, String email);

	/**
	 * Método para la obtención información de un usuario.
	 * 
	 * @param userId Identificador del usuario.
	 * @return Información del usuario solicitado.
	 */
	public UserDto getUser(Long userId);

	/**
	 * Método para guardar la información de un usuario.
	 * 
	 * @param userDto DTO con la información del usuario.
	 */
	public void saveUser(UserDto userDto);
	
	/**
	 * Método para eliminar un usuario.
	 * 
	 * @param userId Identificador del usuario.
	 */
	public void removeUser(Long userId);
}
