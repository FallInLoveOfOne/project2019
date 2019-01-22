package cn.innosoft.en.releaseRecord.dataInterfaceManage.service;

import cn.innosoft.en.releaseRecord.dataInterfaceManage.model.TFcfInterfaceEntity;
import cn.innosoft.en.releaseRecord.dataInterfaceManage.persistent.TFcfInterfaceEntityDao;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TFcfInterfaceEntityService extends AbstractBaseService<TFcfInterfaceEntity, String> {

    @Autowired
    private TFcfInterfaceEntityDao tFcfInterfaceEntityDao;

    @Override
    public BaseDao<TFcfInterfaceEntity, String> getBaseDao() {
        return tFcfInterfaceEntityDao;
    }

    /**
     * @param tFcfInterfaceEntityMap tFcfInterfaceEntity的Map形式
     * @return 更新记录数
     * 添加数据接口调用信息
     */
    public int addTFcfInterfaceEntity(Map<String, Object> tFcfInterfaceEntityMap) {
        return executeUpdateBySql("tFcfInterfaceEntity-addTFcfInterfaceEntity", tFcfInterfaceEntityMap);
    }

    /**
     * @param paraMap     请求参数
     * @param pageRequest 分页请求
     * @return 分页数据
     * 分页查询数据接口的调用信息
     */
    public PageResponse<Map<String, Object>> pageFindTFcfInterfaceEntity(Map<String, Object> paraMap, PageRequest pageRequest) {
        return findMapBySql("tFcfInterfaceEntity-pageFindTFcfInterfaceEntity", paraMap, pageRequest);
    }

    /**
     * @param paraMap 请求参数（起始时间&截至时间）
     * @return 接口名称&数量
     * 查询各接口调用数量占比
     */
    public List<Map<String, Object>> findInterfaceCallRatioByStartEndTime(Map<String, Object> paraMap) {
        return findMapBySql("tFcfInterfaceEntity-findInterfaceCallRatioByStartEndTime", paraMap);
    }
}
