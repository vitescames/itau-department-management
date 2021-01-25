import { BoardDto } from './../../dto/board-dto';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

const SERVICE_ENDPOINT = `${environment.api}/api/boards`;

@Injectable({
  providedIn: 'root'
})
export class BoardService {

  constructor(private http: HttpClient) { }

  getBoards(): Observable<BoardDto[]> {
    return this.http.get<BoardDto[]>(
      SERVICE_ENDPOINT,
      { observe: 'body' }
    );
  }
}
