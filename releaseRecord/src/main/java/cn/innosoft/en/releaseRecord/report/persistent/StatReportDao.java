package cn.innosoft.en.releaseRecord.report.persistent;

import org.springframework.stereotype.Repository;
import cn.innosoft.en.releaseRecord.report.model.TFcfReport;
import cn.innosoft.fw.biz.core.persistent.BaseDao;

@Repository
public interface StatReportDao extends BaseDao<TFcfReport,String> {

}
