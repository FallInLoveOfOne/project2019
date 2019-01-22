package cn.innosoft.en.releaseRecord.dataInterfaceManage.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据接口列表
 */
@Controller
@RequestMapping(value = "dataInterfaceManage/dataInterfaceList")
public class DataInterfaceListResource {

    private static final String PATH = "sanyang/iframe/dataInterfaceManage";

    /**
     * @return 跳转到数据接口列表
     */
    @RequestMapping(value = "/toDataInterfaceList")
    public String toDataInterfaceList() {
        return PATH + "/dataInterfaceList";
    }

}
