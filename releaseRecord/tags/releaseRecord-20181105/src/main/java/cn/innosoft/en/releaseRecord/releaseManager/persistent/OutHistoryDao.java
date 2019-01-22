package cn.innosoft.en.releaseRecord.releaseManager.persistent;

import org.springframework.stereotype.Repository;

import cn.innosoft.en.releaseRecord.releaseManager.model.TOutHistory;
import cn.innosoft.fw.biz.core.persistent.BaseDao;

@Repository
public interface OutHistoryDao extends BaseDao<TOutHistory, String>{

}
