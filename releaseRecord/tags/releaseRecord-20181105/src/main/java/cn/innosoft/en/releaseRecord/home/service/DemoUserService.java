package cn.innosoft.en.releaseRecord.home.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.innosoft.en.releaseRecord.home.model.DemoUser;
import cn.innosoft.en.releaseRecord.home.persistent.DemoUserDao;
import cn.innosoft.en.util.Util;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;

@Service
public class DemoUserService extends AbstractBaseService<DemoUser, String> {

	@Autowired
	private DemoUserDao dao;

	@Override
	public BaseDao<DemoUser, String> getBaseDao() {
		return dao;
	}

	public Map<String, Object> getOneByTemplet(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", id);
		return findMapBySql("demo_user-selectByID", params).get(0);
	}
	
	public void addOneUser(DemoUser userObj) {
		userObj.setId(Util.getUUID());
//		System.out.println(1/0);
		add(userObj);
	}

}
