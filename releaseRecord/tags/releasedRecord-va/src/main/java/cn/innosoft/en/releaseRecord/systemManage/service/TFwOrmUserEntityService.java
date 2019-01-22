package cn.innosoft.en.releaseRecord.systemManage.service;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.login.client.model.ClientUser;
import cn.innosoft.en.releaseRecord.systemManage.model.TFwOrmUserEntity;
import cn.innosoft.en.releaseRecord.systemManage.persistent.TFwOrmUserEntityDao;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TFwOrmUserEntityService extends AbstractBaseService<TFwOrmUserEntity, String> {

    @Autowired
    private TFwOrmUserEntityDao tFwOrmUserEntityDao;

    @Override
    public BaseDao<TFwOrmUserEntity, String> getBaseDao() {
        return tFwOrmUserEntityDao;
    }

    /**
     * @param clientUser     当前用户信息
     * @param newPasswordMD5 密码MD5加密
     * @return true:成功||false:失败
     * 修改密码
     */
    public boolean updateUserPassword(ClientUser clientUser, String newPasswordMD5) {
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("USER_ID", clientUser.getUserId());
        paraMap.put("UPDATE_DT", EnUtil.getCurTimeUUID());
        paraMap.put("UPDATE_USER_ID", clientUser.getUserId());
        paraMap.put("UPDATE_USER_ACCT", clientUser.getUserAcct());
        paraMap.put("UPDATE_USER_ROLE", OrmHelper.getLoginRole());
        paraMap.put("USER_ACCT_PWD", newPasswordMD5);
        int updateNumber = executeUpdateBySql("tFwOrmUserEntity-updateUserPassword", paraMap);
        return updateNumber > 0 ? true : false;
    }

    /**
     * @param paraMap     请求参数
     * @param pageRequest 分页请求
     * @return 分页数据
     * 分页查询用户信息
     */
    public PageResponse<Map<String, Object>> pageFindTFwOrmUserEntity(Map<String, Object> paraMap, PageRequest pageRequest) {
        return findMapBySql("tFwOrmUserEntity-pageFindTFwOrmUserEntity", paraMap, pageRequest);
    }

    /**
     * @param paraMap 查询参数
     * @return TFwOrmUserEntity结果集
     * 根据人员编号查询人员
     */
    public List<Map<String, Object>> findTFwOrmUserEntity(Map<String, Object> paraMap) {
        return findMapBySql("tFwOrmUserEntity-findTFwOrmUserEntity",paraMap);
    }

    /**
     * @param paraMap 添加参数
     * @return true:成功||false:失败
     * 人员添加
     */
    public boolean addTFwOrmUserEntity(Map<String, Object> paraMap) {
        int addNumber = executeUpdateBySql("tFwOrmUserEntity-addTFwOrmUserEntity", paraMap);
        return addNumber > 0 ? true : false;
    }

    /**
     * @param paraMap 更新参数
     * @return opt
     * 人员更新
     */
    public boolean updateTFwOrmUserEntity(Map<String, Object> paraMap) {
        int updateNumber = executeUpdateBySql("tFwOrmUserEntity-updateTFwOrmUserEntity", paraMap);
        return updateNumber > 0 ? true : false;
    }

    /**
     * @param userId 用户ID
     * @return 删除结果
     * 删除用户（逻辑删除）
     */
    public boolean deleteUserInfo(String userId) {
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("USER_ID", userId);
        paraMap.put("VALID_SIGN", "N");
        int deleteNumber = executeUpdateBySql("tFwOrmUserEntity-deleteUserInfo", paraMap);
        return deleteNumber > 0 ? true : false;
    }

    /**
     * @param paraMap 查询参数
     * @return TFwOrmUserEntity结果集
     * 根据人员编号查询人员全部信息(编辑&查看使用)
     */
    public List<Map<String, Object>> findTFwOrmUserEntityAllById(Map<String, Object> paraMap) {
        return findMapBySql("tFwOrmUserEntity-findTFwOrmUserEntityAllById",paraMap);
    }
}