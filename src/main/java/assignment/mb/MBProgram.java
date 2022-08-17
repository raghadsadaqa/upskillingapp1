package assignment.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import assignment.bean.Program;
import assignment.dao.ProgramDAO;
import util.Message;

@ManagedBean(name = "mbProgram")
@ViewScoped
public class MBProgram {

	private Program program;
	private ProgramDAO dao;
	private List<Program> table;

	@PostConstruct
	public void init() {
		dao = new ProgramDAO();
		table = dao.selectAll();
		program = new Program();
	}

	public String save() {
		dao = new ProgramDAO();
		dao.insert(program);
		program = new Program();
		
		Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateProgram() {
		dao.update(program);
		table = dao.selectAll();
		return null;
	}
	
	public String deleteProgram() {
		dao.delete(program.getProgramid(), program.getSchoolid());
		table = dao.selectAll();
		return null;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<Program> getTable() {
		return table;
	}

	public void setTable(List<Program> table) {
		this.table = table;
	}

}
