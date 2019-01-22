package cn.innosoft.en.releaseRecord.releaseManager.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.innosoft.en.releaseRecord.releaseManager.model.TJcDetoxInfo;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.en.util.ImageUtil;
import cn.innosoft.en.util.KSUtil;
import cn.innosoft.en.util.PropsUtil;
import cn.innosoft.en.util.Util;

@Service
public class AddSBService {
	
	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;
	
	/**
	 * 人脸底图上传
	 * @param number_id
	 * @throws IOException
	 */
	public void upSBPhoto(String number_id) throws IOException {
		TJcDetoxInfo jcDetoxInfo = jcDetoxInfoService.findOne(number_id);
		String ksuserId = jcDetoxInfo.getKsUserId();
		byte[] photoBytes = jcDetoxInfoService.sanyangPhotoGet(PropsUtil.getValue("prisonId"),number_id);
		String basePath =  PropsUtil.getValue("savePhoto");
		EnUtil.createDir(basePath);// 检验文件夹，无则创建
		String path = Util.getCurTimeUUID()+".jpg";
		EnUtil.createFile(basePath+path);
		ImageUtil.GenerateImage(new String(photoBytes),basePath+path);
		KSUtil.uploadFace(ksuserId, basePath+path);
	}

}
