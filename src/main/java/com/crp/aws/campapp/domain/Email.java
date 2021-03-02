package com.crp.aws.campapp.domain;

import com.crp.aws.campapp.controller.EmailSendRequest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Emailエンティティクラス
 *
 * @author ytkng
 *
 */
@Getter
@Setter
@RequiredArgsConstructor
public class Email {

	/** メールアドレス送信先 */
	private String toAddress;
	/** 件名 */
	private String subject;
	/** メッセージ*/
	private String message;

	/**
	 * クライアントリクエストからエンティティを生成する
	 *
	 * @param request クライアントリクエスト
	 * @return Emailエンティティ
	 */
	public static Email newEmail(EmailSendRequest request) {
		Email email = new Email();
		email.toAddress = request.getToAddress();
		email.subject = request.getSubject();
		email.message = request.getMessage();
		return email;
	}

	/**
	 * messageをHTML形式に変換する
	 * @return HTML形式のmessage
	 */
	public String convertHtmlMessage() {
		return "<p>" + message + "</p>";
	}

}
