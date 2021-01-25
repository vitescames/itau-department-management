package br.com.itau.departmentmanagement.controller.dto;

import org.springframework.data.domain.Page;

import br.com.itau.departmentmanagement.model.BoardEntity;

public class BoardDto {
	
	private int id;
	
	private String name;
	
	public BoardDto() {

	}

	public BoardDto(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public BoardDto(BoardEntity boardEntity) {
		this.id = boardEntity.getId();
		this.name = boardEntity.getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static BoardDto converter(BoardEntity boardEntity) {
		return new BoardDto(boardEntity.getId(), boardEntity.getName());
	}
	
	public static Page<BoardDto> converter(Page<BoardEntity> boards) {
		return boards.map(BoardDto::new);
	}

}
