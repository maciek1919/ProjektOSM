package com;

import java.util.Date;

public class Badanie {

	private static int lleukocytow;
	private static int lneutrofili;
	private static int lerytrocytow;
	private String sData;
	private Date data;
	
	Badanie(Date data, String sData, int lleukocytow, int lerytrocytow, int lneutrofili){
		
		this.lleukocytow = lleukocytow;
		this.lerytrocytow = lerytrocytow;
		this.lneutrofili = lneutrofili;
		this.sData = sData;
		this.data = data;
		
	}
	
	public void setBadanie(Date data, String sData, int lleukocytow, int lerytrocytow, int lneutrofili){
		this.sData = sData;
		this.data = data;
		this.lleukocytow = lleukocytow;
		this.lerytrocytow = lerytrocytow;
		this.lneutrofili = lneutrofili;
		
	}
	
	public Object[] listaBadania() {
		return new Object[] {getlleukocytow(), getlerytrocytow(), getlneutrofili()};
		
	}

	public String getsData() {return sData;}
	
	public Date getdata() {return data;}
	
	public static int getlneutrofili() {return lneutrofili;}

	public static int getlleukocytow() {return lleukocytow;}
	 
	public static int getlerytrocytow() {return lerytrocytow;}
	
	
}
