package cn.innosoft.en.releaseRecord.releaseManager.persistent;

import org.springframework.stereotype.Repository;

import cn.innosoft.en.releaseRecord.releaseManager.model.TSysAcc;
import cn.innosoft.fw.biz.core.persistent.BaseDao;

@Repository
public interface SysAccDao extends BaseDao<TSysAcc, String>{

}
