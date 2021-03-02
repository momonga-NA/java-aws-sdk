package com.crp.aws.campapp.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * Photo追加リクエストエンティティ
 * Viewから送信されたデータより生成する
 *
 * @author ytkng
 *
 */
@Getter
@Setter
public class PhotoAddRequest {

	/** base64エンコーディング */
	private String code;
	/** オブジェクトキー名 */
	private String key;

}
