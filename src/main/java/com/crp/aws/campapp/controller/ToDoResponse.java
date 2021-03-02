package com.crp.aws.campapp.controller;

import java.util.List;

import com.crp.aws.campapp.domain.ToDo;

import lombok.Builder;
import lombok.Getter;

/**
 * Viewに返すTODOレスポンスエンティティ
 *
 * @author ytkng
 *
 */
@Getter
@Builder
public class ToDoResponse {

	/** ToDoリスト */
	private List<ToDo> toDos;

}
