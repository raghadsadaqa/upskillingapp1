package assignment.bean;

public class StudentTrainingCourse {

	//private int studentid;
	//private int courseid;
	private int priority;
	
	private Student student;
	private TrainingCourses trainingCourses;
	
	

	public StudentTrainingCourse() {

	}


	public StudentTrainingCourse(int priority) {
		//this.studentid = studentid;
		//this.courseid = courseid;
		this.priority = priority;
	}
	
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	public TrainingCourses getCourses() {
		return trainingCourses;
	}

	public void setCourses(TrainingCourses courses) {
		this.trainingCourses = courses;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "StudentTrainingCourse [priority=" + priority + ", student=" + student + ", trainingCourses="
				+ trainingCourses + "]";
	}
	
	
	
	
}
