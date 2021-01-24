package br.com.itau.departmentmanagement.controller.dto;

import br.com.itau.departmentmanagement.model.DirectoryEntity;

public class DirectoryDto {
	
	private int id;
	
	private String name;
	
	public DirectoryDto() {

	}

	public DirectoryDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public static DirectoryDto converter(DirectoryEntity directoryEntity) {
		return new DirectoryDto(directoryEntity.getId(), directoryEntity.getName());
	}

}
