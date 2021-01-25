package br.com.itau.departmentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.departmentmanagement.model.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{

}
