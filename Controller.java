package controll;

import java.io.File;
import java.io.IOException;
import java.util.List;

import App.FormEvent;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;

public class Controller {

	Database db = new Database();
	public List<Person> getPeople(){
		return db.getPeople();
		
	}
	public void removeperson(int index) {
		db.removeperson(index);
	}
	public void addPerson(FormEvent ev){
		String name =ev.getName();
		String occupation =ev.getOccupation();
		 int ageCatId =ev.getAgeCategory();
		 String empCat =ev.getEmployeeCategory();
		 boolean isInd =ev.isIndCitizen();
		 String taxId =ev.getTaxId();
		 String gender =ev.getGender();
		 
		 AgeCategory ageCategory = null;
		 switch(ageCatId){
		 case 0:
			 ageCategory =AgeCategory.child;
			 break;
		 case 1:
			 ageCategory =AgeCategory.adult;
			 break;
		 case 2:
			 ageCategory =AgeCategory.senior;
			 break;
			 
			 
		 }
		 EmploymentCategory employmentCategory;
		 if(empCat.equals("Employed")){
			 employmentCategory =EmploymentCategory.employed;
		 }
		 else  if(empCat.equals("Self-Employed")){
			 employmentCategory =EmploymentCategory.selfemployed;
		 }
		 else if(empCat.equals("Un-Employed")){
			 employmentCategory =EmploymentCategory.unemployed;
		 }
		 else {
			 employmentCategory =EmploymentCategory.other;
			 System.err.println(empCat);
		 }
		
		 Gender genderCat ;
		  if(gender.equals("male")){
			  genderCat =Gender.male;
		  }
		  else{
			  genderCat =Gender.female;
		  }
		
		  Person person = new Person(name,occupation, ageCategory,employmentCategory,taxId,isInd,genderCat);
		  db.addPerson(person);
	}
	public void saveToFile(File file) throws IOException{
		db.saveToFile(file);
	}
	public void loadFromFile(File file) throws IOException{
		db.loadFromFile(file);
	}
	
}



























