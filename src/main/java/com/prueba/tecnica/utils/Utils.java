package com.prueba.tecnica.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Utils {

	/**
	 * Obtiene la representación de la fecha con el formato dado.
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getStrDateFromDate(Date date, String pattern) {
		String strDate = null;
		
        DateFormat dateFormat = new SimpleDateFormat(pattern);  
        strDate = dateFormat.format(date);  
        System.out.println("Converted String: " + strDate);  
		
		return strDate;
	}
	
}
