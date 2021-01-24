package br.com.itau.departmentmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.itau.departmentmanagement.exceptions.DepartmentNotFoundException;
import br.com.itau.departmentmanagement.form.DepartmentForm;
import br.com.itau.departmentmanagement.model.DepartmentEntity;
import br.com.itau.departmentmanagement.model.DirectoryEntity;

public interface DepartmentService {
	
	public DepartmentEntity saveDepartment(DepartmentForm form, DirectoryEntity directoryEntity);
	
	public Boolean deleteDepartment(Integer departmentId) throws DepartmentNotFoundException;
	
	public DepartmentEntity getDepartmentById(Integer departmentId) throws DepartmentNotFoundException;
	
	public Page<DepartmentEntity> getAllDepartments(Pageable pagination);
	
	public Page<DepartmentEntity> getDepartmentsByDirectory(String directoryName, Pageable pagination);
	
	public DepartmentEntity prepareForEdit(Integer departmentId) throws DepartmentNotFoundException;

	public Boolean checkIfDepartmentExists(Integer id);
}
