package com.demo;

import java.sql.*;
import java.util.ArrayList;
import com.demo.Student;
import com.demo.BaseDao;
public class StudentDao extends BaseDao{
	public Student findBySno(String Sno) throws SQLException{
		String sql="SELECT * FROM zhanglj_学生  WHERE zlj_学号=?";
		Student student = new Student();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Sno);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()){
				student.setSno(rst.getString("zlj_学号"));
				System.out.println(rst.getString("zlj_学号"));
				student.setSpassword(rst.getString("zlj_密码"));
				System.out.println(rst.getString("zlj_密码"));
				student.setSname(rst.getString("zlj_姓名"));
				student.setSsex(rst.getString("zlj_性别"));
				student.setSmajor(rst.getString("zlj_专业"));
				student.setSclass(rst.getString("zlj_班级"));
				student.setSarea(rst.getString("zlj_生源所在地"));
				student.setSplace(rst.getString("zlj_地区"));
				student.setScredit(rst.getString("zlj_已修总学分"));
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return student;
}
	public boolean updateStudent(Student student) throws SQLException{
		String sql="UPDATE zhanglj_学生  SET zlj_姓名=?,zlj_性别=?,zlj_专业=?,zlj_班级=?,zlj_生源所在地=?,zlj_地区=? WHERE zlj_学号=?";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(7, student.getSno());
			pstmt.setString(1, student.getSname());
			pstmt.setString(2, student.getSsex());
			pstmt.setString(3, student.getSmajor());
			pstmt.setString(4, student.getSclass());
			pstmt.setString(5, student.getSarea());
			pstmt.setString(6, student.getSplace());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
		finally{
			conn.close();
		}
	}
	public boolean updateScredit(Student student) throws SQLException{
		String sql="UPDATE zhanglj_学生  SET zlj_已修总学分=? WHERE zlj_学号=?";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getScredit());
			pstmt.setString(2, student.getSno());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
		finally{
			conn.close();
		}
	}
	public boolean updateSpassword(Student student) throws SQLException{
		String sql="UPDATE zhanglj_学生  SET zlj_密码=? WHERE zlj_学号=?";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, student.getSno());
			pstmt.setString(1, student.getSpassword());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
		finally{
			conn.close();
		}
	}
}
