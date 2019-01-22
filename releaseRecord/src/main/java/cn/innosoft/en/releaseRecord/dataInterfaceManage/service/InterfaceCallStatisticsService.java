package cn.innosoft.en.releaseRecord.dataInterfaceManage.service;

import cn.innosoft.en.util.EnUtil;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 接口调用统计
 */
@Service
public class InterfaceCallStatisticsService {

    @Autowired
    private TFcfInterfaceEntityService tFcfInterfaceEntityService;

    /**
     * @param interfaceName 接口名称
     * @param url           接口url
     * @param callModule    调用模块
     * @return 成功true\\失败false
     * 添加接口调用
     */
    public boolean addDataInterfaceCallInfo(String interfaceName, String url, String callModule) {
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("id", EnUtil.getUUID());
        paraMap.put("interfaceName", interfaceName);
        paraMap.put("url", url);
        paraMap.put("callTime", EnUtil.getCurTime("yyyy-MM-dd HH:mm"));
        paraMap.put("callModule", callModule);
        int addNumber = tFcfInterfaceEntityService.addTFcfInterfaceEntity(paraMap);
        return addNumber > 0 ? true : false;
    }

    /**
     * @param pageRequest 分页请求信息
     * @return 分页数据
     * 分页查询数据接口的调用信息
     */
    public PageResponse<Map<String, Object>> pageFindInterfaceCallInfo(PageRequest pageRequest) {
        Map<String, Object> paraMap = EnUtil.jsonToParaMap(pageRequest.getQueryCondition()); // 查询条件
        String startDate = EnUtil.changeNull(paraMap.get("startDate")); //获取起始时间
        if(!StringUtils.isEmpty(startDate)){
            paraMap.put("startDate", EnUtil.formatDate(startDate, "yyyy-MM-dd", "yyyy-MM-dd HH:mm"));
        }
        String endDate = EnUtil.changeNull(paraMap.get("endDate")); //获取截至时间
        if(!StringUtils.isEmpty(endDate)){
            paraMap.put("endDate", delayedOneDay(endDate, "yyyy-MM-dd", "yyyy-MM-dd HH:mm"));
        }
        return tFcfInterfaceEntityService.pageFindTFcfInterfaceEntity(paraMap, pageRequest);
    }

    /**
     * @param startDate 起始时间
     * @param endDate   截至时间
     * @return 所以接口&接口调用访问量
     * 查询各接口调用数量占比
     */
    public List<Map<String, Object>> getInterfaceCallRatioByStartEndTime(String startDate, String endDate) {
        Map<String, Object> paraMap = new HashMap<>(); // 查询条件
        if(!StringUtils.isEmpty(startDate)){
            paraMap.put("startDate",EnUtil.formatDate(startDate, "yyyy-MM-dd", "yyyy-MM-dd HH:mm"));
        }
        if(!StringUtils.isEmpty(endDate)){
            paraMap.put("endDate", delayedOneDay(endDate, "yyyy-MM-dd", "yyyy-MM-dd HH:mm"));
        }
        return tFcfInterfaceEntityService.findInterfaceCallRatioByStartEndTime(paraMap);
    }

    /**
     * @return 当天接口调用数量统计
     * 每日接口调用频率
     */
    public List<Map<String, Object>> getDailyInterfaceCallFrequency() {
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("startDate", getDayBegin());
        paraMap.put("endDate", getDayEnd());
        return tFcfInterfaceEntityService.findInterfaceCallRatioByStartEndTime(paraMap);
    }

    /**
     * @return 获取当天的开始时间
     */
    public String getDayBegin() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return simpleDateFormat.format(cal.getTime());
    }

    /**
     * @return 获取当天的结束时间
     */
    public String getDayEnd() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return simpleDateFormat.format(cal.getTime());
    }

    /**
     * @param dateStr   日期字符串
     * @param importFormat  传入日期格式
     * @param outputFormat  返回日期格式
     * @return  返回传入日期的23:59:59
     * 传入日期、传入日期格式及返回日期格式，返回传入日期的23:59:59
     */
    public String delayedOneDay(String dateStr,String importFormat,String outputFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(importFormat);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date); //设置参数时间
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        date = calendar.getTime();  //这个时间就是日期移动之后的结果
        SimpleDateFormat sdFormat = new SimpleDateFormat(outputFormat);
        return sdFormat.format(date);
    }
}
