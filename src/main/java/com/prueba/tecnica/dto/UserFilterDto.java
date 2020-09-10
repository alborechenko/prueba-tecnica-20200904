package com.prueba.tecnica.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFilterDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private Date dateFrom;
	private Date dateTo;

}
