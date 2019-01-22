package utils.entity;

import java.io.Serializable;
import java.util.Map;

public class People implements Serializable{

	private static final long serialVersionUID = 1L;

	String id;

	String name;

	int year;

	String addres;
	
	Map<String, Object> forv;

	public Map<String, Object> getForv() {
		return forv;
	}

	public void setForv(Map<String, Object> forv) {
		this.forv = forv;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}
	
	public People(String name){
		this.name=name;
	}

}
