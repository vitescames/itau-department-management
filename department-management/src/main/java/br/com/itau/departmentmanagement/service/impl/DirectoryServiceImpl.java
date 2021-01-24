package br.com.itau.departmentmanagement.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.departmentmanagement.exceptions.DirectoryNotFoundException;
import br.com.itau.departmentmanagement.model.DirectoryEntity;
import br.com.itau.departmentmanagement.repository.DirectoryRepository;
import br.com.itau.departmentmanagement.service.DirectoryService;

@Service
public class DirectoryServiceImpl implements DirectoryService{
	
	@Autowired
	private DirectoryRepository directoryRepository;

	@Override
	public DirectoryEntity getDirectoryById(Integer id) throws DirectoryNotFoundException {
		
		Optional<DirectoryEntity> directoryEntity = directoryRepository.findById(id);
		
		if(directoryEntity.isPresent()) {
			return directoryEntity.get();
		} else {
			throw new DirectoryNotFoundException("Directory ID not found");
		}
		
	}

}
