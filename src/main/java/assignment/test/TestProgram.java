package assignment.test;

import java.util.ArrayList;
import java.util.List;

import assignment.bean.Program;
import assignment.dao.ProgramDAO;

public class TestProgram {

	public static void main(String[] args) {
		
		ProgramDAO dao = new ProgramDAO();
		
		Program program = new Program(2, 2);
		int row = dao.delete(2, 2);
		System.out.println(row + "deleted");
		
		program = new Program(2, 2, "كامل", "Full time");
		row = dao.insert(program);
		System.out.println(row + "inserted");
		
		program = new Program(2, 2, "الدوام الكامل", "Full time");
		row = dao.update(program);
		System.out.println(row + "updated");

		List<Program> proTable = dao.selectAll();
		System.out.println(proTable);
		
		
	}

}
