package br.com.itau.departmentmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.itau.departmentmanagement.controller.dto.DepartmentDto;
import br.com.itau.departmentmanagement.exceptions.DepartmentNotFoundException;
import br.com.itau.departmentmanagement.model.DepartmentEntity;
import br.com.itau.departmentmanagement.model.BoardEntity;

public interface DepartmentService {
	
	public DepartmentEntity saveDepartment(DepartmentDto form, BoardEntity boardEntity);
	
	public Boolean deleteDepartment(Integer departmentId) throws DepartmentNotFoundException;
	
	public DepartmentEntity getDepartmentById(Integer departmentId) throws DepartmentNotFoundException;
	
	public Page<DepartmentEntity> getAllDepartments(Pageable pagination);
	
	public DepartmentEntity prepareForEdit(Integer departmentId) throws DepartmentNotFoundException;

	public Boolean checkIfDepartmentExists(Integer id);

	public Page<DepartmentEntity> getDepartmentsByBoard(String boardName, Pageable pagination);
}
