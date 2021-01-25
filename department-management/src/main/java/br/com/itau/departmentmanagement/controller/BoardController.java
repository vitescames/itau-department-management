package br.com.itau.departmentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.departmentmanagement.controller.dto.BoardDto;
import br.com.itau.departmentmanagement.model.BoardEntity;
import br.com.itau.departmentmanagement.service.BoardService;

@RestController
@RequestMapping("/boards")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public Page<BoardDto> listBoards(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		
		Page<BoardEntity> boards = null;
		
		boards = boardService.getAllBoards(pagination);
		
		return BoardDto.converter(boards);
		
	}

}
