package com.prueba.tecnica.dto;

import java.io.Serializable;

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
    private String lastName1;
    private String lastName2;
    private String email;
    private String birthDate;
    
}
