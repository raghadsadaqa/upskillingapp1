package assignment.test;

import java.util.List;

import assignment.bean.StudentTrainingCourse;
import assignment.dao.StudentTraCouDAO;

public class TestStuTraCou {

	public static void main(String[] args) {
		
		StudentTraCouDAO dao = new StudentTraCouDAO();
		
		/*StudentTrainingCourse course = new StudentTrainingCourse(1, 1); 
		int row = dao.delete(course);
		System.out.println(row + "deleted");*/
		
		/*StudentTrainingCourse course = new StudentTrainingCourse(1, 3, 5);
		int row = dao.insert(course);
		System.out.println(row + "inserted");
		
		/*course = new StudentTrainingCourse(1, 1, 1);
		row = dao.update(course);
		System.out.println(row + "updated");*/

		
		List<StudentTrainingCourse> coursesTable = dao.selectALL();
		System.out.println(coursesTable);
		
	}

}
