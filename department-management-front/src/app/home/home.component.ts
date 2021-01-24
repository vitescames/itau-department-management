import { DepartmetDto } from './../dto/department-dto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  departments : DepartmetDto[];

  displayedColumns : string[];

  constructor() { }

  ngOnInit() {

    this.departments = [
      {id : 5, name : "teste"},
      {id : 5, name : "teste"},
      {id : 5, name : "teste"}
    ]

    this.displayedColumns = ['code', 'name', 'actions'];
    
  }

}
