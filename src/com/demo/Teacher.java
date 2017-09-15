package com.demo;

import java.io.Serializable;

public class Teacher implements Serializable{
	private String Tno;
	private String Tname;
	private String Tsex;
	private String Tage;
	private String Ttitle;
	private String Tphone;
	private String Tpassword;
	public String getTno(){
		return Tno;
	}
	public String getTname(){
		return Tname;
	}
	public String getTsex(){
		return Tsex;
	}
	public String getTage(){
		return Tage;
	}
	public String getTtitle(){
		return Ttitle;
	}
	public String getTphone(){
		return Tphone;
	}
	public String getTpassword(){
		return Tpassword;
	}
	public void setTno(String Tno){
		this.Tno = Tno;
	}
	public void setTname(String Tname){
		this.Tname = Tname;
	}
	public void setTsex(String Tsex){
		this.Tsex = Tsex;
	}
	public void setTage(String Tage){
		this.Tage = Tage;
	}
	public void setTtitle(String Ttitle){
		this.Ttitle = Ttitle;
	}
	public void setTphone(String Tphone){
		this.Tphone = Tphone;
	}
	public void setTpassword(String Tpassword){
		this.Tpassword = Tpassword;
	}

}
