package cn.innosoft.en.releaseRecord.systemManage.service;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.releaseRecord.systemManage.model.TFwOrmRoleUOMapEntity;
import cn.innosoft.en.releaseRecord.systemManage.persistent.TFwOrmRoleUOMapEntityDao;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TFwOrmRoleUOMapEntityService extends AbstractBaseService<TFwOrmRoleUOMapEntity, String> {
    @Autowired
    private TFwOrmRoleUOMapEntityDao tFwOrmRoleUOMapEntityDao;

    @Override
    public BaseDao<TFwOrmRoleUOMapEntity, String> getBaseDao() {
        return tFwOrmRoleUOMapEntityDao;
    }

    /**
     * @param userId     用户Id
     * @param roleSerial    角色名称
     * @return true:成功||false:失败
     * 添加用户角色
     */
    public boolean addTFwOrmRoleUOMapEntity(String userId, String roleSerial) {
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("ROLE_U_O_MAP_ID",EnUtil.getUUID());
        paraMap.put("O_ID","");
        paraMap.put("ROLE_SERIAL",roleSerial);
        paraMap.put("USER_ID",userId);
        paraMap.put("USER_DISPLAY_ORDER","");
        paraMap.put("ROLE_U_O_MAP_TYPE","USER_TO_ROLE");
        paraMap.put("CREATE_DT",EnUtil.getCurTimeUUID());
        paraMap.put("CREATE_USER_ID",OrmHelper.getCurrentUserId());
        paraMap.put("CREATE_USER_ACCT",OrmHelper.getCurrentUserAcct());
        paraMap.put("CREATE_USER_ROLE",OrmHelper.getLoginRole());
        paraMap.put("UPDATE_DT","");
        paraMap.put("UPDATE_USER_ID","");
        paraMap.put("UPDATE_USER_ACCT","");
        paraMap.put("UPDATE_USER_ROLE","");
        int addNumber = executeUpdateBySql("tFwOrmRoleUOMapEntity-addTFwOrmRoleUOMapEntity",paraMap);
        return addNumber>0?true:false;
    }

    /**
     * @param roleUOMapId     权限关联Id
     * @param roleSerial    角色名称
     * @return true:成功||false:失败
     * 修改用户角色
     */
    public boolean updateTFwOrmRoleUOMapEntity(String roleUOMapId, String roleSerial) {
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("ROLE_SERIAL",roleSerial);
        paraMap.put("ROLE_U_O_MAP_ID",roleUOMapId);
        paraMap.put("UPDATE_DT",EnUtil.getCurTimeUUID());
        paraMap.put("UPDATE_USER_ID",OrmHelper.getCurrentUserId());
        paraMap.put("UPDATE_USER_ACCT",OrmHelper.getCurrentUserAcct());
        paraMap.put("UPDATE_USER_ROLE",OrmHelper.getLoginRole());
        int addNumber = executeUpdateBySql("tFwOrmRoleUOMapEntity-updateTFwOrmRoleUOMapEntity",paraMap);
        return addNumber>0?true:false;
    }

}
