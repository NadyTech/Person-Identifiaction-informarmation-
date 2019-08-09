package App;

import java.util.EventObject;

public class FormEvent extends EventObject {

	private String name;
	private String occupation;
	private int ageCategory;
	private String empCat;
	//private String phoneno;
	private String taxId;
	private boolean IndCitizen;
	private String gender;
	public FormEvent(Object source) {
		super(source);
		
	}
	public FormEvent(Object source,String name ,String occupation,int ageCat,String empCat,String taxId ,boolean IndCitizen , String gender) {
		super(source);
		this.name = name;
		this.occupation =occupation;
		this.ageCategory = ageCat;
		this.empCat =empCat;
		//this.phoneno=phoneno;
		this.taxId =taxId;
		this.IndCitizen =IndCitizen;
		this.gender =gender;
	}

	
	
	
	public String getGender() {
		return gender;
	}
	public String getTaxId() {
		return taxId;
	}
	public boolean isIndCitizen() {
		return IndCitizen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int  getAgeCategory(){
		return ageCategory;
	}
	public String getEmployeeCategory() {

		return empCat;
	}
	
}