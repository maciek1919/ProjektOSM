package com;

import java.util.*;

public class Pacjent {
	
	private String imie;
	private String nazwisko;
	private String pesel;
	private String plec;
	private String ubezpieczenie;
	private Boolean badanie;
	private Badanie wynikiBadan;
	
	Pacjent(String imie, String nazwisko, String pesel, Boolean plec, String ubezpieczenie){
		this.imie = imie;	
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		if(plec)this.plec= "M"; else this.plec = "K"; 
		this.ubezpieczenie = ubezpieczenie;
		this.badanie = false;
	}
	
	public Object [] listaPacjenta(){
        return new Object[]{getImie()+" "+getNazwisko(),getPlec(),getPesel(),getUbezpieczenie(),isBadanie()};
    }

    public Boolean getBoolPlec(){
        Boolean boolPlec;
        boolPlec = this.plec.equals("M");
        return boolPlec;
    }

    public int ubezpieczenieInt(){
      int insInt =0;
      if(Objects.equals(this.ubezpieczenie, "Brak"))insInt = 0;
      else if(Objects.equals(this.ubezpieczenie, "NFZ"))insInt = 1;
      else if (Objects.equals(this.ubezpieczenie, "Prywatne"))insInt = 2;
       return insInt;
    }
    
    

	private String getUbezpieczenie() { return ubezpieczenie; }

    public String getImie() { return imie; }

    public String getNazwisko() { return nazwisko;}

    private String getPlec() { return plec; }

    public String getPesel() { return pesel; }

    public Boolean isBadanie() { return badanie; }
    
    public Badanie getWynikiBadan() {return wynikiBadan;}

    
    public void setWynikiBadan(Date data, String sData, int lleukocytow, int lerytrocytow, int lneutrofili) {
    	
    	if(badanie) wynikiBadan.setBadanie(data, sData, lleukocytow, lerytrocytow, lneutrofili);
    	else wynikiBadan = new Badanie(data, sData, lleukocytow, lerytrocytow, lneutrofili);
    }

    public void setBadanie(boolean badanie) {this.badanie = badanie;}
    
    public void setBadanieEdit(Badanie bad2) {this.wynikiBadan = bad2;}
    
}
