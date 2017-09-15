package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LessonDao extends BaseDao{
	public ArrayList<Lesson> findlessonsByTno_Cterm(String Tno,String Cterm) throws SQLException{
		String sql="SELECT * FROM zhanglj_课程  WHERE zlj_教师编号=? AND zlj_学期=?";
		ArrayList<Lesson> lessonlist = new ArrayList<Lesson>();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Tno);
			pstmt.setString(2, Cterm);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				Lesson lesson = new Lesson();
				lesson.setCno(rst.getString("zlj_课程编号"));
				lesson.setCname(rst.getString("zlj_课程名称"));
				lesson.setTno(rst.getString("zlj_教师编号"));
				lesson.setCterm(rst.getString("zlj_学期"));
				lesson.setCexam(rst.getString("zlj_考试考查"));
				lesson.setCtime(rst.getString("zlj_学时"));
				lesson.setCcredit(rst.getString("zlj_学分"));
				lesson.setCclass(rst.getString("zlj_班级"));
				lessonlist.add(lesson);
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return lessonlist;
}
	public ArrayList<Lesson> findlessonsBySno_Cterm_Sclass(String Sno,String Cterm,String Sclass) throws SQLException{
		String sql="SELECT zlj_课程编号,zlj_课程名称,zlj_姓名,zlj_联系电话,zlj_考试考查,zlj_学时,zlj_学分 "+
	                                "FROM zlj_教师_学生成绩_课程  "+
	                                "WHERE zlj_学号=? AND zlj_学期=? AND zlj_班级=?";
		ArrayList<Lesson> lessonlist = new ArrayList<Lesson>();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Sno);
			pstmt.setString(2, Cterm);
			pstmt.setString(3, Sclass);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				Lesson lesson = new Lesson();
				lesson.setCno(rst.getString("zlj_课程编号"));
				lesson.setCname(rst.getString("zlj_课程名称"));
				lesson.setTname(rst.getString("zlj_姓名"));
				lesson.setTphone(rst.getString("zlj_联系电话"));
				lesson.setCexam(rst.getString("zlj_考试考查"));
				lesson.setCtime(rst.getString("zlj_学时"));
				lesson.setCcredit(rst.getString("zlj_学分"));
				lessonlist.add(lesson);
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return lessonlist;
    }
	public Lesson findByCno(String Cno) throws SQLException{
		String sql="SELECT * FROM zhanglj_课程  WHERE zlj_课程编号=?";
		Lesson lesson = new Lesson();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Cno);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()){
				lesson.setCno(rst.getString("zlj_课程编号"));
				lesson.setCname(rst.getString("zlj_课程名称"));
				lesson.setTno(rst.getString("zlj_教师编号"));
				lesson.setCterm(rst.getString("zlj_学期"));
				lesson.setCexam(rst.getString("zlj_考试考查"));
				lesson.setCtime(rst.getString("zlj_学时"));
				lesson.setCcredit(rst.getString("zlj_学分"));
				lesson.setCclass(rst.getString("zlj_班级"));
				
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return lesson;
		}
	public boolean updateLesson(Lesson lesson) throws SQLException{
		String sql="UPDATE zhanglj_课程  SET zlj_课程名称=?,zlj_学期=?,zlj_考试考查=?,zlj_学时=?,zlj_学分=?,zlj_班级=? WHERE zlj_课程编号=?";
		Connection conn = null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(7, lesson.getCno());
			pstmt.setString(1, lesson.getCname());
			pstmt.setString(2, lesson.getCterm());
			pstmt.setString(3, lesson.getCexam());
			pstmt.setString(4, lesson.getCtime());
			pstmt.setString(5, lesson.getCcredit());
			pstmt.setString(6, lesson.getCclass());
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
	public ArrayList<Lesson> findlessonsByCclass_Cterm(String Cclass,String Cterm) throws SQLException{
		String sql="SELECT zlj_课程编号,zlj_课程名称,zlj_姓名,zlj_考试考查,zlj_学时,zlj_学分 "
	                  +"FROM zlj_教师_课程  "
	                  +"WHERE zlj_班级=? AND zlj_学期=? ";
		ArrayList<Lesson> lessonlist = new ArrayList<Lesson>();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Cclass);
			pstmt.setString(2, Cterm);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				Lesson lesson = new Lesson();
				lesson.setCno(rst.getString("zlj_课程编号"));
				lesson.setCname(rst.getString("zlj_课程名称"));
				lesson.setTname(rst.getString("zlj_姓名"));
				lesson.setCexam(rst.getString("zlj_考试考查"));
				lesson.setCtime(rst.getString("zlj_学时"));
				lesson.setCcredit(rst.getString("zlj_学分"));
				lessonlist.add(lesson);
			}
		}
		catch(SQLException se){
			System.out.println("操作异常");
			return null;
		}
		finally{
			conn.close();
		}
		return lessonlist;
    }
	public ArrayList<Lesson> findlessonsBySno(String Sno) throws SQLException{
		String sql="SELECT zlj_课程编号,zlj_课程名称,zlj_学期,zlj_学时,zlj_学分 "+
	                   "FROM zlj_课程_学生成绩 "+
				      "WHERE zlj_成绩 IS NOT NULL AND zlj_学号=?";
		ArrayList<Lesson> lessonlist = new ArrayList<Lesson>();
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Sno);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				Lesson lesson = new Lesson();
				lesson.setCno(rst.getString("zlj_课程编号"));
				lesson.setCname(rst.getString("zlj_课程名称"));
				lesson.setCterm(rst.getString("zlj_学期"));
				lesson.setCtime(rst.getString("zlj_学时"));
				lesson.setCcredit(rst.getString("zlj_学分"));
				lessonlist.add(lesson);
			}
		}
		catch(SQLException se){
			return null;
		}
		finally{
			conn.close();
		}
		return lessonlist;
    }
	public double findScreditBySno(String Sno) throws SQLException{
		String sql="SELECT zlj_学分 "+
	                   "FROM zlj_课程_学生成绩 "+
				      "WHERE zlj_成绩 IS NOT NULL AND zlj_学号=?";
		double sum = 0.0;
		Connection conn=null;
		try
		{
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Sno);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()){
				double a = Double.parseDouble(rst.getString("zlj_学分"));
				sum += a;
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			conn.close();
		}
		return sum;
    }
}
