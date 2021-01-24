package br.com.itau.departmentmanagement.form;

public class DepartmentForm {
	
	private Integer id;
	
	private String name;
	
	private String location;
	
	private String city;
	
	private String state;
	
	private Integer directoryEntityId;
	
	public DepartmentForm() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getDirectoryEntityId() {
		return directoryEntityId;
	}

	public void setDirectoryEntityId(Integer directoryEntityId) {
		this.directoryEntityId = directoryEntityId;
	}

}
