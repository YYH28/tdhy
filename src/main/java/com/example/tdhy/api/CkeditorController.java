package com.example.tdhy.api;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.tdhy.po.UploadImageResModel;
import com.example.tdhy.until.TencentCOS;

@RestController
@RequestMapping("/api/ck")
public class CkeditorController {
	@RequestMapping("/uploadimg")
	public UploadImageResModel uploadImg(@RequestParam("upload") MultipartFile multipartFile) {
		String secretId = "AKIDYw60f5uBrSqzykqZbO4ViiSxDDydDMQF";
		String secretKey = "kGXYS8ucDajcHUXyMWSQJ3a3Rfx3984q";
		String bucketName = "tdhy-1300435011";
		UploadImageResModel res = new UploadImageResModel();

		if (multipartFile == null || multipartFile.isEmpty()) {
			res.setUploaded(0);
			return res;
		}

		String fileName = multipartFile.getOriginalFilename();
		// 获取文件后缀
		String prefix = fileName.substring(fileName.lastIndexOf("."));
		File excelFile = null;
		try {
			excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
			multipartFile.transferTo(excelFile);
			fileName = TencentCOS.uploadfile(excelFile, secretId, secretKey, bucketName);
			// 访问路径
			String path = "https://" + bucketName + ".cos.ap-guangzhou.myqcloud.com/" + fileName;
			res.setUploaded(1);
			res.setFileName(fileName);
			res.setUrl(path);
			// 程序结束时，删除临时文件
		} catch (IOException e) {
			// TODO Auto-generated catch block
			res.setUploaded(0);

		}

		return res;

	}

	/**
	 * 删除临时文件
	 * 
	 * @param files
	 */
	private void deleteFile(File... files) {
		for (File file : files) {
			if (file.exists()) {
				file.delete();
			}
		}
	}

}
