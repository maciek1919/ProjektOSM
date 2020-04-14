package com;

import java.awt.*;
import java.util.Vector;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Presenter {
	
	  public static Vector<Pacjent> pacjentVectorList = new Vector<>();
	  static String[] columnNames = {"Imiê i Nazwisko", "P³eæ", "PESEL", "Ubezpieczenie", "Badanie"};
	
	  public static void clearTextFields(JPanel panel){
	       Component[] components = panel.getComponents();
	       for (Component component : components) {
	           if (component instanceof JPanel) clearTextFields((JPanel) component);
	           if(component instanceof JTextField)((JTextField) component).setText("");
	       }
	   }
	  
	   private static DefaultTableModel createTableM(Object[][] data){
		    return new DefaultTableModel(data, columnNames){
		        @Override
		        public boolean isCellEditable(int row, int column) {
		            return false;
		        }
		    };
	  
	   }
	   
	   public static void tableUpdate(Vector<Pacjent> pacjentVectorList, JTable Tabela){
		      Object[][] data = new Object[pacjentVectorList.size()][5];
		      for(int i =0; i<pacjentVectorList.size();i++) data[i] = pacjentVectorList.get(i).listaPacjenta();
		      Tabela.setModel(createTableM(data));
		      TableColumn column = null;
				for (int i = 0; i < 5; i++) {
				   column = Tabela.getColumnModel().getColumn(i);
				  if (i == 0 || i ==2 || i==3) 
				  {
				      column.setPreferredWidth(100); 
				  } 
				  else 
				  {
				    column.setPreferredWidth(50);
				  }
				}
		      
				
		  }
	   
	   
	   
	  
	   
	   public static int zapiszPacjenta(String imie, String nazwisko, String pesel, boolean plec, String ubezpieczenie, JTable Tabela){
	        
		   
		   int check = zabezpieczenia.sprawdzPacjenta(imie, nazwisko, pesel, Tabela, plec);
	        
	        
	        if(check == 0 ){
	        	
	            Pacjent pacjent = new Pacjent(imie, nazwisko, pesel, plec, ubezpieczenie);
	            pacjentVectorList.add(pacjent);
	            tableUpdate(pacjentVectorList, Tabela);
	            ListSelectionModel selectionModel = Tabela.getSelectionModel();
	            selectionModel.setSelectionInterval(pacjentVectorList.size()-1, pacjentVectorList.size()-1);
	        	
	        }
	        
	        zabezpieczenia.errorMessage(check);
	        return check;
	    }
	   
	   public static void setPanelEdit(JPanel panel, Boolean isEditable){
	       panel.setEnabled(isEditable);

	       Component[] components = panel.getComponents();
	       for (Component component : components) {
	           if (component.getClass().getName().equals("javax.swing.JPanel")) {
	               setPanelEdit((JPanel) component, isEditable); 
	           }

	           component.setEnabled(isEditable);
	       }
	   }
	   
	   public static int zapiszBadanie(String lleukocytow, String lerytrocytow, String lneutrofili, Date data, JTable Tabela, String sData) {
		   int check = zabezpieczenia.sprawdzBadanie(lleukocytow, lneutrofili, lerytrocytow, Tabela,sData, data);
		   if(check == 0) {
			   pacjentVectorList.get(Tabela.getSelectedRow()).setWynikiBadan(data, sData, Integer.parseInt(lleukocytow), Integer.parseInt(lerytrocytow), Integer.parseInt(lneutrofili));
	           pacjentVectorList.get(Tabela.getSelectedRow()).setBadanie(true);
			   tableUpdate(pacjentVectorList,Tabela);
			   ListSelectionModel selectionModel = Tabela.getSelectionModel();
	           selectionModel.setSelectionInterval(pacjentVectorList.size()-1, pacjentVectorList.size()-1);
			   
			   return 0;
		   }
		   else {
			   
		   return 1;
		   }
	   }
	   
	   public static int usuwaniePacjenta(int index, JTable Tabela) {
		 pacjentVectorList.remove(index);
		 tableUpdate(pacjentVectorList, Tabela);
		 
		 return 1;
		   
	   }
	   
	public static boolean isPozytywny(int lleukocytow, int lerytrocytow, int lneutrofili) {
		boolean pozytywny = false;
		
		if(lleukocytow > 100 && lerytrocytow > 100 && lneutrofili < 100) {
			pozytywny = true;
			
		}
		
		return pozytywny;
		
	}

	   public int edycjaPacjanta(String imie, String nazwisko, String pesel, boolean plec, String ubezpieczenie, JTable Tabela) {
		   int check = zabezpieczenia.sprawdzPacjenta(imie, nazwisko, pesel, Tabela, plec);

		   if(check == 4) {
			   JOptionPane.showMessageDialog(null, "Istnieje pacjent z tym samym numer pesel", "Warning", JOptionPane.WARNING_MESSAGE);
		   }
		   if(check == 0 || check == 5) {
			   
			   Pacjent pacjent = new Pacjent(imie, nazwisko, pesel,plec ,ubezpieczenie);			   
			   if(pacjentVectorList.get(Tabela.getSelectedRow()).isBadanie()) {
				   Badanie badanie = pacjentVectorList.get(Tabela.getSelectedRow()).getWynikiBadan();
				   pacjent.setBadanie(true);
				   pacjent.setBadanieEdit(badanie);
			   }
			  
			   pacjentVectorList.set(Tabela.getSelectedRow(), pacjent);
			   tableUpdate(pacjentVectorList, Tabela);
			   check = 0;		   
		   }
		zabezpieczenia.errorMessage(check);
		return check;
		 
	   }
	   
	  
	  
	  
}