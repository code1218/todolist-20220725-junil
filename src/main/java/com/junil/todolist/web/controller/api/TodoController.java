package com.junil.todolist.web.controller.api;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junil.todolist.service.todo.TodoService;
import com.junil.todolist.web.dto.CMRespDto;
import com.junil.todolist.web.dto.todo.CreateTodoReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoService todoService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getTodoList(@RequestParam int page) {
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, page + "page list success to load", null));
	}
	
	@PostMapping("/todo")
	public ResponseEntity<?> addTodo(@RequestBody CreateTodoReqDto createTodoReqDto) {
		try {
			if(!todoService.createTodo(createTodoReqDto)) {
				throw new RuntimeException("DataBase Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "Adding todo failed", createTodoReqDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "success", createTodoReqDto));
	}
}
