package com.crp.aws.campapp.controller;

import java.util.List;

import com.amazonaws.services.s3.model.S3ObjectSummary;

import lombok.Builder;
import lombok.Getter;

/**
 * Viewに返すPhotoレスポンスエンティティ
 *
 * @author ytkng
 *
 */
@Getter
@Builder
public class PhotoResponse {

	/** S3オブジェクトリスト */
	private List<S3ObjectSummary> s3ObjectSummaryList;
}
