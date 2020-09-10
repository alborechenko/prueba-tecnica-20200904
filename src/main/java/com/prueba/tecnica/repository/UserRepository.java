package com.prueba.tecnica.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.tecnica.dto.UserDto;
import com.prueba.tecnica.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select new com.prueba.tecnica.dto.UserDto(usr.id, usr.name, usr.email, usr.birthDate) from User usr "
			+ "where (:email is null or upper(usr.email) like '%'||upper(:email)||'%')"
			+ "and usr.birthDate between :dateFrom and :dateTo")
	public List<UserDto> findUsersDateFilters(Date dateFrom, Date dateTo, String email);
	
	@Query("select new com.prueba.tecnica.dto.UserDto(usr.id, usr.name, usr.email, usr.birthDate) from User usr "
			+ "where (:email is null or upper(usr.email) like '%'||upper(:email)||'%')")
	public List<UserDto> findUsersNoDateFilters(String email);

}
