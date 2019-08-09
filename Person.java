package model;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 3307595005619440428L;
	private static int count=0;
	private int id;
	private String name;
	private String occupation;
	private AgeCategory ageCategory;
	private EmploymentCategory empCat;
	private String taxId;
	private boolean IndCitizen;
	private Gender gender;

	public Person(String name ,String occupation ,AgeCategory ageCategory ,EmploymentCategory empCat
			      , String taxId, boolean IndCitizen ,Gender gender){
		this.name =name;
		this.occupation =occupation;
		this.ageCategory =ageCategory;
		this.empCat =empCat;
		this.taxId =taxId;
		this.IndCitizen =IndCitizen;
		this.gender =gender;
		this.id=count;
		count++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}

	public EmploymentCategory getEmpCat() {
		return empCat;
	}

	public void setEmpCat(EmploymentCategory empCat) {
		this.empCat = empCat;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public boolean isIndCitizen() {
		return IndCitizen;
	}

	public void setIndCitizen(boolean indCitizen) {
		IndCitizen = indCitizen;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
