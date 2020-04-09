package com;
import com.fajnegui;
import java.awt.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JTable;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

public class zabezpieczenia {

	
	public static int sprawdzBadanie(String lleukocytow, String lneutrofili, String lerytrocytow, JTable tabela, String sData, Date data) {
		if(StringUtils.isEmpty(lerytrocytow)||StringUtils.isEmpty(lneutrofili)||StringUtils.isEmpty(lerytrocytow)||StringUtils.isEmpty(sData))return 1;
		else
			return 0;
	}
	
	public static int sprawdzPacjenta(String imie, String nazwisko, String pesel, JTable Tabela) {
		   if(StringUtils.isEmpty(pesel)||StringUtils.isEmpty(imie)||StringUtils.isEmpty(nazwisko))return 1;
		   else 
			   return 0;
			   
	   }
	
	public static boolean secondTwo(String pesel) {
	   	Range<Integer> myRange = Range.between(0,1); 
	   	
	    if(myRange.contains(Integer.parseInt(String.valueOf(pesel.charAt(2))))){
	    return true;
	    }
	    else {return false;}
   }
	
	
	   public static boolean liczbaplec(String pesel) {
		  if(Arrays.asList(1,3,5,7,9).contains(Integer.parseInt(String.valueOf(pesel.charAt(2))))) {
			  return true;
		  }
		  else {return false;}
	   }
	   
		   
	   public static int sprawdzPesel(String pesel) {
		   if(pesel.matches("[0-9]+") && pesel.length() == 11 && secondTwo(pesel) == true) {
		/*	  
			//if(P && liczbaplec(pesel) == true) {
				   return 1;
				   
			   }
			 //  else if(liczbaplec(pesel) == false)
			//	   return 1;
		   }
		 //  else {
			//   return 0;
		  // }*/
		return 0;
		   
		   
	   }
	
}
