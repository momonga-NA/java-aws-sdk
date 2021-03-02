package com.crp.aws.campapp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ユーティリティクラス
 *
 * @author ytkng
 *
 */
public class CampAppUtil {

	/** プライベートコンストラクタ */
	private CampAppUtil() {

	}

	/**
	 * 現在の時間を取得する
	 *
	 * @return 現在の時間
	 */
	public static String nowTimeStamp() {
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date);
	}

}
