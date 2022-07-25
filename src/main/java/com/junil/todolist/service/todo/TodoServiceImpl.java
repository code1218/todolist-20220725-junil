package com.junil.todolist.service.todo;

import org.springframework.stereotype.Service;

import com.junil.todolist.domain.todo.Todo;
import com.junil.todolist.domain.todo.TodoRepository;
import com.junil.todolist.web.dto.todo.CreateTodoReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
	
	private final TodoRepository todoRepository;

	@Override
	public boolean createTodo(CreateTodoReqDto createTodoReqDto) throws Exception {
		Todo todoEntity = createTodoReqDto.toEntity();
		return todoRepository.save(todoEntity) > 0;
	}

}
