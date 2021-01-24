package br.com.itau.departmentmanagement.controller.dto;

import org.springframework.data.domain.Page;

import br.com.itau.departmentmanagement.model.DepartmentEntity;

public class DepartmentDto {
	
	private int id;
	
	private String name;
	
	private String location;
	
	private String city;
	
	private String state;
	
	private DirectoryDto directoryDto;
	
	public DepartmentDto() {

	}

	public DepartmentDto(DepartmentEntity departmentEntity) {
		this.id = departmentEntity.getId();
		this.name = departmentEntity.getName();
		this.location = departmentEntity.getLocation();
		this.city = departmentEntity.getCity();
		this.state = departmentEntity.getState();
		this.directoryDto = DirectoryDto.converter(departmentEntity.getDirectoryEntity());
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

	public DirectoryDto getDirectoryDto() {
		return directoryDto;
	}

	public void setDirectoryDto(DirectoryDto directoryDto) {
		this.directoryDto = directoryDto;
	}
	
	public static Page<DepartmentDto> converter(Page<DepartmentEntity> departments) {
		return departments.map(DepartmentDto::new);
	}
	
}
