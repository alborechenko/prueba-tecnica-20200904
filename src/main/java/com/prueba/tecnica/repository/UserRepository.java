package com.prueba.tecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.tecnica.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
