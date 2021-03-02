package com.crp.aws.campapp.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * Email送信エンティティ
 * Viewから送信されたデータより生成する
 *
 * @author ytkng
 *
 */
@Getter
@Setter
public class EmailSendRequest {

	/** メールアドレス送信先 */
	private String toAddress;
	/** 件名 */
	private String subject;
	/** メッセージ*/
	private String message;
}
