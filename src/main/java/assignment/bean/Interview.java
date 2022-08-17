package assignment.bean;

import java.sql.Date;

public class Interview {

	//private int studentid;
	//private String aname;
	//private String ename;
	//private String acceptedFlag;
	private Date interviewDate;
	private String interviewTime;
	private String interviewPlace;
	
	private Student student;
	private StudentResult studentResult;

	public Interview() {

	}
	
	

	public Interview(Date interviewDate, String interviewTime, String interviewPlace) {
		//this.studentid = studentid;
		//this.aname = aname;
		//this.ename = ename;
		//this.acceptedFlag = acceptedFlag;
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.interviewPlace = interviewPlace;
	}


	
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(String interviewTime) {
		this.interviewTime = interviewTime;
	}
	public String getInterviewPlace() {
		return interviewPlace;
	}
	public void setInterviewPlace(String interviewPlace) {
		this.interviewPlace = interviewPlace;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentResult getStudentResult() {
		return studentResult;
	}
	public void setStudentResult(StudentResult studentResult) {
		this.studentResult = studentResult;
	}



	@Override
	public String toString() {
		return "Interview [interviewDate=" + interviewDate + ", interviewTime=" + interviewTime + ", interviewPlace="
				+ interviewPlace + ", student=" + student + ", studentResult=" + studentResult + "]";
	}
	
	
	
	
	
	
}
