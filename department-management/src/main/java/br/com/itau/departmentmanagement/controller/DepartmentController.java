package br.com.itau.departmentmanagement.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.itau.departmentmanagement.controller.dto.DepartmentDto;
import br.com.itau.departmentmanagement.exceptions.DepartmentNotFoundException;
import br.com.itau.departmentmanagement.exceptions.BoardNotFoundException;
import br.com.itau.departmentmanagement.model.DepartmentEntity;
import br.com.itau.departmentmanagement.model.BoardEntity;
import br.com.itau.departmentmanagement.response.ResponseMessage;
import br.com.itau.departmentmanagement.service.DepartmentService;
import br.com.itau.departmentmanagement.service.BoardService;


@RestController
@RequestMapping("/departments")
public class DepartmentController {	
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public Page<DepartmentDto> listDepartments(@RequestParam(required = false) String boardName,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {
		
		Page<DepartmentEntity> departments = null;
		
		if(boardName == null) {
			departments = departmentService.getAllDepartments(pagination);
		} else {
			departments = departmentService.getDepartmentsByBoard(boardName, pagination);
		}
		
		return DepartmentDto.converter(departments);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartment(@PathVariable Integer id) {
		
		try {
			
			DepartmentEntity department = departmentService.getDepartmentById(id);
			
			return ResponseEntity.ok(new DepartmentDto(department));

		
		} catch (DepartmentNotFoundException e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body(new ResponseMessage(HttpStatus.NOT_FOUND.toString(), "Department ID doesn't exist"));
			
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ResponseMessage> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto form) {
		
		try {
		
			DepartmentEntity department = departmentService.prepareForEdit(id);
			department.setCity(form.getCity());
			department.setBoardEntity(boardService.getBoardById(form.getBoardDto().getId()));
			department.setLocation(form.getLocation());
			department.setName(form.getName());
			department.setState(form.getState());
			
			return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK.toString(), "Department update was done successfully"));
			
					
		} catch (DepartmentNotFoundException e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body(new ResponseMessage(HttpStatus.NOT_FOUND.toString(), "Department ID doesn't exist"));
			
		} catch (BoardNotFoundException e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body(new ResponseMessage(HttpStatus.NOT_FOUND.toString(), "Board ID doesn't exist"));
			
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDto form, UriComponentsBuilder uriBuilder) {
		
		try {
		
			BoardEntity boardEntity = boardService.getBoardById(form.getBoardDto().getId());
			
			Boolean existingDepartment = departmentService.checkIfDepartmentExists(form.getId());
			
			if(existingDepartment) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).
						body(new ResponseMessage(HttpStatus.BAD_REQUEST.toString(), "Department already exists"));
			}
			
			DepartmentEntity department = departmentService.saveDepartment(form, boardEntity);
			
			URI uri = uriBuilder.path("/departments/{id}").buildAndExpand(department.getId()).toUri();
			return ResponseEntity.created(uri).body(new DepartmentDto(department));
		
		}  catch (BoardNotFoundException e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body(new ResponseMessage(HttpStatus.NOT_FOUND.toString(), "Board ID doesn't exist"));
			
		}
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ResponseMessage> deleteDepartment(@PathVariable Integer id) {
		
		try {
		
			departmentService.deleteDepartment(id);
			
			return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK.toString(), "Department deletion was done successfully"));
		
		} catch (DepartmentNotFoundException e) {
			
			e.printStackTrace();
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body(new ResponseMessage(HttpStatus.NOT_FOUND.toString(), "Department ID doesn't exist"));
		
		}
	}

}
