package cn.innosoft.en.releaseRecord.systemManage.resource;

import cn.innosoft.en.releaseRecord.systemManage.service.AccountManageService;
import cn.innosoft.en.util.LayuiTable;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

/**
 * 账号管理
 */
@Controller
@RequestMapping(value = "systemManage/accountManage")
public class AccountManageResource {

    private static final String PATH = "sanyang/iframe/system";

    @Autowired
    private AccountManageService accountManageService;

    /**
     * @return 跳转至账号管理
     */
    @RequestMapping(value = "toAccount")
    public String toAccount() {
        return PATH + "/account";
    }

    /**
     * @return 跳转至账号新增
     */
    @RequestMapping(value = "toAddAccount")
    public String toAddAccount(Model model, String type) {
        model.addAttribute("type",type);
        return "sanyang/add-account";
    }

    /**
     * @return 跳转至账号编辑
     */
    @RequestMapping(value = "toEditAccount")
    public String toEditAccount(Model model,String type,String userId) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        model.addAttribute("type",type);
        model.addAttribute("userData",accountManageService.findAccountInfoByUserId(userId));//根据userid查询用户数据
        return "sanyang/add-account";
    }

    /**
     * @param pageRequest 分页请求信息
     * @return layui.table分页数据
     * 分页查询用户信息
     */
    @ResponseBody
    @RequestMapping(value = "pageFindAccountInfo")
    public LayuiTable pageFindAccountInfo(PageRequest pageRequest) {
        PageResponse<Map<String, Object>> mapPageResponse = accountManageService.pageFindAccountInfo(pageRequest);
        return LayuiTable.data(mapPageResponse);
    }

    /**
     * @param name     姓名
     * @param serial   编号
     * @param account  账号
     * @param password 密码
     * @param role     角色
     * @return result: 状态，message：信息
     * 新增用户
     */
    @ResponseBody
    @RequestMapping(value = "addUserInfo")
    public Map<String, String> addUserInfo(String name, String serial, String account, String password) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return accountManageService.addUserInfo(name, serial, account, password);
    }

    /**
     * @param name     姓名
     * @param serial   编号
     * @param account  账号
     * @param password 密码
     * @param role     角色
     * @return result: 状态，message：信息
     * 编辑用户信息
     */
    @ResponseBody
    @RequestMapping(value = "editUserInfo")
    public Map<String, String> editUserInfo(String userId,String name, String serial, String account, String password) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return accountManageService.editUserInfo(userId,name, serial, account, password);
    }

    /**
     * @param userId    用户id
     * @return  result: 状态，message：信息
     * 删除用户信息（逻辑删除）
     */
    @ResponseBody
    @RequestMapping(value = "deleteUserInfo")
    public  Map<String, String> deleteUserInfo(String userId){
        return accountManageService.deleteUserInfo(userId);
    }
}