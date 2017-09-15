package com.demo;

import java.sql.*;
import java.util.ArrayList;
import com.demo.Teacher;
import com.demo.BaseDao;

public class TeacherDao extends BaseDao{
	public Teacher findByTno(String Tno) throws SQLException{
		String sql="SELECT * FROM zhanglj_教师  WHERE zlj_教师编号=?";
		Teacher teacher = new Teacher();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Tno);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()){
				teacher.setTage(rst.getString("zlj_年龄"));
				teacher.setTname(rst.getString("zlj_姓名"));
				teacher.setTno(rst.getString("zlj_教师编号"));
				teacher.setTpassword(rst.getString("zlj_密码"));
				teacher.setTphone(rst.getString("zlj_联系电话"));
				teacher.setTsex(rst.getString("zlj_性别"));
				teacher.setTtitle(rst.getString("zlj_职称"));
				
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return teacher;
}
	public boolean updateTeacher(Teacher teacher) throws SQLException{
		String sql="UPDATE zhanglj_教师  SET zlj_姓名=?,zlj_性别=?,zlj_年龄=?,zlj_职称=?,zlj_联系电话=? WHERE zlj_教师编号=?";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(6, teacher.getTno());
			pstmt.setString(1, teacher.getTname());
			pstmt.setString(2, teacher.getTsex());
			pstmt.setString(3, teacher.getTage());
			pstmt.setString(4, teacher.getTtitle());
			pstmt.setString(5, teacher.getTphone());
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
	public boolean updateTpassword(Teacher teacher) throws SQLException{
		String sql="UPDATE zhanglj_教师  SET zlj_密码=? WHERE zlj_教师编号=?";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, teacher.getTno());
			pstmt.setString(1, teacher.getTpassword());
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
