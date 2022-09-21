package application;

import java.util.ArrayList;
import java.util.List;

public class People {
	private String name;
	private String gender;
	private int age;
	private List<PetType> pet;
	 
	public People(String name, String gender, int age, List<PetType> khemPet) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.pet =  khemPet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	 
	 
	public List<PetType> getPet() {
		return pet;
	}
	public void setPet( List<PetType> pet) {
		this.pet = pet;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", gender=" + gender + ", age=" + age + ", pet=" + pet.toString() + "]";
	}
	
	
}
