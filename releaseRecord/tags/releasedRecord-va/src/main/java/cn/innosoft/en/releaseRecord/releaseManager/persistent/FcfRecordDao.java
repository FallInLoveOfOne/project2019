package cn.innosoft.en.releaseRecord.releaseManager.persistent;

import org.springframework.stereotype.Repository;

import cn.innosoft.en.releaseRecord.releaseManager.model.TFcfRecord;
import cn.innosoft.fw.biz.core.persistent.BaseDao;

@Repository
public interface FcfRecordDao extends BaseDao<TFcfRecord, String>{
	

}
