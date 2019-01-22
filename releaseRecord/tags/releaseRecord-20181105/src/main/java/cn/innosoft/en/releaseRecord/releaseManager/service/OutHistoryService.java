package cn.innosoft.en.releaseRecord.releaseManager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.releaseRecord.releaseManager.model.TJcDetoxInfo;
import cn.innosoft.en.releaseRecord.releaseManager.model.TOutHistory;
import cn.innosoft.en.releaseRecord.releaseManager.persistent.OutHistoryDao;
import cn.innosoft.en.util.Util;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;

@Service("OutHistoryService")
public class OutHistoryService extends AbstractBaseService<TOutHistory, String>{
	
	@Autowired
	private OutHistoryDao dao;
	
	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;

	@Override
	public BaseDao<TOutHistory, String> getBaseDao() {
		return dao;
	}
	
	/**
	 * 添加出所记录
	 * @param number
	 */
	public void addOutHisByNumber(String number) {
		if("".equals(number)||null==number){
			return;
		}
		TJcDetoxInfo jcDetoxInfo = jcDetoxInfoService.findOne(number);
		String name = jcDetoxInfo.getName();
		String outType = jcDetoxInfo.getOutType();
		String outTypeVal = jcDetoxInfo.getOutTypeValue();
		String id = jcDetoxInfo.getHistory_id();
		TOutHistory outHistory = findOne(id);//2018-10-24 更新历史记录表
		String time = Util.getCurTimeUUID();
		String optName = OrmHelper.getCurrentUserName();
		//outHistory.setOutHistoryId(Util.getUUID());
		outHistory.setCreateDate(time);
		outHistory.setUpdateDate(time);
		outHistory.setCreateUserName(optName);
		outHistory.setUpdateUserName(optName);
		outHistory.setOutTime(time);
		outHistory.setOutPersonName(name);
		outHistory.setOutPersonNumber(number);
		outHistory.setOutType(outType);
		outHistory.setOutTypeVal(outTypeVal);
		//add(outHistory);
		updateSome(outHistory);
	}
	
	/**
	 * 查询个人出所记录
	 * @param number
	 * @return
	 */
	public List<Map<String, Object>> getOutHisListByNumber(String number) {
		if("".equals(number)||null==number){
			return null;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userNumber", number);
		List<Map<String, Object>> list = findMapBySql("outHistory-getoutHisList", params);
		return list;
	}
	
	/**
	 * 出所记录分页
	 * @param number
	 * @param curr
	 * @param nums
	 * @return
	 */
	public Map<String, Object> getOutHisPage(String number) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("count", 0);
		List<Map<String, Object>> list = getOutHisListByNumber(number);
		if(null!=list){
			if(list.size()>0){
				resultMap.put("count", list.size());
			}
		}
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("data", list);
		return resultMap;
	}

	/**
	 * @param number  人员编号
	 * @param name    人员姓名
	 * @param outType 出所类型：正常，临时
	 * @param historyId 本次历史记录主键
	 */
	public void addTOutHistory(String number, String name, String outType, String historyId) {
		TOutHistory historyRecord = new TOutHistory();
		historyRecord.setOutHistoryId(historyId);
		historyRecord.setCreateDate(Util.getCurTimeUUID());
		historyRecord.setCreateUserName(OrmHelper.getCurrentUserName());
		historyRecord.setOutPersonName(name);
		historyRecord.setOutPersonNumber(number);
		historyRecord.setOutPlace("");
		historyRecord.setOutReason("");
		historyRecord.setOutRecord("");
		historyRecord.setOutTime("");
		historyRecord.setOutType(outType);
		historyRecord.setOutTypeVal("");
		historyRecord.setUpdateDate(Util.getCurTimeUUID());
		historyRecord.setUpdateUserName(OrmHelper.getCurrentUserName());
		add(historyRecord);		
	}

}
