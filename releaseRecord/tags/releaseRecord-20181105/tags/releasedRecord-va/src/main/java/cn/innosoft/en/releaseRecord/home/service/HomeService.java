package cn.innosoft.en.releaseRecord.home.service;

import java.util.HashMap;
import java.util.Map;

import cn.innosoft.en.common.OrmHelper;


public class HomeService {

	public Map<String, Object> getUserAndDepInfo() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", "200");
		resultMap.put("acct", OrmHelper.getCurrentUserAcct());
		resultMap.put("name", OrmHelper.getCurrentUserName());
		resultMap.put("role", OrmHelper.getLoginRole());
		return resultMap;
	}

}
