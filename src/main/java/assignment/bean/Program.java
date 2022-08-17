package assignment.bean;

public class Program {

	private int schoolid;
	private int programid;
	private String aname;
	private String ename;
	
	private School school;
	
	public Program() {

	}
	
	public Program(int schoolid, int programid, String aname, String ename) {
		this.schoolid = schoolid;
		this.programid = programid;
		this.aname = aname;
		this.ename = ename;
	}



	public Program(int schoolid, int programid) {
		this.schoolid = schoolid;
		this.programid = programid;
	}



	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public int getProgramid() {
		return programid;
	}
	public void setProgramid(int programid) {
		this.programid = programid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Program [schoolid=" + schoolid + ", programid=" + programid + ", aname=" + aname + ", ename=" + ename
				+ "] \n";
	}
	
	
	
}
