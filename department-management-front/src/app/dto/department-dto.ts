import { BoardDto } from './board-dto';

export class DepartmentDto {

    public id ?: number;
	
	public name ?: string;
	
	public location ?: string;
	
	public city ?: string;
	
	public state ?: string;
	
    public boardDto ?: BoardDto = new BoardDto();
    
}