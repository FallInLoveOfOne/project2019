package cn.innosoft.en.releaseRecord.dataInterfaceManage.resource;

import cn.innosoft.en.releaseRecord.dataInterfaceManage.service.InterfaceCallStatisticsService;
import cn.innosoft.en.util.LayuiTable;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 数据接口管理/接口调用统计
 */
@Controller
@RequestMapping(value = "dataInterfaceManage/interfaceCallStatistics")
public class InterfaceCallStatisticsResource {

    private static final String PATH = "sanyang/iframe/dataInterfaceManage";

    @Autowired
    private InterfaceCallStatisticsService interfaceCallStatisticsService;

    /**
     * @return 跳转到接口调用统计
     */
    @RequestMapping(value = "toInterfaceCallStatistics")
    public String toInterfaceCallStatistics() {
        return PATH + "/interfaceCallStatistics";
    }

    /**
     * @param pageRequest 分页请求信息
     * @return 分页数据
     * 分页查询数据接口的调用信息
     */
    @ResponseBody
    @RequestMapping(value = "pageFindInterfaceCallInfo")
    public LayuiTable  pageFindInterfaceCallInfo(PageRequest pageRequest) {
        PageResponse<Map<String, Object>> mapPageResponse = interfaceCallStatisticsService.pageFindInterfaceCallInfo(pageRequest);
        return LayuiTable.data(mapPageResponse);
    }

    /**
     * @param startDate 起始时间
     * @param endDate   截至时间
     * @return 所以接口&接口调用访问量
     * 查询各接口调用数量占比
     */
    @ResponseBody
    @RequestMapping(value = "getInterfaceCallRatioByStartEndTime")
    public List<Map<String, Object>> getInterfaceCallRatioByStartEndTime(String startDate, String endDate) {
        return interfaceCallStatisticsService.getInterfaceCallRatioByStartEndTime(startDate, endDate);
    }

    /**
     * @return 当天接口调用数量统计
     * 每日接口调用频率
     */
    @ResponseBody
    @RequestMapping(value = "getDailyInterfaceCallFrequency")
    public List<Map<String, Object>> getDailyInterfaceCallFrequency() {
        return interfaceCallStatisticsService.getDailyInterfaceCallFrequency();
    }

}
