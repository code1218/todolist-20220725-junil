package com.junil.todolist.service.todo;

import java.util.List;

import com.junil.todolist.web.dto.todo.CreateTodoReqDto;
import com.junil.todolist.web.dto.todo.TodoListRespDto;

public interface TodoService {
	//추가
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception;
	//수정
	//삭제
	//조회
	public List<TodoListRespDto> getTodoList(int page, int contentCount) throws Exception;
	public List<TodoListRespDto> getImportanceTodoList(int page, int contentCount) throws Exception;
	public boolean updateTodoComplete(int todoCode) throws Exception;
	public boolean updateTodoImportance(int todoCode) throws Exception;
	
}
