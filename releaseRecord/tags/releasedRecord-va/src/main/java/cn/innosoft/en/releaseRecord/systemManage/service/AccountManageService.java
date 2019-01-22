package cn.innosoft.en.releaseRecord.systemManage.service;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.en.util.loginUtil.DESUtils;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountManageService {

    @Autowired
    private TFwOrmUserEntityService tFwOrmUserEntityService;

    @Autowired
    private TFwOrmRoleUOMapEntityService tFwOrmRoleUOMapEntityService;

    /**
     * @param pageRequest 分页请求信息
     * @return layui.table分页数据
     * 分页查询用户信息
     */
    public PageResponse<Map<String, Object>> pageFindAccountInfo(PageRequest pageRequest) {
        Map<String, Object> paraMap = EnUtil.jsonToParaMap(pageRequest.getQueryCondition()); // 查询条件
        return tFwOrmUserEntityService.pageFindTFwOrmUserEntity(paraMap, pageRequest);
    }

    /**
     * @param name     姓名
     * @param serial   编号
     * @param account  账号
     * @param password 密码
     * @return result: 状态，message：信息
     * 新增用户
     */
    public Map<String, String> addUserInfo(String name, String serial, String account, String password) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Map<String, String> resultMap = new HashMap<>();
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("userSerial", serial);
        List<Map<String, Object>> mapList = tFwOrmUserEntityService.findTFwOrmUserEntity(paraMap);     //根据人员编号查询人员
        if (mapList == null || mapList.size() == 0) {       //当前插入人员编号不存在
            Map<String, Object> paraMapSql = new HashMap<>();
            String userId = EnUtil.getUUID();
            paraMapSql.put("USER_ID",userId);
            paraMapSql.put("CREATE_DT",EnUtil.getCurTimeUUID());
            paraMapSql.put("CREATE_USER_ID",OrmHelper.getCurrentUserId());
            paraMapSql.put("CREATE_USER_ACCT",OrmHelper.getCurrentUserAcct());
            paraMapSql.put("CREATE_USER_ROLE","");
            paraMapSql.put("UPDATE_DT","");
            paraMapSql.put("UPDATE_USER_ID","");
            paraMapSql.put("UPDATE_USER_ACCT","");
            paraMapSql.put("UPDATE_USER_ROLE","");
            paraMapSql.put("VALID_SIGN","Y");
            paraMapSql.put("USER_ACCT", account);
            paraMapSql.put("USER_ACCT_CN", name);
            paraMapSql.put("USER_ACCT_PWD", DESUtils.encrypt(password));
            paraMapSql.put("USER_ACCT_DESC","");
            paraMapSql.put("USER_ACCT_TYPE","NORMAL");  //用户账号类型代码:：NORMAL普通用户账号、SYSTEM系统用户账号、ADMIN管理员用户账号、ROOT超级管理员账号
            paraMapSql.put("USER_SERIAL", serial);  //用户编号（序列号），自动编号。
            paraMapSql.put("USER_SEX","");
            paraMapSql.put("USER_BIRTH","");
            paraMapSql.put("USER_EMAIL","");
            paraMapSql.put("USER_MOBILE","");
            paraMapSql.put("USER_TEL","");
            paraMapSql.put("USER_HEAD_PIC","");
            paraMapSql.put("O_SERIAL","");
            paraMapSql.put("USER_INITIAL_PWD","");
            paraMapSql.put("USER_FAX","");
            tFwOrmUserEntityService.addTFwOrmUserEntity(paraMapSql);    //人员信息执行插入数据库
            tFwOrmRoleUOMapEntityService.addTFwOrmRoleUOMapEntity(userId,"BIANJIJIAOSE"); //添加用户角色(暂定为”BIANJIJIAOSE“)
            resultMap.put("result", "success");
            resultMap.put("message", "新增成功！");
        } else {
            resultMap.put("result", "error");
            resultMap.put("message", "编号已存在！");
        }
        return resultMap;
    }

    /**
     * @param userId   id主键
     * @param name     姓名
     * @param serial   编号
     * @param account  账号
     * @param password 密码
     * @return result: 状态，message：信息
     * 编辑人员信息
     */
    public Map<String, String> editUserInfo(String userId, String name, String serial, String account, String password) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Map<String, String> resultMap = new HashMap<>();
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("userSerial", serial);
        paraMap.put("notUserId", userId);   //不包含当前编号
        List<Map<String, Object>> mapList = tFwOrmUserEntityService.findTFwOrmUserEntity(paraMap);     //根据人员编号查询人员
        if (mapList == null || mapList.size() == 0) {       //当前插入人员编号不存在
            Map<String, Object> paraMapSql = new HashMap<>();
            paraMapSql.put("USER_ID",userId);
            paraMapSql.put("UPDATE_DT",EnUtil.getCurTimeUUID());
            paraMapSql.put("UPDATE_USER_ID",OrmHelper.getCurrentUserId());
            paraMapSql.put("UPDATE_USER_ACCT",OrmHelper.getCurrentUserAcct());
            paraMapSql.put("UPDATE_USER_ROLE","");
            paraMapSql.put("USER_ACCT", account);
            paraMapSql.put("USER_ACCT_CN", name);
            paraMapSql.put("USER_ACCT_PWD", DESUtils.encrypt(password));
            paraMapSql.put("USER_SERIAL", serial);  //用户编号（序列号），自动编号。
            tFwOrmUserEntityService.updateTFwOrmUserEntity(paraMapSql);    //人员更新数据库
//            List<Map<String,Object>> roleMapList = tFwOrmUserEntityService.findTFwOrmUserEntityAllById(paraMap);   //获取roleid
//            if(roleMapList!=null&&roleMapList.size()>0){
//                String roleUOMapId = roleMapList.get(0).get("ROLE_U_O_MAP_ID").toString();
//                tFwOrmRoleUOMapEntityService.updateTFwOrmRoleUOMapEntity(roleUOMapId,role); //添加用户角色
//            }
            resultMap.put("result", "success");
            resultMap.put("message", "编辑成功！");
        } else {
            resultMap.put("result", "error");
            resultMap.put("message", "编号已存在！");
        }
        return resultMap;
    }

    /**
     * @param userId   用户Id
     * @return  result: 状态，message：信息
     * 删除用户
     */
    public Map<String, String> deleteUserInfo(String userId){
        Map<String, String> resultMap = new HashMap<>();
        if(userId!=null){
            tFwOrmUserEntityService.deleteUserInfo(userId); //删除用户信息（逻辑删除）
            resultMap.put("result", "success");
            resultMap.put("message", "删除成功！");
        }else{
            resultMap.put("result", "error");
            resultMap.put("message", "用户Id不能为空！");
        }
        return resultMap;
    }

    /**
     * @param userId    用户id
     * @return  用户信息
     */
    public Map<String,Object> findAccountInfoByUserId(String userId) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("userId",userId);
        List<Map<String,Object>> mapList = tFwOrmUserEntityService.findTFwOrmUserEntityAllById(paraMap);    //根据人员编号查询人员全部信息(编辑&查看使用)
        if(mapList!=null&&mapList.size()>0){
            resultMap = mapList.get(0);
            resultMap.put("USER_ACCT_PWD",DESUtils.decrypt(EnUtil.changeNull(resultMap.get("USER_ACCT_PWD"))));
        }
        return resultMap;
    }
}

