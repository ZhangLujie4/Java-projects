package com.demo;

import java.io.Serializable;

public class Student implements Serializable{
	private String Sno;
	private String Sname;
	private String Ssex;
	private String Smajor;
	private String Sclass;
	private String Sarea;
	private String Splace;
	private String Scredit;
	private String Spassword;
	public String getSno(){
		return Sno;
	}
	public String getSname(){
		return Sname;
	}
	public String getSsex(){
		return Ssex;
	}
	public String getSmajor(){
		return Smajor;
	}
	public String getSclass(){
		return Sclass;
	}
	public String getSarea(){
		return Sarea;
	}
	public String getSplace(){
		return Splace;
	}
	public String getScredit(){
		return Scredit;
	}
	public String getSpassword(){
		return Spassword;
	}
	public void setSno(String Sno){
		this.Sno = Sno;
	}
	public void setSname(String Sname){
		this.Sname = Sname;
	}
	public void setSsex(String Ssex){
		this.Ssex = Ssex;
	}
	public void setSmajor(String Smajor){
		this.Smajor = Smajor;
	}
	public void setSclass(String Sclass){
		this.Sclass = Sclass;
	}
	public void setSarea(String Sarea){
		this.Sarea = Sarea;
	}
	public void setSplace(String Splace){
		this.Splace = Splace;
	}
	public void setScredit(String Scredit){
		this.Scredit = Scredit;
	}
	public void setSpassword(String Spassword){
		this.Spassword = Spassword;
	}
}
