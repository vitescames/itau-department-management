package br.com.itau.departmentmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.itau.departmentmanagement.exceptions.BoardNotFoundException;
import br.com.itau.departmentmanagement.model.BoardEntity;

public interface BoardService {
	
	public BoardEntity getBoardById(Integer id) throws BoardNotFoundException;
	
	public Page<BoardEntity> getAllBoards(Pageable pagination);

}
