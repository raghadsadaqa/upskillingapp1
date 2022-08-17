package assignment.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import assignment.bean.TrainingCourses;
import assignment.dao.TraCouDAO;
import util.Message;

@ManagedBean(name = "mbCourse")
public class MBTrainingCourse {
	
	private TrainingCourses courses;
	private TraCouDAO dao;
	private List<TrainingCourses> table;
	
	@PostConstruct
	public void init() {
		dao = new TraCouDAO();
		table = dao.selectALL();
		courses = new TrainingCourses();
	}
	
	public String save() {
		dao = new TraCouDAO();
		dao.insert(courses);
		courses = new TrainingCourses();
		
		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateCourse() {
		dao.update(courses);
		table = dao.selectALL();
		return null;
	}
	
	public String deleteCourse() {
		dao.delete(courses.getCourseid());
		table = dao.selectALL();
		return null;
	}
	
	public TrainingCourses getCourses() {
		return courses;
	}
	public void setCourses(TrainingCourses courses) {
		this.courses = courses;
	}
	public List<TrainingCourses> getTable() {
		return table;
	}
	public void setTable(List<TrainingCourses> table) {
		this.table = table;
	}
	
	
	
}
