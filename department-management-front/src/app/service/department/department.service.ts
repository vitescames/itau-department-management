import { DepartmentDto } from './../../dto/department-dto';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

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
    ).pipe(catchError(this.handleError));
  }

  updateDepartment(departmentDto: DepartmentDto): Observable<HttpResponse<any>> {
    return this.http.put<any>(
      SERVICE_ENDPOINT + "/" + departmentDto.id,
      departmentDto
    ).pipe(catchError(this.handleError));
  }

  getDepartments(): Observable<DepartmentDto[]> {
    return this.http.get<DepartmentDto[]>(
      SERVICE_ENDPOINT,
      { observe: 'body' }
    ).pipe(catchError(this.handleError));
  }

  deleteDepartment(id : number) : Observable<any>{
    return this.http.delete<boolean>(
      SERVICE_ENDPOINT + "/" + id,
      { observe: 'body' }
    ).pipe(catchError(this.handleError));
  }

  handleError(error) {

    let errorMessage = '';
 
    if (error.error instanceof ErrorEvent) {
 
      errorMessage = `Error: ${error.error.message}`;
 
    } else {
 
      errorMessage = `Error Code: ${error.error.status}\nMessage: ${error.error.messages}`;
 
    }
 
    return throwError(errorMessage);
 
  }
}
