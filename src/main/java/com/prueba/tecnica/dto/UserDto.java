package com.prueba.tecnica.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private Date birthDate;
    
    /**
     * Constructor con fechas obtenidas de base de datos.
     * 
     * @param id
     * @param name
     * @param email
     * @param birthDate
     */
	public UserDto(Long id, String name, String email, java.sql.Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = new Date(birthDate.getTime());
	}
    
}
