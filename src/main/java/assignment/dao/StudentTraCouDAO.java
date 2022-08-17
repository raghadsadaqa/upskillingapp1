package assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.Student;
import assignment.bean.StudentTrainingCourse;
import assignment.bean.TrainingCourses;
import database.Database;

public class StudentTraCouDAO {

	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;
	List<StudentTrainingCourse> studentTrainingCoursesTable;
	
	public List<StudentTrainingCourse> selectALL(){
		studentTrainingCoursesTable = new ArrayList<StudentTrainingCourse>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select student_id, course_id, course_priority from student_training_course order by student_id, course_id");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				StudentTrainingCourse studentTrainingCourse = new StudentTrainingCourse(rs.getInt("course_priority"));
			
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.selectById(rs.getInt("student_id"));
				studentTrainingCourse.setStudent(student);
				
				TraCouDAO traCouDAO = new TraCouDAO();
				TrainingCourses trainingCourses = traCouDAO.selectById(rs.getInt("course_id"));
				studentTrainingCourse.setCourses(trainingCourses);
				
				studentTrainingCoursesTable.add(studentTrainingCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		
		return studentTrainingCoursesTable;
		
	}
	
	public StudentTrainingCourse selectById(int id){
		StudentTrainingCourse studentTrainingCourse = new StudentTrainingCourse();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select student_id, course_id, course_priority from student_training_course where course_id = ? order by student_id, course_id");
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				studentTrainingCourse = new StudentTrainingCourse(rs.getInt("course_priority"));
				
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.selectById(rs.getInt("student_id"));
				studentTrainingCourse.setStudent(student);
				
				TraCouDAO traCouDAO = new TraCouDAO();
				TrainingCourses trainingCourses = traCouDAO.selectById(rs.getInt("course_id"));
				studentTrainingCourse.setCourses(trainingCourses);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		
		return studentTrainingCourse;
		
	}
	
	
	public int insert(StudentTrainingCourse studentTrainingCourse) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student_training_course(student_id, course_id, course_priority) values(?, ?, ?)");
			
			int counter = 1;
			ps.setInt(counter++, studentTrainingCourse.getStudent().getStudentid());
			ps.setInt(counter++, studentTrainingCourse.getCourses().getCourseid());
			ps.setInt(counter++, studentTrainingCourse.getPriority());
			
			row = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
	}
	
	public int update(StudentTrainingCourse studentTrainingCourse) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update student_training_course set course_priority = ? where student_id = ?, course_id = ?");
			
			int counter = 1;
			
			ps.setInt(counter++, studentTrainingCourse.getPriority());
			ps.setInt(counter++, studentTrainingCourse.getStudent().getStudentid());
			ps.setInt(counter++, studentTrainingCourse.getCourses().getCourseid());
			
			row = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
	}
	
	public int delete(int id1, int id2) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from student_training_course where student_id = ?, course_id = ?");
			
			int counter = 1;
			
			ps.setInt(counter++, id1);
			ps.setInt(counter++, id2);
			
			row = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
	}
	
}
