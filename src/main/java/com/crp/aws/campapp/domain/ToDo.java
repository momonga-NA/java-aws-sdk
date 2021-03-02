package com.crp.aws.campapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.crp.aws.campapp.controller.ToDoAddRequest;
import com.crp.aws.campapp.util.CampAppUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * Todoエンティティクラス
 *
 * @author ytkng
 *
 */
@Entity
@Getter
@Setter
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** テーマ */
	private String theme;

	/** メッセージ */
	private String message;

	/** 作成日時 */
	private String datetime;

	public static ToDo newToDo(ToDoAddRequest request) {
		ToDo todo = new ToDo();
		todo.theme = request.getTheme();
		todo.message = request.getMessage();
		todo.datetime = CampAppUtil.nowTimeStamp();
		return todo;
	}
}
