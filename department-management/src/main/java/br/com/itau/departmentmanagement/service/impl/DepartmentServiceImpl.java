package br.com.itau.departmentmanagement.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.itau.departmentmanagement.exceptions.DepartmentNotFoundException;
import br.com.itau.departmentmanagement.form.DepartmentForm;
import br.com.itau.departmentmanagement.model.DepartmentEntity;
import br.com.itau.departmentmanagement.model.DirectoryEntity;
import br.com.itau.departmentmanagement.repository.DepartmentRepository;
import br.com.itau.departmentmanagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentEntity saveDepartment(DepartmentForm form, DirectoryEntity directoryEntity) {
		DepartmentEntity department = new DepartmentEntity(form.getId(), form.getName(), form.getLocation(), form.getCity(), form.getState(), directoryEntity);
		return departmentRepository.save(department);
	}

	@Override
	public Boolean deleteDepartment(Integer departmentId) throws DepartmentNotFoundException {
		
		DepartmentEntity department = this.getDepartmentById(departmentId);
		
		departmentRepository.deleteById(department.getId());
		
		return true;
		
	}

	@Override
	public DepartmentEntity getDepartmentById(Integer departmentId) throws DepartmentNotFoundException {
		
		Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
		
		if(departmentEntity.isPresent()) {
			return departmentEntity.get();
		} else {
			throw new DepartmentNotFoundException("Department ID not found");
		}
		
	}

	@Override
	public Page<DepartmentEntity> getAllDepartments(Pageable pagination) {
		return departmentRepository.findAll(pagination);
	}

	@Override
	public Page<DepartmentEntity> getDepartmentsByDirectory(String directoryName, Pageable pagination) {
		return departmentRepository.findByDirectoryEntityName(directoryName, pagination);
	}

	@Override
	public DepartmentEntity prepareForEdit(Integer departmentId) throws DepartmentNotFoundException {
		
		DepartmentEntity departmentEntity = this.getDepartmentById(departmentId);
		
		return departmentRepository.getOne(departmentEntity.getId());
	}

	@Override
	public Boolean checkIfDepartmentExists(Integer id) {
		
		Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
		
		if(departmentEntity.isPresent())
			return true;
		else
			return false;
		
	}

}
