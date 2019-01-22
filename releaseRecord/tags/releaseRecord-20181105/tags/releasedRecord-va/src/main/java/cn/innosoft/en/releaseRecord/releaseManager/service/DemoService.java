package cn.innosoft.en.releaseRecord.releaseManager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import cn.innosoft.en.releaseRecord.home.model.DemoUser;
import cn.innosoft.en.releaseRecord.home.persistent.DemoUserDao;
import cn.innosoft.en.util.EnUtil;
import cn.innosoft.fw.biz.base.web.PageRequest;
import cn.innosoft.fw.biz.base.web.PageResponse;
import cn.innosoft.fw.biz.core.persistent.BaseDao;
import cn.innosoft.fw.biz.core.service.AbstractBaseService;

/**
 * 分页demo
 * 
 * @author sh
 *
 */
public class DemoService extends AbstractBaseService<DemoUser, String> {

	@Autowired
	private DemoUserDao dao;

	@Override
	public BaseDao<DemoUser, String> getBaseDao() {
		return dao;
	}

	/**
	 * 
	 * @param pageRequest
	 * @return
	 */
	public PageResponse<Map<String, Object>> getListQueryPage(
			PageRequest pageRequest) {
		Map<String, Object> params = EnUtil.jsonToParaMap(pageRequest
				.getQueryCondition()); // 查询条件
		PageResponse<Map<String, Object>> pageResponse = null;
		pageResponse = findMapBySql("demo_user-getListQueryPage", params,
				pageRequest);
		return pageResponse;
	}

	/**
	 * 初代版本的layui分页
	 * 
	 * @param id
	 * @param name
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> getListPage2(String userName,String userNumber,String startDate,String endDate,String excepVal,String curr,String nums) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> list = null;
		long total = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", userName);
		param.put("userNumber", userNumber);
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("excepVal", excepVal);
		System.out.println("layui分页查询参数："+userName+"--"+userNumber+"--"+curr+"--"+nums);
		PageRequest pageRequest = new PageRequest();
		pageRequest.setPage(Integer.parseInt(curr));
		pageRequest.setRows(Integer.parseInt(nums));
		PageResponse<Map<String, Object>> pageResponse = findMapBySql(
				"demo_user-getListQueryPage", param, pageRequest);
		if(null!=pageResponse){
			list = pageResponse.getRows();
			total = pageResponse.getTotal();
		}
		result.put("code", 0);
		result.put("msg", "");
		result.put("count", total);
		result.put("data", list);
		return result;
	}

	/*********************************** 出所管理的后端接口 ***********************************/

	/**
	 * 同步近一周出所戒毒人员数据
	 * 
	 * @param endData
	 *            出所日期
	 * @param days近多少天
	 */
	public boolean synchroPersonData(String endData, String days) {
		return true;
	}

	/**
	 * 同步人员照片
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 */
	public boolean synchroPersonPhoto(String prisonId, String number) {
		// byte[]
		return true;
	}

	/**
	 * 正常出所人员分页（本库）
	 * 
	 * @param pageRequest
	 * @return
	 */
	public PageResponse<Map<String, Object>> normalReleasePage(
			PageRequest pageRequest) {
		return null;
	}

	/**
	 * 临时出所出所人员分页（本库）
	 * 
	 * @param pageRequest
	 * @return
	 */
	public PageResponse<Map<String, Object>> temporaryReleasePage(
			PageRequest pageRequest) {
		return null;
	}

	/**
	 * 查询出所人员详情信息（本库）
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 */
	public Map<String, Object> getOutPersonDetails(String prisonId,
			String number) {
		return null;
	}

	/**
	 * 出所头像核对
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 */
	public boolean headPortraitCheck(String prisonId, String number) {
		return true;
	}

	/**
	 * 出所单文件上传
	 */
	public String uploadOutList(HttpServletRequest request) {
		return null;
	}

	/**
	 * 更新新出所人员信息
	 * 
	 * @param person
	 */
	public void updateOutPerson(Object person) {

	}

	/**
	 * 添加出所节点记录
	 */
	public boolean addOptInfo(String personNumber, String name, String items) {
		return true;
	}

	/*********************************** 存证管理的后端接口 ***********************************/

	/**
	 * 存证管理分页查询
	 * 
	 * @param pageRequest
	 * @return
	 */
	public PageResponse<Map<String, Object>> evidencePage(
			PageRequest pageRequest) {
		return null;
	}

	/**
	 * 查询存证人员详情信息
	 * 
	 * @param prisonId
	 * @param number
	 * @return
	 */
	public Map<String, Object> getEvidencePersonDetails(String prisonId,
			String number) {
		return null;

	}

	/**
	 * 查询出所节点所记录信息
	 * 
	 * @param number
	 * @param name
	 * @return
	 */
	public List<Map<String, Object>> getOutRecord(String number, String name) {
		return null;
	}

	/**
	 * 出所单文件下载
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	public void downOutList(HttpServletRequest request,
			HttpServletResponse response, String id) {

	}
	
	public static void main(String[] args) {
		
	}

}
