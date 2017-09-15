package com.demo;

import java.io.Serializable;

public class Grade implements Serializable{
	private String Sno;
	private String Sname;
	private String Cno;
	private String Cterm;
	private String Sgrade;
	private String Cname;
	private String Ctime;
	private String Ccredit;
	private int n;
	public int getn(){
		return n;
	}
	public void setn(int n){
		this.n = n;
	}
	public String getSno(){
		return Sno;
	}
	public String getSname(){
		return Sname;
	}
	public String getCno(){
		return Cno;
	}
	public String getCterm(){
		return Cterm;
	}
	public String getSgrade(){
		return Sgrade;
	}
	public String getCname(){
		return Cname;
	}
	public String getCtime(){
		return Ctime;
	}
	public String getCcredit(){
		return Ccredit;
	}
	public void setSno(String Sno){
		this.Sno = Sno;
	}
	public void setSname(String Sname){
		this.Sname = Sname;
	}
	public void setCno(String Cno){
		this.Cno = Cno;
	}
	public void setCterm(String Cterm){
		this.Cterm = Cterm;
	}
	public void setSgrade(String Sgrade){
		this.Sgrade = Sgrade;
	}
	public void setCname(String Cname){
		this.Cname = Cname;
	}
	public void setCtime(String Ctime){
		this.Ctime = Ctime;
	}
	public void setCcredit(String Ccredit){
		this.Ccredit = Ccredit;
	}
}
