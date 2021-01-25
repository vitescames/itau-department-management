package br.com.itau.departmentmanagement.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.itau.departmentmanagement.exceptions.BoardNotFoundException;
import br.com.itau.departmentmanagement.model.BoardEntity;
import br.com.itau.departmentmanagement.repository.BoardRepository;
import br.com.itau.departmentmanagement.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository boardRepository;

	@Override
	public BoardEntity getBoardById(Integer id) throws BoardNotFoundException {
		
		Optional<BoardEntity> boardEntity = boardRepository.findById(id);
		
		if(boardEntity.isPresent()) {
			return boardEntity.get();
		} else {
			throw new BoardNotFoundException("Board ID not found");
		}
		
	}

	@Override
	public Page<BoardEntity> getAllBoards(Pageable pagination) {
		return boardRepository.findAll(pagination);
	}

}
