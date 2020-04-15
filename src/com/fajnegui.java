package com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.apache.commons.lang3.StringUtils;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.Presenter;


//import org.jdatepicker.impl.DateComponentFormatter;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;

//import com.toedter.calendar.*;

	

public class fajnegui implements Runnable, ActionListener {
	
	private static final String String = null;
	//Deklaracje
	private JPanel leftTop, leftBottom, panel;
	private Presenter presenter;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem mZamknij;
	private JLabel lImie,lNazwisko, lPesel, lPlec, lUbezpieczenie, lDanePacjenta, lData, lBadanie, lneutrofili, lleukocytow, lerytrocytow,lwynik, lwynik1;
	private JTextField TFImie, TFNazwisko, TFPesel, TFneutrofili, TFleukocytow, TFerytrocytow;
	private JRadioButton RF;
	private JRadioButton RM;
	private static JRadioButton RP, RN;
	private ButtonGroup radioPanel, radioPanel1;
	private JComboBox CBUbezpieczenie;
	private JButton BZapisz1, BAnuluj1, BZapisz2, BAnuluj2, BDodaj, BUsun,BSprawdz;
	//private JCalendar kalendarz;
	private JDatePickerImpl datePicker;
	private int yearInit, monthInit, dayInit;
	private JTable Tabela;
	//private JScrollPane scrollPane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new fajnegui());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("OSM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        presenter = new Presenter();
        JPanel mainPanel = new JPanel();
        mainPanel.add(createLeftPanel());
        mainPanel.add(createRightPanel());

        frame.add(mainPanel);
        frame.setSize(850,650);
        //frame.pack();
        frame.setVisible(true);
  //----------MENU-------------//
        menuBar = new JMenuBar();
		menu = new JMenu("Aplikacja");
		mZamknij = new JMenuItem("Zamknij program");
		
		frame.setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(mZamknij);
		
		mZamknij.addActionListener(this);
    }
//----------------DANE PACJENTA---------------//
    private JPanel createLeftPanel() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

    	
        leftTop = new JPanel();
        leftTop.setPreferredSize(new Dimension(350,300));
        
        String title = "Dane pacjenta";
		Border border = BorderFactory.createTitledBorder(title);
		leftTop.setBorder(border);
		
        leftTop.setLayout(null);
		
		lImie = new JLabel("Imiê");
		lImie.setBounds(20,60,100,20);
		leftTop.add(lImie);
		
		TFImie = new JTextField();
		TFImie.setBounds(150, 60, 150, 20);
		leftTop.add(TFImie);
		
		lNazwisko = new JLabel("Nazwisko:");
		lNazwisko.setBounds(20, 90, 100, 20);
		leftTop.add(lNazwisko);
		
		lPesel = new JLabel("Pesel:");
		lPesel.setBounds(20, 120, 100, 20);
		leftTop.add(lPesel);
		
		lPlec = new JLabel("P³eæ");
		lPlec.setBounds(20,150,100,20);
		leftTop.add(lPlec);
		
		radioPanel = new ButtonGroup();	
		
		RF = new JRadioButton("Kobieta", false);
		RM = new JRadioButton("Mê¿czyzna", false);
		RF.setBounds(150, 150, 90, 20);
		RM.setBounds(250, 150, 90, 20);
		radioPanel.add(RF);
		radioPanel.add(RM);
		leftTop.add(RF);
		leftTop.add(RM);
		
		lUbezpieczenie = new JLabel("Ubezpieczenie:");
		lUbezpieczenie.setBounds(20,180, 100, 20);
		leftTop.add(lUbezpieczenie);
		
		TFNazwisko = new JTextField();
		TFNazwisko.setBounds(150,90,150,20);
		leftTop.add(TFNazwisko);
		
		TFPesel = new JTextField();
		TFPesel.setBounds(150,120,150,20);
		leftTop.add(TFPesel);
			
		String[] rodzajeUbezpieczen = {"Brak", "NFZ", "Prywatne"};
        CBUbezpieczenie = new JComboBox<>(rodzajeUbezpieczen);
        CBUbezpieczenie.setBounds(150,180,150,20);
        CBUbezpieczenie.setSelectedIndex(-1);
		leftTop.add(CBUbezpieczenie);
		
		BZapisz1 = new JButton("Zapisz");
		BZapisz1.setBounds(20, 210, 100, 20);
		BZapisz1.addActionListener(this);
		leftTop.add(BZapisz1);
		
		BAnuluj1 = new JButton("Anuluj");
		BAnuluj1.setBounds(20, 250, 100, 20);
		BAnuluj1.addActionListener(this);
		leftTop.add(BAnuluj1);
		presenter.setPanelEdit(leftTop, false);
        panel.add(leftTop, BorderLayout.NORTH);
//------------BADANIE--------------------//
        leftBottom = new JPanel();
        
        leftBottom.setPreferredSize(new Dimension(350,250));
        String title1 = "Badanie";
		Border border1 = BorderFactory.createTitledBorder(title1);
		leftBottom.setBorder(border1);
        leftBottom.setLayout(null);
      
        lData = new JLabel("Data:");
        lData.setBounds(20, 45, 100, 20);
        leftBottom.add(lData);
        
        lleukocytow = new JLabel("Liczba leukocytóww: ");
        lleukocytow.setBounds(20, 90, 150, 20);
        leftBottom.add(lleukocytow);
        
        lneutrofili = new JLabel("Liczba neutrofili:");
        lneutrofili.setBounds(20, 120, 150, 20);
        leftBottom.add(lneutrofili);
        
        lerytrocytow = new JLabel("Liczba erytrocytów:");
        lerytrocytow.setBounds(20, 150, 150, 20);
        leftBottom.add(lerytrocytow);
        
        TFleukocytow = new JTextField();
        TFleukocytow.setBounds(200, 90, 100, 20);
        leftBottom.add(TFleukocytow);
        
        TFneutrofili = new JTextField();
        TFneutrofili.setBounds(200, 120, 100, 20);
        leftBottom.add(TFneutrofili);
        
        TFerytrocytow = new JTextField();
        TFerytrocytow.setBounds(200, 150, 100, 20);
        leftBottom.add(TFerytrocytow);
        
        lwynik = new JLabel("Wynik:");
        lwynik.setBounds(20, 180, 100, 20);
        leftBottom.add(lwynik);
        
        lwynik1 = new JLabel("");
        lwynik1.setBounds(200,180,150,20);
        leftBottom.add(lwynik1);
        
        radioPanel1 = new ButtonGroup();	
        
        BZapisz2 = new JButton("Zapisz");
		BZapisz2.setBounds(20, 220, 100, 20);
		BZapisz2.addActionListener(this);
		leftBottom.add(BZapisz2);
		
		BAnuluj2 = new JButton("Anuluj");
		BAnuluj2.setBounds(120, 220, 100, 20);
		BAnuluj2.addActionListener(this);
		leftBottom.add(BAnuluj2);
		
		
        Properties p = new Properties();
        UtilDateModel model = new UtilDateModel();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new Kalendarz());
        datePicker.getJFormattedTextField().setColumns(15);
        yearInit = datePicker.getModel().getYear(); 	
        monthInit = datePicker.getModel().getMonth();
        dayInit = datePicker.getModel().getDay();
        datePicker.getJFormattedTextField().setText("");

  
        datePicker.setBounds(200, 45, 140, 30);
		leftBottom.add(datePicker);
		
		
				TFerytrocytow.getDocument().addDocumentListener(new DocumentListener() {
				
				
				@Override
	            public void insertUpdate(DocumentEvent e) {
	                sprawdzenie(TFleukocytow.getText(), TFneutrofili.getText(), TFerytrocytow.getText());
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	            	sprawdzenie(TFleukocytow.getText(), TFneutrofili.getText(), TFerytrocytow.getText());
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	            	sprawdzenie(TFleukocytow.getText(), TFneutrofili.getText(), TFerytrocytow.getText());
	            }
	            
				
				private void sprawdzenie(String lleukocytow, String lneutrofili, String lerytrocytow) {
					
					if(!StringUtils.isEmpty(lleukocytow) && !StringUtils.isEmpty(lneutrofili) && !StringUtils.isEmpty(lerytrocytow)) {
						if(TFleukocytow.getText().matches("[0-9]+") && TFneutrofili.getText().matches("[0-9]+") && TFerytrocytow.getText().matches("[0-9]+") ) {
							boolean wynik = presenter.isPozytywny(Integer.parseInt(lleukocytow), Integer.parseInt(lneutrofili), Integer.parseInt(lerytrocytow));
							if(!wynik) {
								lwynik1.setText("Negatywny");
							}
							else {lwynik1.setText("Pozytywny");}				
						}
						else {lwynik1.setText("Z³y format badania");}

					}
					else {lwynik1.setText("Brak danych");}
				}
				
				
				
			});
			
				TFneutrofili.getDocument().addDocumentListener(new DocumentListener() {
					
					
					@Override
		            public void insertUpdate(DocumentEvent e) {
		                sprawdzenie(TFleukocytow.getText(), TFneutrofili.getText(), TFerytrocytow.getText());
		            }

		            @Override
		            public void removeUpdate(DocumentEvent e) {
		            	sprawdzenie(TFleukocytow.getText(), TFneutrofili.getText(), TFerytrocytow.getText());
		            }

		            @Override
		            public void changedUpdate(DocumentEvent e) {
		            	sprawdzenie(TFleukocytow.getText(), TFneutrofili.getText(), TFerytrocytow.getText());
		            }
		            
					
					private void sprawdzenie(String lleukocytow, String lneutrofili, String lerytrocytow) {
						
						if(!StringUtils.isEmpty(lleukocytow) && !StringUtils.isEmpty(lneutrofili) && !StringUtils.isEmpty(lerytrocytow)) {
							if(TFleukocytow.getText().matches("[0-9]+") && TFneutrofili.getText().matches("[0-9]+") && TFerytrocytow.getText().matches("[0-9]+") ) {
								boolean wynik = presenter.isPozytywny(Integer.parseInt(lleukocytow), Integer.parseInt(lneutrofili), Integer.parseInt(lerytrocytow));
								if(!wynik) {
									lwynik1.setText("Negatywny");
								}
								else {lwynik1.setText("Pozytywny");}				
							}
							else {lwynik1.setText("Z³y format badania");}

						}
						else {lwynik1.setText("Brak danych");}
					}
					
					
					
				});
				
				TFleukocytow.getDocument().addDocumentListener(new DocumentListener() {
					
					
					@Override
		            public void insertUpdate(DocumentEvent e) {
		                sprawdzenie(TFleukocytow.getText(), TFneutrofili.getText(), TFerytrocytow.getText());
		            }

		            @Override
		            public void removeUpdate(DocumentEvent e) {
		            	sprawdzenie(TFleukocytow.getText(), TFneutrofili.getText(), TFerytrocytow.getText());
		            }

		            @Override
		            public void changedUpdate(DocumentEvent e) {
		            	sprawdzenie(TFleukocytow.getText(), TFneutrofili.getText(), TFerytrocytow.getText());
		            }
		            
					
					private void sprawdzenie(String lleukocytow, String lneutrofili, String lerytrocytow) {
						
						if(!StringUtils.isEmpty(lleukocytow) && !StringUtils.isEmpty(lneutrofili) && !StringUtils.isEmpty(lerytrocytow)) {
							if(TFleukocytow.getText().matches("[0-9]+") && TFneutrofili.getText().matches("[0-9]+") && TFerytrocytow.getText().matches("[0-9]+") ) {
								boolean wynik = presenter.isPozytywny(Integer.parseInt(lleukocytow), Integer.parseInt(lneutrofili), Integer.parseInt(lerytrocytow));
								if(!wynik) {
									lwynik1.setText("Negatywny");
								}
								else {lwynik1.setText("Pozytywny");}				
							}
							else {lwynik1.setText("Z³y format badania");}

						}
						else {lwynik1.setText("Brak danych");}
					}
					
					
					
				});
				
			panel.add(leftBottom, BorderLayout.SOUTH);
			presenter.setPanelEdit(leftBottom, false);
			datePicker.getComponent(1).setEnabled(false); 
			
	        return panel;
	    }	

		
     
	
	   
  //------------------Tabela---------------//
    private JPanel createRightPanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));        
        panel.setPreferredSize(new Dimension(450, 550));
        String title2 = "Zapisani pacjenci";
		Border border2 = BorderFactory.createTitledBorder(title2);
		panel.setBorder(border2);
         
        
        
        Tabela = new JTable() {
        	private static final long serialVersionUID = 1L;
        	@Override
        	public Class getColumnClass(int column) {
        		switch (column) {
        			case 4:
        				return Boolean.class;
        			default:
        				return String.class;
        		}
        	}
        };
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(Presenter.columnNames);
        Tabela.setModel(defaultTableModel);
        Tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        Tabela.setModel(defaultTableModel);
        Tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Tabela.getSelectionModel().addListSelectionListener(e -> Wypisywanie() );
        Tabela.getTableHeader().setReorderingAllowed(false); 
        Tabela.getTableHeader().setResizingAllowed(false);
        
        JScrollPane scrollPane = new JScrollPane(Tabela, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane);
        																																																																																																																																																																																																																																																																																																																																																																																																																														

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
		
		
		
		JPanel przyciskPanel = new JPanel();
		BDodaj = new JButton("Dodaj");
		BDodaj.addActionListener(e-> { 
			
			czyszczeniePaneli();
			presenter.setPanelEdit(leftTop, true);
			Tabela.clearSelection();
			BZapisz1.setText("Zapisz");
		});
		
		BUsun = new JButton("Usuñ");
		przyciskPanel.add(BDodaj);
		przyciskPanel.add(BUsun);
		przyciskPanel.setPreferredSize(new Dimension(20,20));
        panel.add(przyciskPanel);
        
        BUsun.setEnabled(false);
        
        BUsun.addActionListener(e -> {presenter.usuwaniePacjenta(Tabela.getSelectedRow() ,Tabela);
        czyszczeniePaneli();
        BUsun.setEnabled(false);
        });
  
		return panel;
		
}
    
    	

    	private void Wypisywanie(){
        if(!Tabela.getSelectionModel().isSelectionEmpty()) { //when row selected
            BUsun.setEnabled(true);
            Presenter.setPanelEdit(leftBottom, true);
            datePicker.getComponent(1).setEnabled(true);
            Presenter.setPanelEdit(leftTop, true);

            TFImie.setText(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getImie());
            TFNazwisko.setText(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getNazwisko());
            TFPesel.setText(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getPesel());
            RM.setSelected(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getBoolPlec());
            RF.setSelected(!presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getBoolPlec());
            CBUbezpieczenie.setSelectedIndex(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).ubezpieczenieInt());
            BZapisz1.setText("Edytuj");
            czyszczenieBadania();
            wypisywanieBadania();	
          
        }
        else 
        	
        	BUsun.setEnabled(false);
        };
       
        
        
        	private void wypisywanieBadania() {
        		if(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).isBadanie()) {
        			
        			TFleukocytow.setText(String.valueOf(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getWynikiBadan().getlleukocytow()));
        			TFerytrocytow.setText(String.valueOf(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getWynikiBadan().getlerytrocytow()));
        			TFneutrofili.setText(String.valueOf(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getWynikiBadan().getlneutrofili()));
        			
        			LocalDate localDate = presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getWynikiBadan().getdata().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        			datePicker.getJFormattedTextField().setText(presenter.pacjentVectorList.get(Tabela.getSelectedRow()).getWynikiBadan().getsData());
        			int year  = localDate.getYear();
                    int month = localDate.getMonthValue();
                    int day   = localDate.getDayOfMonth();
        			datePicker.getModel().setDate(year, month-1, day);
                    datePicker.getModel().setSelected(true);
                    BZapisz2.setText("Edytuj");
        		}
        	}
        	
        	private void czyszczeniePacjenta() {
        		presenter.clearTextFields(leftTop);
        		radioPanel.clearSelection();
    			CBUbezpieczenie.setSelectedIndex(-1);
        	}
        	
        	private void czyszczenieBadania() {
        		presenter.clearTextFields(leftBottom);	
        		lwynik1.setText("");
        	}
        	
        	private void czyszczeniePaneli() {
        		presenter.setPanelEdit(leftBottom, false);
        		presenter.setPanelEdit(leftTop, false);
        		czyszczeniePacjenta();
        		czyszczenieBadania();
        		datePicker.getComponent(1).setEnabled(false); 		
        		
  	        	
        	}
        	
        
        	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == mZamknij)
		{	
			System.exit(0);
		}
		
		if(source == BAnuluj1)
		{
			czyszczeniePacjenta();
			if(BZapisz1.getText()=="Edytuj") {
				czyszczeniePaneli();
				Tabela.getSelectionModel().clearSelection();
			}
		
		}
		
		if(source == BAnuluj2)
		{
			czyszczenieBadania();
			if(BZapisz2.getText()=="Edytuj") {
				czyszczeniePaneli();
				Tabela.getSelectionModel().clearSelection();
			}
			
		}
		
		if(source ==BZapisz1)
		{
			
			if(Tabela.getSelectionModel().isSelectionEmpty()) {
				if(CBUbezpieczenie.getSelectedIndex() == -1 ||!RM.isSelected() && !RF.isSelected()) {
					zabezpieczenia.errorMessage(1);
					
				}
				else {
				int zapis = Presenter.zapiszPacjenta(TFImie.getText(), TFNazwisko.getText(), TFPesel.getText(), RM.isSelected(), CBUbezpieczenie.getSelectedItem().toString(), Tabela);
				if(zapis == 0) {
					Wypisywanie();
				}
				return;
			
				}
			}
			
			
			else {
			int edycja = presenter.edycjaPacjanta(TFImie.getText(), TFNazwisko.getText(), TFPesel.getText(), RM.isSelected(), String.valueOf(CBUbezpieczenie.getSelectedItem()), Tabela);
			if(edycja == 1) {
        		BZapisz2.setText("Zapisz");
        		//czyszczeniePaneli();
        		return;
        	}
			}
		}
		
		if(source == BZapisz2)
		{
			int checkValue;
			checkValue = presenter.zapiszBadanie(TFleukocytow.getText(), TFerytrocytow.getText(), TFneutrofili.getText(), (Date) datePicker.getModel().getValue(),Tabela, datePicker.getJFormattedTextField().getText());
			if (checkValue == 0) {
				wypisywanieBadania();
				BZapisz2.setText("Edytuj");
			}
		}
		
	}
	
	
}