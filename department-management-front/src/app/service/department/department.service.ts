import { DepartmentDto } from './../../dto/department-dto';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

const SERVICE_ENDPOINT = `${environment.api}/api/departments`;

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  constructor(private http: HttpClient) { }

  saveDepartment(departmentDto: DepartmentDto): Observable<DepartmentDto> {
    return this.http.post<DepartmentDto>(
      SERVICE_ENDPOINT,
      departmentDto,
      { observe: 'body' }
    );
  }

  updateDepartment(departmentDto: DepartmentDto): Observable<HttpResponse<any>> {
    return this.http.put<any>(
      SERVICE_ENDPOINT + "/" + departmentDto.id,
      departmentDto
    );
  }

  getDepartments(): Observable<DepartmentDto[]> {
    return this.http.get<DepartmentDto[]>(
      SERVICE_ENDPOINT,
      { observe: 'body' }
    );
  }
}
