package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradeDao extends BaseDao{
	public ArrayList<Grade> findgradesBySno_Cterm(String Sno,String Cterm) throws SQLException{
		String sql="SELECT zlj_课程编号,zlj_课程名称,zlj_学时,zlj_学分,zlj_成绩  "+
	                     "FROM zlj_课程_学生成绩  "+
				"WHERE zlj_学期=? AND zlj_学号=? AND zlj_成绩 IS NOT NULL";
		ArrayList<Grade> gradelist = new ArrayList<Grade>();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Cterm);
			pstmt.setString(2, Sno);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				Grade grade = new Grade();
				grade.setCno(rst.getString("zlj_课程编号"));
				grade.setCname(rst.getString("zlj_课程名称"));
				grade.setCtime(rst.getString("zlj_学时"));
				grade.setCcredit(rst.getString("zlj_学分"));
				grade.setSgrade(rst.getString("zlj_成绩"));
				gradelist.add(grade);
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return gradelist;
	}
	public ArrayList<Grade> findgradesByCname_Cterm_Tno(String Cname,String Cterm,String Tno) throws SQLException{
		String sql="SELECT zlj_学号,zlj_姓名,zlj_成绩,zlj_课程编号  "+
	                     "FROM zlj_学生_学生成绩_课程  "+
				"WHERE zlj_课程名称=? AND zlj_教师编号=? AND zlj_学期=?";
		ArrayList<Grade> gradelist = new ArrayList<Grade>();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(3, Cterm);
			pstmt.setString(2, Tno);
			pstmt.setString(1, Cname);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				Grade grade = new Grade();
				grade.setSno(rst.getString("zlj_学号"));
				grade.setSname(rst.getString("zlj_姓名"));
				grade.setSgrade(rst.getString("zlj_成绩"));
				grade.setCno(rst.getString("zlj_课程编号"));
				gradelist.add(grade);
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return gradelist;
	}
	public boolean compareSno_Cno(Grade grade) throws SQLException{
		String sql="SELECT * FROM zhanglj_学生成绩 WHERE zlj_学号=? AND zlj_课程编号=?";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade.getSno());
			pstmt.setString(2, grade.getCno());
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()){
				return true;
			}
			else{
				return false;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
			return false;
		}
		finally{
			conn.close();
		}
	}

	public boolean addSno_Cno(Grade grade) throws SQLException{
		String sql="INSERT INTO zhanglj_学生成绩 VALUES(?,?,null)";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade.getSno());
			pstmt.setString(2, grade.getCno());
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
	public boolean deleteSno_Cno(Grade grade) throws SQLException{
		String sql="DELETE FROM zhanglj_学生成绩 WHERE zlj_课程编号=? AND zlj_学号=?";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade.getCno());
			pstmt.setString(2, grade.getSno());
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
	public boolean updateSno_Cno(Grade grade) throws SQLException{
		String sql="UPDATE zhanglj_学生成绩  SET zlj_成绩=? WHERE zlj_课程编号=? AND zlj_学号=?";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, grade.getCno());
			pstmt.setString(3, grade.getSno());
			pstmt.setString(1, grade.getSgrade());
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
	public ArrayList<Grade> findgradesBySno_year(String Sno,String year) throws SQLException{
		String sql="SELECT zlj_课程编号,zlj_课程名称,zlj_学期,zlj_成绩 "+
	                   "FROM zlj_课程_学生成绩 "+
				      "WHERE zlj_成绩 IS NOT NULL AND zlj_学号=? AND zlj_学期 LIKE '"+year+"%'";
		ArrayList<Grade> gradelist = new ArrayList<Grade>();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Sno);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				Grade grade = new Grade();
				grade.setCno(rst.getString("zlj_课程编号"));
				grade.setCname(rst.getString("zlj_课程名称"));
				grade.setCterm(rst.getString("zlj_学期"));
				grade.setSgrade(rst.getString("zlj_成绩"));
				gradelist.add(grade);
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return gradelist;
    }
	public double findyearaverageBySno_year(String Sno,String year) throws SQLException{
		String sql="SELECT zlj_成绩 "+
	                   "FROM zlj_课程_学生成绩 "+
				      "WHERE zlj_成绩 IS NOT NULL AND zlj_学号=? AND zlj_学期 LIKE '"+year+"%'";
		double sum = 0;
		int count=0;
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Sno);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				double a = Double.parseDouble(rst.getString("zlj_成绩"));
				count++;
				sum += a;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			conn.close();
		}
		return sum/count;
    }
	public ArrayList<Grade> findgradesByDESCNOTNULL(String Cname,String Cterm,String Tno) throws SQLException{
		String sql="SELECT zlj_学号,zlj_姓名,zlj_成绩  "+
	                     "FROM zlj_学生_学生成绩_课程  "+
				"WHERE zlj_课程名称=? AND zlj_教师编号=? AND zlj_学期=? "
	                     +"ORDER BY zlj_成绩 DESC";
		ArrayList<Grade> gradelist = new ArrayList<Grade>();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(3, Cterm);
			pstmt.setString(2, Tno);
			pstmt.setString(1, Cname);
			int n = 0;
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				Grade grade = new Grade();
				grade.setn(++n);
				grade.setSno(rst.getString("zlj_学号"));
				grade.setSname(rst.getString("zlj_姓名"));
				grade.setSgrade(rst.getString("zlj_成绩"));
				gradelist.add(grade);
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return gradelist;
	}
	public double findaveragegrade(String Cname,String Cterm,String Tno) throws SQLException{
		String sql="SELECT zlj_成绩  "+
	                     "FROM zlj_学生_学生成绩_课程  "+
				"WHERE zlj_课程名称=? AND zlj_教师编号=? AND zlj_学期=? AND zlj_成绩 IS NOT NULL";
		ArrayList<Grade> gradelist = new ArrayList<Grade>();
		Connection conn=null;
		int count = 0;
		double sum = 0;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(3, Cterm);
			pstmt.setString(2, Tno);
			pstmt.setString(1, Cname);
			
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				count++;
				double a = Double.parseDouble(rst.getString("zlj_成绩"));
				sum += a;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			conn.close();
		}
		return sum/count;
	}
}
