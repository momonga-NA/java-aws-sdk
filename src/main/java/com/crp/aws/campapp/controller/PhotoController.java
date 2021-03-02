package com.crp.aws.campapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.crp.aws.campapp.service.PhotoService;

import lombok.RequiredArgsConstructor;

/**
 * 画像処理のコントローラー
 *
 * @author ytkng
 *
 */
@Controller
@RequiredArgsConstructor
public class PhotoController {

	/** service */
	private final PhotoService service;

	@GetMapping("/photo")
	public ResponseEntity<PhotoResponse> getObjectList(){
		List<S3ObjectSummary> s3ObjectSummaryList = service.getS3ObjectList();
		PhotoResponse photoResponse = PhotoResponse.builder().s3ObjectSummaryList(s3ObjectSummaryList).build();
		return new ResponseEntity<PhotoResponse>(photoResponse, HttpStatus.OK);
	}

	@PostMapping("/photo")
	public ResponseEntity<HttpStatus> uploadPhoto(@RequestBody PhotoAddRequest request){
		service.putObjectBase64(request.getCode(), request.getKey());
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

}
