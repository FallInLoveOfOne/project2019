package cn.innosoft.en.releaseRecord.systemManage.service;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.login.client.model.ClientUser;
import cn.innosoft.en.util.loginUtil.DESUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChangePasswordService {

    @Autowired
    private TFwOrmUserEntityService tFwOrmUserEntityService;

    /**
     * @param oldPassword       原始密码
     * @param newPassword       新密码
     * @param repeatNewPassword 重复新密码
     * @return result: 状态，message：信息
     * 修改密码
     */
    public Map<String,String> changePassword(String oldPassword, String newPassword, String repeatNewPassword) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Map<String,String> resultMap = new HashMap<>();
        if(!(StringUtils.isEmpty(oldPassword.trim())||StringUtils.isEmpty(newPassword.trim())||StringUtils.isEmpty(repeatNewPassword.trim()))){
            if(newPassword.equals(repeatNewPassword)){
                ClientUser clientUser = OrmHelper.getCurrentUser(); //获取当前用户信息
                String passwordMD5 = clientUser.getPwd(); //获取当前密码
                String currentPassword = DESUtils.decrypt(passwordMD5); //解密
                String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$";
                if(currentPassword.equals(oldPassword)){    //判断原始密码是否正确
                    String newPasswordMD5 = DESUtils.encrypt(newPassword); //新密码加密
                    tFwOrmUserEntityService.updateUserPassword(clientUser,newPasswordMD5);    //执行数据库密码修改
                    resultMap.put("result","success");
                    resultMap.put("message","密码修改成功！");
                }else{  //原始密码错误
                    resultMap.put("result","error");
                    resultMap.put("message","原密码输入错误！");
                }
            }else{
                resultMap.put("result","error");
                resultMap.put("message","新密码和重复密码不一致！");
            }
        }else{
            resultMap.put("result","error");
            resultMap.put("message","原密码、新密码、重复密码不能为空！");
        }
        return resultMap;
    }

}
