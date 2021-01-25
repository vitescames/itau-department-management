import { StateService } from './../service/state/state.service';
import { BoardService } from './../service/board/board.service';
import { BoardDto } from './../dto/board-dto';
import { DepartmentService } from './../service/department/department.service';
import { DepartmentDto } from './../dto/department-dto';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  dataSource : MatTableDataSource<DepartmentDto>;

  departments : DepartmentDto[];

  boards : BoardDto[];

  departmentDto : DepartmentDto;

  displayedColumns : string[];

  updateMode : boolean;

  states : string[];

  indexToUpdate : number;

  constructor(private departmentService : DepartmentService, 
    private boardService : BoardService,
    private stateService : StateService) { }

  ngOnInit() {

    this.getAllDepartments();    

    this.getAllBoards();

    this.displayedColumns = ['code', 'name', 'actions'];

    this.departmentDto = new DepartmentDto();

    this.states = this.stateService.getAllStates();
    
  }

  prepareForEdit(departmentDto : DepartmentDto, index : number){
    this.updateMode = true;
    this.indexToUpdate = index;
    this.departmentDto = new DepartmentDto();
    this.departmentDto.id = departmentDto.id;
    this.departmentDto.name = departmentDto.name;
    this.departmentDto.city = departmentDto.city;
    this.departmentDto.location = departmentDto.location;
    this.departmentDto.state = departmentDto.state;
    this.departmentDto.boardDto = departmentDto.boardDto;
  }

  saveDepartment(){

    this.departmentService.saveDepartment(this.departmentDto).subscribe(response =>{
      this.departments.push(response);
      this.dataSource = new MatTableDataSource(this.departments);
      this.departmentDto = new DepartmentDto();
    });

  }

  updateDepartment(){

    this.departmentService.updateDepartment(this.departmentDto).subscribe(response =>{
      this.dataSource.data.splice(this.indexToUpdate, 1, this.departmentDto);
      this.dataSource.data = this.dataSource.data;
      this.departmentDto = new DepartmentDto();
      this.updateMode = false;
    });

  }

  getAllDepartments(){ 

    this.departmentService.getDepartments().subscribe(response =>{
      this.departments = response["content"];
      this.dataSource = new MatTableDataSource(this.departments);
    });

  }

  getAllBoards(){

    this.boardService.getBoards().subscribe(response =>{
      this.boards = response["content"];
    });

  }

}
