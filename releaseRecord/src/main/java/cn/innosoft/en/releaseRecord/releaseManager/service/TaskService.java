package cn.innosoft.en.releaseRecord.releaseManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TaskService")
public class TaskService {
	
	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;
	
	@Autowired
	private DataSynchService dataSynchService;
	
	public void timeSynchroData() {
		try {
//			jcDetoxInfoService.moniAdd();
//			Util.deletePathFiles(PropsUtil.getValue("savePhoto"));// 清空文件
			jcDetoxInfoService.synchroPersonData();
//			dataSynchService.synchroPersonData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
