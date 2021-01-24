package br.com.itau.departmentmanagement.service;

import br.com.itau.departmentmanagement.exceptions.DirectoryNotFoundException;
import br.com.itau.departmentmanagement.model.DirectoryEntity;

public interface DirectoryService {
	
	public DirectoryEntity getDirectoryById(Integer id) throws DirectoryNotFoundException;

}
