package cn.innosoft.en.releaseRecord.releaseManager.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.innosoft.en.common.OrmHelper;
import cn.innosoft.en.releaseRecord.releaseManager.model.TFcfRecord;
import cn.innosoft.en.releaseRecord.releaseManager.model.TJcDetoxInfo;
import cn.innosoft.en.releaseRecord.releaseManager.persistent.FcfRecordDao;
import cn.innosoft.en.util.Util;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;

@Service("TFcfRecordService")
public class FcfRecordService extends AbstractBaseService<TFcfRecord, String> {

	@Autowired
	private FcfRecordDao dao;
	
	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;
	
	@Autowired
	private OutHistoryService outHistoryService;
	
	@Override
	public BaseDao<TFcfRecord, String> getBaseDao() {
		return dao;
	}

	/**
	 * 添加出所操作节点信息
	 * @param personNumber 出所人员编号
	 * @param name 出所人员姓名
	 * @param stage 出所阶段
	 * @param items 操作描述
	 * @param excepFlag 是否异常
	 */
	public void addOptInfo(String personNumber, String name,String stage,String items,String excepFlag) {
		//2018-10-17 创建历史记录表   
		String historyId = Util.getUUID();//历史记录主键  也是本次一轮操作的执行记录外键
		
		TJcDetoxInfo jcDetoxInfo = jcDetoxInfoService.findOne(personNumber);
		if(null != jcDetoxInfo && null != jcDetoxInfo.getHistory_id() && !"".equals(jcDetoxInfo.getHistory_id()) ){
			historyId  = jcDetoxInfo.getHistory_id();//有操作记录
		}else{
			//没有操作记录就添加历史记录表，否则就用原来的历史记录表id作为外键来保存操作节点信息
			outHistoryService.addTOutHistory(personNumber,name,"",historyId);
			jcDetoxInfo.setHistory_id(historyId);
			jcDetoxInfoService.updateSome(jcDetoxInfo);
		}
		
		TFcfRecord record = new TFcfRecord();
		record.setId(Util.getUUID());
		record.setCreateTime(Util.getCurTimeUUID());
		record.setUpdateTime(Util.getCurTimeUUID());
		record.setCreateUserCode(OrmHelper.getCurrentUserId());
		record.setCreateUserName(OrmHelper.getCurrentUserName());
		record.setDetoxNum(personNumber);
		record.setDetoxName(name);
		record.setItem(items);
		record.setNowStage(stage);
		record.setHaveExcep(excepFlag);
		//String historyId = getJcInfoHistoryID(personNumber);//2018-10-24
		record.setHistoryId(historyId);
		add(record);
	}
	
	/**
	 * 获取出所节点记录
	 * @param personNumber
	 * @param name
	 * @return
	 */
	public List<Map<String, Object>> getRecordList(String personNumber, String name,String historyId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("personNumber", personNumber);
		params.put("userName", name);
		params.put("historyId", historyId);
		List<Map<String, Object>> list = findMapBySql("fcfRecord-getRecordList", params);
		return list;
	}
	
	/**
	 * 获取出所记录列表
	 * @param personNumber
	 * @param name
	 * @return
	 */
	public Map<String, Object> getCordPage(String personNumber, String name,String historyid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("count", 0);
		List<Map<String, Object>> list = getRecordList(personNumber,name, historyid);
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
	 * 删除最靠前上传出所单的记录，用于出所单附件完全删除的情况
	 * @param number
	 */
	public void deleteNewUploadRecord(String number) {
		List<Map<String, Object>> recordList = getRecordList(number, null,null);// 查询操作表信息
		if(null!=recordList){
			if(recordList.size()>0){
				Iterator<Map<String, Object>> iterator = recordList.iterator();
				while(iterator.hasNext()){
					Map<String, Object> one = iterator.next();
					String now_stage = Util.isEmpt(one.get("NOW_STAGE"));
					String recordId = Util.isEmpt(one.get("ID"));
					if("FJYC".equals(now_stage)){
						delete(recordId);
					}else {
						//break;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * 判断最新的操作记录是否与给的状态温和，确认是否更新时间
	 * @param number
	 * @param nowState
	 * @return
	 */
	public boolean checkFirstAndUpdate(String number,String nowStateOpt) {
		//String historyId = getUpStepId(number,nowStateOpt);
			String historyId = getJcInfoHistoryID(number);
			List<Map<String, Object>> recordList = getRecordList(number, null,historyId);
			if(null!=recordList){
				if(recordList.size()>0){
					Map<String, Object> map = recordList.get(0);// 取得最新的操作记录
					String record_id = Util.isEmpt(map.get("ID"));
					// DBSB-NO
					String now_stage = Util.isEmpt(map.get("NOW_STAGE"));
					if(nowStateOpt.equals(now_stage)){// 与要操作的状态吻合
						TFcfRecord fcfRecord = findOne(record_id);
						String time = Util.getCurTimeUUID();
						fcfRecord.setUpdateTime(time);
						fcfRecord.setCreateUserName(OrmHelper.getCurrentUserName());
						fcfRecord.setCreateUserCode(OrmHelper.getCurrentUserAcct());
						fcfRecord.setCreateTime(time);
						fcfRecord.setHistoryId(historyId);
						updateSome(fcfRecord);
						return true;
					}
				}
			}
		return false;
	}

	/**获取人员标的外键historyId
	 * @param number
	 * @return
	 */
	public String getJcInfoHistoryID(String number) {
		String historyId="";
		TJcDetoxInfo jcDetoxInfo = jcDetoxInfoService.findOne(number);
		if(null != jcDetoxInfo && null != jcDetoxInfo.getHistory_id() && !"".equals(jcDetoxInfo.getHistory_id()) ){
			historyId = jcDetoxInfo.getHistory_id();
		}
		return historyId;
	}
	
	/**
	 * 删除操作记录根据number（2018-10-11）
	 * @param number
	 */
	public void deleteByNumber(String number) {
		if("".equals(number)||null==number){
			return;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("personNumber", number);
		executeUpdateBySql("fcfRecord-deleteByNumber", params);
		
	}
	
	

}
