package assignment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import assignment.bean.Interview;
import assignment.bean.Student;
import assignment.bean.StudentResult;
import database.Database;

public class InterviewDAO {
	
	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;
	List<Interview> table;
	
	public List<Interview> selectAll(){
		table = new ArrayList<Interview>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select s.student_id, s.student_ename, s.student_aname, i.accepted_flag, i.interview_date,\r\n" + 
					"i.interview_time, i.interview_place from interview i join student s \r\n" + 
					"on(i.student_id = s.student_id) order by i.student_id;");
		
			rs = ps.executeQuery();

			while (rs.next()) {
				Interview interview = new Interview(rs.getDate("interview_date"), rs.getString("interview_time"), rs.getString("interview_place"));
				
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.selectById(rs.getInt("student_id"));
				interview.setStudent(student);
				
				StudentResultDAO studentResultDAO = new StudentResultDAO();
				StudentResult studentResult = studentResultDAO.selectById(rs.getInt("accepted_flag"));
				interview.setStudentResult(studentResult);
				
				table.add(interview);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		
		return table;
	}
	
	public int insert(Interview interview) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("insert into interview(student_id, student_ename, student_aname, "
					+ "accepted_flag, interview_date, interview_time, interview_place) values(?, ?, ?, ?, ?, ?, ?)");
			
			int counter = 1;
			
			ps.setInt(counter++, interview.getStudent().getStudentid());
			ps.setString(counter++, interview.getStudent().getEname());
			ps.setString(counter++, interview.getStudent().getAname());
			ps.setString(counter++, interview.getStudentResult().getAcceptedFlag());
			Date date = new Date(interview.getInterviewDate().getTime());
			ps.setDate(counter++, date);
			ps.setString(counter++, interview.getInterviewTime());
			ps.setString(counter++, interview.getInterviewPlace());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	
	public int update(Interview interview) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update interview set student_id = ?, student_ename = ?, student_aname = ?, "
					+ "accepted_flag = ?, interview_date = ?, interview_time = ?, interview_place = ? where student_id = ?");
			
			int counter = 1;
			
			ps.setString(counter++, interview.getStudent().getEname());
			ps.setString(counter++, interview.getStudent().getAname());
			ps.setString(counter++, interview.getStudentResult().getAcceptedFlag());
			Date date = new Date(interview.getInterviewDate().getTime());
			ps.setDate(counter++, date);
			ps.setString(counter++, interview.getInterviewTime());
			ps.setString(counter++, interview.getInterviewPlace());
			ps.setInt(counter++, interview.getStudent().getStudentid());
			
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}
	
}
