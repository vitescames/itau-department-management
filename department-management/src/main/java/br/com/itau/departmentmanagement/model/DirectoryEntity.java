package br.com.itau.departmentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="directory")
public class DirectoryEntity {
	
	@Id
	@Column(name="directory_id", nullable=false, length=50)
	private Integer id;
	
	@Column(name="directory_name")
	private String name;

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

}
