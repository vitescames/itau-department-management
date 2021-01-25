package br.com.itau.departmentmanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class DepartmentEntity {
	
	@Id
	@Column(name="department_id")
	private Integer id;
	
	@Column(name="department_name", nullable=false, length=50)
	private String name;
	
	@Column(name="department_location", nullable=false, length=100)
	private String location;
	
	@Column(name="department_city", nullable=false, length=50)
	private String city;
	
	@Column(name="department_state", nullable=false, length=50)
	private String state;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="board_id")
	private BoardEntity boardEntity;

	public DepartmentEntity() {
		super();
	}

	public DepartmentEntity(Integer departmentId, String departmentName, String departmentLocation,
			String departmentCity, String departmentState, BoardEntity boardEntity) {
		super();
		this.id = departmentId;
		this.name = departmentName;
		this.location = departmentLocation;
		this.city = departmentCity;
		this.state = departmentState;
		this.boardEntity = boardEntity;
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

	public BoardEntity getBoardEntity() {
		return boardEntity;
	}

	public void setBoardEntity(BoardEntity boardEntity) {
		this.boardEntity = boardEntity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentEntity other = (DepartmentEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
