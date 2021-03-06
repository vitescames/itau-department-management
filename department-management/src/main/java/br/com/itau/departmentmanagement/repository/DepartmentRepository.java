package br.com.itau.departmentmanagement.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.departmentmanagement.model.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer>{
	
	Optional<DepartmentEntity> findById(Integer departmentId);

	Page<DepartmentEntity> findByBoardEntityName(String boardName, Pageable pagination);

}
