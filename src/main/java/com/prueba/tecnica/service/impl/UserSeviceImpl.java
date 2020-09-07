package com.prueba.tecnica.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prueba.tecnica.dto.UserDto;
import com.prueba.tecnica.repository.UserRepository;
import com.prueba.tecnica.service.UserService;
import com.prueba.tecnica.utils.Utils;

public class UserSeviceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
     * @see com.prueba.tecnica.service.UserService#getUsers(java.lang.String,java.lang.String,java.lang.String)
     */
	@Override
	public List<UserDto> getUsers(String dateFrom, String dateTo, String email) {
		
		return this.getTestUsersList();
	}

	/* (non-Javadoc)
     * @see com.prueba.tecnica.service.UserService#getUser(java.lang.Long)
     */
	@Override
	public UserDto getUser(Long userId) {
		//userRepository.getOne(userId);
		
		return this.getTestUser();
	}

	/* (non-Javadoc)
     * @see com.prueba.tecnica.service.UserService#saveUser(com.prueba.tecnica.dto.UserDto)
     */
	@Override
	public void saveUser(UserDto userDto) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
     * @see com.prueba.tecnica.service.UserService#removeUser(java.lang.Long)
     */
	@Override
	public void removeUser(Long userId) {
		userRepository.deleteById(userId);
	}
	
	private UserDto getTestUser() {
		UserDto user = new UserDto();

		user.setName("Usuario Prueba Uno");
		user.setEmail("usuario.prueba.uno@mail.com");
		user.setBirthDate(Utils.getStrDateFromDate(new Date((new java.util.Date()).getTime()), "dd/MM/YYYY"));
		
		return user;
	}
	
	private List<UserDto> getTestUsersList() {
		List<UserDto> usersList = new ArrayList<UserDto>();
		UserDto user1 = new UserDto(new Long(1), "Usuario Prueba Uno", "usuario.prueba.uno@mail.com",
				Utils.getStrDateFromDate(new Date((new java.util.Date()).getTime()), "dd/MM/YYYY"));
		UserDto user2 = new UserDto(new Long(2), "Usuario Prueba Dos", "usuario.prueba.dos@mail.com",
				Utils.getStrDateFromDate(new Date((new java.util.Date()).getTime()), "dd/MM/YYYY"));

		usersList.add(user1);
		usersList.add(user2);

		return usersList;
	}
	

}
