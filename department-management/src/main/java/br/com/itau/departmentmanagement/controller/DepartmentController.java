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
import br.com.itau.departmentmanagement.exceptions.DepartmentAlreadyExistingException;
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
	public ResponseEntity<?> getDepartment(@PathVariable Integer id) throws DepartmentNotFoundException{
			
		DepartmentEntity department = departmentService.getDepartmentById(id);
		
		return ResponseEntity.ok(new DepartmentDto(department));
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ResponseMessage> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto form) throws DepartmentNotFoundException, BoardNotFoundException{
		
		DepartmentEntity department = departmentService.prepareForEdit(id);
		department.setCity(form.getCity());
		department.setBoardEntity(boardService.getBoardById(form.getBoardDto().getId()));
		department.setLocation(form.getLocation());
		department.setName(form.getName());
		department.setState(form.getState());
		
		return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK.toString(), "Department update was done successfully"));
					
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDto form, UriComponentsBuilder uriBuilder) throws BoardNotFoundException, DepartmentAlreadyExistingException{
		
		BoardEntity boardEntity = boardService.getBoardById(form.getBoardDto().getId());
		
		departmentService.checkIfDepartmentExists(form.getId());
		
		DepartmentEntity department = departmentService.saveDepartment(form, boardEntity);
		
		URI uri = uriBuilder.path("/departments/{id}").buildAndExpand(department.getId()).toUri();
		return ResponseEntity.created(uri).body(new DepartmentDto(department));
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ResponseMessage> deleteDepartment(@PathVariable Integer id) throws DepartmentNotFoundException{
		
		departmentService.deleteDepartment(id);
		
		return ResponseEntity.ok(new ResponseMessage(HttpStatus.OK.toString(), "Department deletion was done successfully"));
		
	}

}
