package App;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.omg.CORBA.PERSIST_STORE;

import model.Person;

public class PersonTableModel extends AbstractTableModel {

	private List<Person>db;
    private String []colnames ={"ID" ,"Name","Occupation","Age Category","Employment Category","Indian Citizen","UIADI Id"};

	public PersonTableModel(){
		
	}

	public String getColumnName(int column) {
		return colnames[column];
	}



	public void setData(List<Person>db){
		this.db =db;
	}
	public int getColumnCount() {
		return 7;
	}
	public int getRowCount() {
		return db.size();
	}

	public Object getValueAt(int row, int col) {
	 Person person =db.get(row);
	 switch(col){
	 case 0:
		 return person.getId();
	 case 1 :
		 return person.getName();
	 case 2:
		 return person.getOccupation();
	 case 3:
		 return person.getAgeCategory();
	 case 4: 
		 return person.getEmpCat();
	 case 5 :
		 return person.isIndCitizen();
	 case 6:
		 return person.getTaxId();
	  }
	 return null;
	}

}
