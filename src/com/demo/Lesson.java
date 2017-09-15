package com.demo;

import java.io.Serializable;

public class Lesson implements Serializable{
	private String Cno;
	private String Cname;
	private String Tno;
	private String Tname;
	private String Tphone;
	private String Cterm;
	private String Cexam;
	private String Ctime;
	private String Ccredit;
	private String Cclass;
	public String getCno(){
		return Cno;
	}
	public String getCname(){
		return Cname;
	}
	public String getTno(){
		return Tno;
	}
	public String getTname(){
		return Tname;
	}
	public String getTphone(){
		return Tphone;
	}
	public String getCterm(){
		return Cterm;
	}
	public String getCexam(){
		return Cexam;
	}
	public String getCtime(){
		return Ctime;
	}
	public String getCcredit(){
		return Ccredit;
	}
	public String getCclass(){
		return Cclass;
	}
	public void setCno(String Cno){
		this.Cno = Cno;
	}
	public void setCname(String Cname){
		this.Cname = Cname;
	}
	public void setTno(String Tno){
		this.Tno = Tno;
	}
	public void setTname(String Tname){
		this.Tname = Tname;
	}
	public void setTphone(String Tphone){
		this.Tphone = Tphone;
	}
	public void setCterm(String Cterm){
		this.Cterm = Cterm;
	}
	public void setCexam(String Cexam){
		this.Cexam = Cexam;
	}
	public void setCtime(String Ctime){
		this.Ctime = Ctime;
	}
	public void setCcredit(String Ccredit){
		this.Ccredit = Ccredit;
	}
	public void setCclass(String Cclass){
		this.Cclass = Cclass;
	}
}
