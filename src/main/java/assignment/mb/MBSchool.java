package assignment.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import assignment.bean.School;
import assignment.dao.SchoolDAO;
import util.Message;

@ManagedBean(name = "mbSchool")
@ViewScoped
public class MBSchool {
	private School school;
	private SchoolDAO dao;
	private List<School> table;
	
	@PostConstruct
	public void init() {
		dao = new SchoolDAO();
		table = dao.selectALL();
		school = new School();
	}
	
	public void cellEditable(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		
		if (newValue != null && !newValue.equals(oldValue)) {
			DataTable t = (DataTable) event.getSource();
			School s =(School) t.getRowData();
			dao.update(s);
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "saved successfully");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	
	public String save() {
		dao = new SchoolDAO();
	    dao.insert(school);
	    school = new School();
	     
	    Message.addMessageByKey("INFO", " ", "msg_save");
		return null;
	}
	
	public String updateSchool() {
		dao.update(school);
		table = dao.selectALL();
		return null;
	}
	
	public String deleteSchool() {
		dao.delete(school.getId());
		table = dao.selectALL();
		return null;
	}
	
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public List<School> getTable() {
		return table;
	}
	public void setTable(List<School> table) {
		this.table = table;
	}
	
	

}
