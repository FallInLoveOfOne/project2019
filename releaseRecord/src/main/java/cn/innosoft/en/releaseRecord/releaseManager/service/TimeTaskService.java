package cn.innosoft.en.releaseRecord.releaseManager.service;

import java.util.TimerTask;

import org.springframework.stereotype.Service;

import cn.innosoft.en.releaseRecord.evidenceManager.service.FcfOutdetoxInfoService;
import cn.innosoft.en.util.SpringContextUtil;

@Service("TimeTaskService")
public class TimeTaskService extends TimerTask{
	
	private static String busi_number;
	
	private FcfOutdetoxInfoService fcfOutdetoxInfoService = null;
	
	public TimeTaskService() {
	}
	
	public TimeTaskService(String number) {
		busi_number = number;
	}
	
	@Override
	public void run() {
		fcfOutdetoxInfoService = SpringContextUtil.getBean("FcfOutdetoxInfoService");
		System.out.println("fcfOutdetoxInfoService是否null："+(null==fcfOutdetoxInfoService));
		fcfOutdetoxInfoService.comeBackOpt(busi_number);
	}

}
