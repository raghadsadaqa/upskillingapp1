package assignment.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import assignment.bean.Student;
import assignment.bean.StudentTrainingCourse;
import assignment.bean.TrainingCourses;
import assignment.dao.StudentDAO;
import assignment.dao.StudentTraCouDAO;
import assignment.dao.TraCouDAO;
import util.Message;

@ManagedBean(name = "mbSTC")
@ViewScoped
public class MBStudentTrainingCourse {
	
	private StudentTrainingCourse trainingCourse;
	private StudentTraCouDAO dao;
	private List<StudentTrainingCourse> table;
	
	private List<Student> studentTable;
	private List<TrainingCourses> coursesTable;
	
	
	@PostConstruct
	public void init() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();
		System.out.println(studentTable);

		TraCouDAO couDAO = new TraCouDAO();
		coursesTable = couDAO.selectALL();
		System.out.println(coursesTable);
		
		
		dao = new StudentTraCouDAO();
		table = dao.selectALL();
		trainingCourse = new StudentTrainingCourse();
		
		trainingCourse.setStudent(new Student());
		trainingCourse.setCourses(new TrainingCourses());
	}
	
	public String save() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();

		TraCouDAO couDAO = new TraCouDAO();
		coursesTable = couDAO.selectALL();
		
		dao = new StudentTraCouDAO();
		dao.insert(trainingCourse);
		trainingCourse = new StudentTrainingCourse();
		
		trainingCourse.setStudent(new Student());
		trainingCourse.setCourses(new TrainingCourses());
		
		trainingCourse = new StudentTrainingCourse();

		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateSTC() {
		dao = new StudentTraCouDAO();
		dao.update(trainingCourse);
		trainingCourse = new StudentTrainingCourse();
		
		trainingCourse.setCourses(new TrainingCourses());
		
		return null;
	}
	
	public String deleteSTC() {
		dao.delete(trainingCourse.getStudent().getStudentid(), trainingCourse.getCourses().getCourseid());
		trainingCourse = new StudentTrainingCourse();
		return null;
	}
	
	public StudentTrainingCourse getTrainingCourse() {
		return trainingCourse;
	}
	public void setTrainingCourse(StudentTrainingCourse trainingCourse) {
		this.trainingCourse = trainingCourse;
	}
	public List<StudentTrainingCourse> getTable() {
		return table;
	}
	public void setTable(List<StudentTrainingCourse> table) {
		this.table = table;
	}

	public List<TrainingCourses> getCoursesTable() {
		return coursesTable;
	}

	public void setCoursesTable(List<TrainingCourses> coursesTable) {
		this.coursesTable = coursesTable;
	}

	public List<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}
	
	

}
