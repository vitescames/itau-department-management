package br.com.itau.departmentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="board")
public class BoardEntity {
	
	@Id
	@Column(name="board_id")
	private Integer id;
	
	@Column(name="board_name", nullable=false, length=50)
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
