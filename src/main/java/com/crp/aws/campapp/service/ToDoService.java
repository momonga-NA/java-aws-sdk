package com.crp.aws.campapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crp.aws.campapp.controller.ToDoAddRequest;
import com.crp.aws.campapp.domain.ToDo;
import com.crp.aws.campapp.repository.ToDoRepository;

import lombok.RequiredArgsConstructor;

/**
 * Todoサービスクラス
 *
 * @author ytkng
 *
 */
@Service
@RequiredArgsConstructor
public class ToDoService {

	/** repository */
	private final ToDoRepository repository;


	/**
	 * ToDoを全て取得する
	 *
	 * @return 全Todo
	 */
	public List<ToDo> findAll(){
		return repository.findAll();
	}

	/**
	 * ToDoを追加する
	 *
	 * @param todo ToDo
	 */
	public void save(ToDoAddRequest request) {
		repository.save(ToDo.newToDo(request));
	}

	/**
	 * 指定したIdのToDoを削除する
	 *
	 * @param id Id
	 */
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
