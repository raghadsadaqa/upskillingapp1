package assignment.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import assignment.bean.Interview;
import assignment.bean.Student;
import assignment.bean.StudentResult;
import assignment.dao.InterviewDAO;
import assignment.dao.StudentDAO;
import assignment.dao.StudentResultDAO;
import util.Message;


@ManagedBean (name = "mbInterview")
@ViewScoped
public class MBInterview {

	private Interview interview;
	private InterviewDAO dao;
	List<Interview> table;
	
	List<Student> studentTable;
	List<StudentResult> studentresultTable;
	
	@PostConstruct
	public void init() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();
		
		StudentResultDAO studentResultDAO = new StudentResultDAO();
		studentresultTable = studentResultDAO.selectALL();
		
		dao = new InterviewDAO();
		table = dao.selectAll();
		interview = new Interview();
		
		interview.setStudent(new Student());
		interview.setStudentResult(new StudentResult());
	}
	
	
	public String save() {
		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectALL();
		
		StudentResultDAO studentResultDAO = new StudentResultDAO();
		studentresultTable = studentResultDAO.selectALL();
		
		dao = new InterviewDAO();
		dao.insert(interview);
		interview = new Interview();
		
		interview = new Interview();
		interview.setStudent(new Student());
		interview.setStudentResult(new StudentResult());
		
		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateInterview() {
		dao.update(interview);
		table = dao.selectAll();
		return null;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public InterviewDAO getDao() {
		return dao;
	}

	public void setDao(InterviewDAO dao) {
		this.dao = dao;
	}

	public List<Interview> getTable() {
		return table;
	}

	public void setTable(List<Interview> table) {
		this.table = table;
	}


	public List<Student> getStudentTable() {
		return studentTable;
	}


	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}


	public List<StudentResult> getStudentresultTable() {
		return studentresultTable;
	}


	public void setStudentresultTable(List<StudentResult> studentresultTable) {
		this.studentresultTable = studentresultTable;
	}

	
	
	
}
