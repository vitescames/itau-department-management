package br.com.itau.departmentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.departmentmanagement.model.DirectoryEntity;

public interface DirectoryRepository extends JpaRepository<DirectoryEntity, Integer>{

}
