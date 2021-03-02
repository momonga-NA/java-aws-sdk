package com.crp.aws.campapp.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 共通のロギングクラス
 *
 * @author ytkng
 *
 */
public class LoggingService {

// 引数に自クラスを設定する
private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

  // システムに沿うようにラップする
  public static void trace(String msg) {
    logger.trace(msg);
  }
  public static void debug(String msg) {
    logger.debug(msg);
  }
  public static void info(String msg) {
    logger.info(msg);
  }
  public static void warn(String msg) {
    logger.warn(msg);
  }
  public static void error(String msg) {
    logger.error(msg);
  }
}