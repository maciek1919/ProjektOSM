package com;

import com.fajnegui;
import java.awt.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

public class zabezpieczenia {
	
	

	
	public static int sprawdzBadanie(String lleukocytow, String lneutrofili, String lerytrocytow, JTable tabela, String sData, Date data) {
		if(StringUtils.isEmpty(lerytrocytow)||StringUtils.isEmpty(lneutrofili)||StringUtils.isEmpty(lerytrocytow)||StringUtils.isEmpty(sData)) {
			
			JOptionPane.showMessageDialog(null, "Puste wyniki badan");
			return 1;
		}
		
		if(!lleukocytow.matches("[0-9]+") || !lneutrofili.matches("[0-9]+") || !lerytrocytow.matches("[0-9]+")) {
			JOptionPane.showMessageDialog(null, "Zly format wyników badañ");
			return 2;
		}
		
		
		else {
			
			return 0;
		}
	}
	
	public static int sprawdzPacjenta(String imie, String nazwisko, String pesel, JTable Tabela) {
		   if(StringUtils.isEmpty(pesel)||StringUtils.isEmpty(imie)||StringUtils.isEmpty(nazwisko)) {
			   JOptionPane.showMessageDialog(null, "Puste pola pacjenta");
			   return 1;
		   }
		   if(!StringUtils.isAlpha(imie) || (!StringUtils.isAlpha(nazwisko))) {
			   JOptionPane.showMessageDialog(null, "Imie lub nazwisko zawiera cyfry");
			   return 2 ;
		   }
		   int i = 0;
		   for (Pacjent pacjentVectorList1 : Presenter.pacjentVectorList) { //pêtla foreach
			   if(pacjentVectorList1.getPesel().equals(pesel)) {
				  
				   return checkingPeselUniqueness(Tabela, i);
			   }
			   i++;
		   }
		   return 0;		   
	   }
	
	public static boolean secondTwo(String pesel) {
	   	Range<Integer> myRange = Range.between(0,1); 
	   	
	    if(myRange.contains(Integer.parseInt(String.valueOf(pesel.charAt(2))))){
	    return true;
	    }
	    else {return false;}
   }
	
	
	   public static boolean liczbaM(String pesel) {
		  if(Arrays.asList(1,3,5,7,9).contains(Integer.parseInt(String.valueOf(pesel.charAt(9))))) {
			  return true;
		  }
		  
		  else {
			  JOptionPane.showMessageDialog(null, "Pesel - Cyfra p³ci nie zgadza siê z p³ci¹");
			  return false;
			  }
	   }
	   
		   
	   public static int sprawdzPesel(String pesel, boolean isMale){
		   
		   if(pesel.matches("[0-9]+") && pesel.length() == 11 && secondTwo(pesel) == true) {
			 
			
			if(isMale && liczbaM(pesel)) {
				   return 0;
				   
			   }
			  else if(!isMale && !liczbaM(pesel))
				   return 0;
		   }
		   else {
			   JOptionPane.showMessageDialog(null, "Sprawdz format peselu");
		   return 1;
		   }
		return 1;
	   }
	
	   private static  int checkingPeselUniqueness(JTable Tabela, int index){
	        if(!Tabela.getSelectionModel().isSelectionEmpty()){
	            if (Tabela.getSelectedRow() == index) return 5; 
	        }
	       
	        return 4; //nowy badz edytowany pesel nie jest unikalny
	    }

	  
}
	  
	   

