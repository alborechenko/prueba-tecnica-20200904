package com.prueba.tecnica.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Date birthDate;
    
}
