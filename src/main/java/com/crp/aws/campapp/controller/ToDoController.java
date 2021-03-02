package com.crp.aws.campapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crp.aws.campapp.domain.ToDo;
import com.crp.aws.campapp.service.ToDoService;

import lombok.RequiredArgsConstructor;

/**
 * TODOを管理するコントローラー
 *
 * @author ytkng
 *
 */
@Controller
@RequiredArgsConstructor
public class ToDoController {

	/** service */
	private final ToDoService service;

	@GetMapping("/")
	public ResponseEntity<ToDoResponse> findAll(){
		List<ToDo> toDos = service.findAll();
		ToDoResponse toDoResponse = ToDoResponse.builder().toDos(toDos).build();
		return new ResponseEntity<ToDoResponse>(toDoResponse, HttpStatus.OK);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/")
	public ResponseEntity<HttpStatus> save(@RequestBody ToDoAddRequest request){
		service.save(request);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);

	}



}
