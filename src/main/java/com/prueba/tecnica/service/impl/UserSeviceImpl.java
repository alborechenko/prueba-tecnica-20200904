package com.prueba.tecnica.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.dto.UserDto;
import com.prueba.tecnica.entity.User;
import com.prueba.tecnica.repository.UserRepository;
import com.prueba.tecnica.service.UserService;

@Service
public class UserSeviceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
     * @see com.prueba.tecnica.service.UserService#getUsers(java.util.Date,java.util.Date,java.lang.String)
     */
	@Override
	public List<UserDto> getUsers(Date dateFrom, Date dateTo, String email) {
		
		List<UserDto> listUsers = new ArrayList<UserDto>();
		
		if (dateFrom != null && dateTo != null) {
			listUsers = userRepository.findUsersDateFilters(new java.sql.Date(dateFrom.getTime()),
					new java.sql.Date(dateTo.getTime()), email);
		} else if (dateFrom != null && dateTo == null) {
			listUsers = userRepository.findUsersDateFilters(new java.sql.Date(dateFrom.getTime()),
					new java.sql.Date(Calendar.getInstance().getTime().getTime()), email);
		} else if (dateFrom == null) {
			listUsers = userRepository.findUsersNoDateFilters(email);
		}
		
		return listUsers;
	}

	/* (non-Javadoc)
     * @see com.prueba.tecnica.service.UserService#getUser(java.lang.Long)
     */
	@Override
	public UserDto getUser(Long userId) {
		//userRepository.getOne(userId);
		
		return null;
	}

	/* (non-Javadoc)
     * @see com.prueba.tecnica.service.UserService#saveUser(com.prueba.tecnica.dto.UserDto)
     */
	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setBirthDate(new java.sql.Date(userDto.getBirthDate().getTime()));
		
		userRepository.save(user);

	}

	/* (non-Javadoc)
     * @see com.prueba.tecnica.service.UserService#removeUser(java.lang.Long)
     */
	@Override
	public void removeUser(Long userId) {
		userRepository.deleteById(userId);
	}
	

}
