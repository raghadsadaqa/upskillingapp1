package assignment.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import assignment.bean.Student;
import assignment.bean.StudentResult;
import assignment.bean.TrainingCourses;
import assignment.dao.StudentDAO;
import assignment.dao.StudentResultDAO;
import assignment.dao.TraCouDAO;
import util.Message;

@ManagedBean(name = "mbSResult")
public class MBStudentResult {
	
	private StudentResult result;
	private StudentResultDAO dao;
	private List<StudentResult> table;
	
	private List<Student> studentTable;
	private List<TrainingCourses> tracouTable;
	
	@PostConstruct
	public void init() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();
		
		TraCouDAO traCouDAO = new TraCouDAO();
		tracouTable = traCouDAO.selectALL();
		
		dao = new StudentResultDAO();
		table = dao.selectALL();
		result = new StudentResult();
	
		result.setStudent(new Student());
		result.setTrainingCourses(new TrainingCourses());
	}
	
	public String save() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();
		
		TraCouDAO traCouDAO = new TraCouDAO();
		tracouTable = traCouDAO.selectALL();
		
		dao = new StudentResultDAO();
		dao.insert(result);
		
		result = new StudentResult();
		System.out.println(result);	
		
		result.setStudent(new Student());
		result.setTrainingCourses(new TrainingCourses());
		
		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateSResult() {
		dao = new StudentResultDAO();
		dao.update(result);
		result = new StudentResult();
		
		result.setTrainingCourses(new TrainingCourses());
		
		return null;
	}
	
	public String deleteSResult() {
		dao = new StudentResultDAO();
		dao.delete(result.getStudent().getStudentid());
		
		result = new StudentResult();
		return null;
	}
	
	public StudentResult getResult() {
		return result;
	}
	public void setResult(StudentResult result) {
		this.result = result;
	}
	public List<StudentResult> getTable() {
		return table;
	}
	public void setTable(List<StudentResult> table) {
		this.table = table;
	}

	public List<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public List<TrainingCourses> getTracouTable() {
		return tracouTable;
	}

	public void setTracouTable(List<TrainingCourses> tracouTable) {
		this.tracouTable = tracouTable;
	}
	
	
	

}