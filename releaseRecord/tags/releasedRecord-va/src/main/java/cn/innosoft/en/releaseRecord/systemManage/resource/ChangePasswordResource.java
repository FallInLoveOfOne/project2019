package cn.innosoft.en.releaseRecord.systemManage.resource;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.login.client.model.ClientUser;
import cn.innosoft.en.releaseRecord.systemManage.service.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * 修改密码
 */
@Controller
@RequestMapping(value = "systemManage/changePassword")
public class ChangePasswordResource {

    private static final String PATH = "sanyang/iframe/system";

    @Autowired
    private ChangePasswordService changePasswordService;

    /**
     * @return 跳转至修改密码
     */
    @RequestMapping(value = "toPassword")
    public String toPassword() {
        return PATH + "/password";
    }

    /**
     * @param oldPassword       原始密码
     * @param newPassword       新密码
     * @param repeatNewPassword 重复新密码
     * @return result: 状态，message：信息
     * 修改密码
     */
    @ResponseBody
    @RequestMapping(value = "changePassword")
    public Map<String, String> changePassword(String oldPassword, String newPassword, String repeatNewPassword) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return changePasswordService.changePassword(oldPassword,newPassword,repeatNewPassword);
    }

}
