package com.crp.aws.campapp.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * ToDo追加リクエストエンティティ
 * Viewから送信されたデータより生成する
 *
 * @author ytkng
 *
 */
@Getter
@Setter
public class ToDoAddRequest {

	/** テーマ */
	private String theme;

	/** メッセージ */
	private String message;
}
