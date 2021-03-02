package com.crp.aws.campapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crp.aws.campapp.domain.Email;
import com.crp.aws.campapp.service.EmailService;
import com.crp.aws.campapp.util.LoggingService;

import lombok.RequiredArgsConstructor;

/**
 * Email送信用のコントローラー
 *
 * @author ytkng
 *
 */
@Controller
@RequiredArgsConstructor
public class EmailController {

	/** service */
	private final EmailService service;

	@PostMapping("/email")
	public ResponseEntity<HttpStatus> sendEmail(@RequestBody EmailSendRequest request) {
    	LoggingService.info("acccess");
		service.sendEmail(Email.newEmail(request));
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
