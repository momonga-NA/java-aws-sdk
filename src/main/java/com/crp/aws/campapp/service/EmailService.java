package com.crp.aws.campapp.service;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.crp.aws.campapp.domain.Email;
import com.crp.aws.campapp.util.LoggingService;

/**
 * Email送信処理のサービスクラス
 *
 *
 * @author ytkng
 *
 */
@Service
public class EmailService {

	// 送信者アドレス(SESコンソールで認証したメールアドレス)
	static final String FROM = "XXXXXX";

	/**
	 * メールを送信する
	 *
	 * @param email Eメール
	 * @return 成功した場合はメッセージID、失敗した場合はnull
	 */
	public String sendEmail(Email email) {
		try {
			// クライアントの設定
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
		            .withRegion(Regions.AP_NORTHEAST_1).build();
			// リクエストの作成
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(new Destination().withToAddresses(email.getToAddress()))
					.withMessage(new Message()
					.withBody(new Body()
					.withHtml(new Content()
					.withCharset("UTF-8").withData(email.convertHtmlMessage()))
		            .withText(new Content()
		            .withCharset("UTF-8").withData(email.getMessage())))
		            .withSubject(new Content()
		            .withCharset("UTF-8").withData(email.getSubject())))
					.withSource(FROM);
			SendEmailResult result = client.sendEmail(request);
			return result.getMessageId();
		    } catch (Exception ex) {
		    	LoggingService.error(ex.getMessage());
		    	return null;
		    }
		}
}
