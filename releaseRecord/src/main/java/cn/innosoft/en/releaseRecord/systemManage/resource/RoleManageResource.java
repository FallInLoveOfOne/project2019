package cn.innosoft.en.releaseRecord.systemManage.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色管理
 */
@Controller
@RequestMapping(value = "systemManage/roleManage")
public class RoleManageResource {

    private static final String PATH = "sanyang/iframe/system";

    /**
     * @return  跳转至角色管理
     */
    @RequestMapping(value = "toCharacter")
    public String toCharacter() {
        return PATH + "/character";
    }
}
