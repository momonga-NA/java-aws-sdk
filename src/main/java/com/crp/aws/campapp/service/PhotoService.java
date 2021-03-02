package com.crp.aws.campapp.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.crp.aws.campapp.util.LoggingService;

/**
 * Photoサービスクラス
 * S3からの画像処理を制御する
 *
 * @author ytkng
 *
 */
@Service
public class PhotoService {

	/** バケット名(今回は固定) */
	private static String BUCKET_NAME = "XXXXXXX";

	/**
	 * Amazon S3にファイルを取得する
	 * @return 画像オブジェクト
	 */
	public List<S3ObjectSummary> getS3ObjectList() {

		System.out.format("Objects in S3 bucket %s:\n", BUCKET_NAME);
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1).build();
		ListObjectsV2Result result = s3.listObjectsV2(BUCKET_NAME);
		List<S3ObjectSummary> objects = result.getObjectSummaries();
		for (S3ObjectSummary os : objects) {
		    LoggingService.info(os.toString());
		}
		return objects;
	}

	/**
	 * Amazon S3にファイルアップロードする
	 * @param base64 アップロードするファイル（Base64）
	 * @param keyName キー名
	 * @throws IOException
	 */
	public void putObjectBase64(String base64, String keyName) {
	    if(base64 == null || keyName == null) {
	    	LoggingService.warn("object data is null");
	    }
	    // S3クライアントの生成
	    AmazonS3 s3Client = AmazonS3ClientBuilder
	            .standard()
	            .withRegion(Regions.AP_NORTHEAST_1)
	            .build();

	    String[] targetCode = base64.split(",");
	    byte[] buf = Base64.getDecoder().decode(targetCode[1]);
	    try (InputStream input = new ByteArrayInputStream(buf)) {
	        // メタ情報を生成
	        ObjectMetadata metaData = new ObjectMetadata();
	        metaData.setContentLength(buf.length);
	        metaData.setContentType(ContentType.IMAGE_JPEG.getMimeType());

	        // リクエストを生成
	        PutObjectRequest request = new PutObjectRequest(
	        	BUCKET_NAME, // アップロード先バケット名
	        	keyName, // アップロード先のパス（キー名）
	            input, // InputStream
	            metaData // メタ情報
	        );
	        // アップロード
	        s3Client.putObject(request);
	    }catch (IOException e) {
	    	LoggingService.error(e.getMessage());
		}
	}
}
