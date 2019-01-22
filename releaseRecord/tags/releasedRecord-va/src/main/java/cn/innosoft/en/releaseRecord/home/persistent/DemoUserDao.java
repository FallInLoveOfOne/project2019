package cn.innosoft.en.releaseRecord.home.persistent;

import org.springframework.stereotype.Repository;

import cn.innosoft.en.releaseRecord.home.model.DemoUser;
import cn.innosoft.fw.biz.core.persistent.BaseDao;

@Repository
public interface DemoUserDao extends BaseDao<DemoUser, String> {

}
