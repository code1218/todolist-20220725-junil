package com.junil.todolist.service.todo;

import java.util.List;

import com.junil.todolist.web.dto.todo.CreateTodoReqDto;

public interface TodoService {
	//추가
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception;
	//수정
	//삭제
	//조회
	public List<?> getTodoList(int page) throws Exception;
}
