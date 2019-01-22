package cn.innosoft.en.releaseRecord.releaseManager.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.innosoft.en.releaseRecord.releaseManager.model.TJcDetoxInfo;
import cn.innosoft.en.util.Util;
import cn.innosoft.en.util.ks.SanYUtil;

@Service
public class DataSynchService {
	
	@Autowired
	private JcDetoxInfoService jcDetoxInfoService;
	
	public void synchroPersonData() throws IOException {
		// 请求接口: http://10.118.5.86:8380/jc/prisoner/findAllDetoxPeopleInfo?prisonId=330301131&page=2&size=50
		// 从三洋接口获取戒毒人员数据
		
//		String url = PropsUtil.getValue("sanyangIp")+"/jc/prisoner/findAllDetoxPeopleInfo?prisonId="+PropsUtil.getValue("prisonId")+"&page=1&size=88888888888"; 
//		String url = "http://10.118.5.86:8380/jc/prisoner/findAllDetoxPeopleInfo?prisonId=330301131&size=88888888888"; 
		String datas = SanYUtil.getAllPerson();//HttpDeal.get(url); 获取三洋人员接口更换（2018-10-09）
//		String datas = "{\"pageNum\":1,\"pageSize\":20,\"size\":2,\"orderBy\":null,\"startRow\":1,\"endRow\":2,\"total\":2,\"pages\":1,\"list\":[{\"number\":\"330301131201808240055\",\"name\":\"薛纪晓\",\"anotherName\":\"无\",\"sex\":\"1\",\"sexValue\":\"男性\",\"birth\":\"19770402\",\"marriage\":\"4\",\"marriageValue\":\"离婚\",\"identityId\":\"330327197704020953\",\"identityType\":\"11\",\"identityTypeValue\":\"身份证\",\"origin\":\"330327\",\"originValue\":\"浙江省温州市苍南县\",\"ethnicGroup\":\"01\",\"ethnicGroupValue\":\"汉族\",\"politicalStatus\":\"13\",\"politicalStatusValue\":\"群众\",\"nationality\":\"156\",\"nationalityValue\":\"中国\",\"houseAddr\":\"330327\",\"houseAddrValue\":\"浙江省温州市苍南县\",\"houseDetailAddr\":\"宜山镇仁寿街２６号\",\"specialIdentity\":\"99\",\"specialIdentityValue\":\"其他\",\"identity\":\"05\",\"identityValue\":\"农民\",\"workAddr\":\"无\",\"position\":\"无\",\"specialty\":\"90\",\"specialtyValue\":\"其他专长\",\"education\":\"70\",\"educationValue\":\"初中\",\"work\":\"Y00\",\"workValue\":\"不便分类的其他从业人员\",\"dormCode\":\"1106\",\"prisonId\":\"330301131\",\"prisonName\":\"温州市三垟强制隔离戒毒所\",\"detoxLimit\":\"14\",\"detoxLimitValue\":\"两年\",\"detoxBegin\":\"20180905\",\"imprisonLimit\":\"20200904\",\"brief\":\"2018年8月24日，因吸食毒品后被公安机关查获。\",\"comeDate\":\"20180905093357\",\"comeReason\":\"01\",\"comeReasonValue\":\"\",\"transactor\":\"林震\",\"transactorPhone\":\"747709\",\"manageType\":\"1\",\"manageTypeValue\":\"重点\",\"emphasisPersoner\":\"1\",\"emphasisPersonerValue\":\"否\"},{\"number\":\"330301131201808210040\",\"name\":\"王丽跃\",\"sex\":\"2\",\"sexValue\":\"女性\",\"birth\":\"19700814\",\"marriage\":\"2\",\"marriageValue\":\"已婚\",\"identityId\":\"330302197008145923\",\"identityType\":\"11\",\"identityTypeValue\":\"身份证\",\"origin\":\"330302\",\"originValue\":\"浙江省温州市鹿城区\",\"ethnicGroup\":\"01\",\"ethnicGroupValue\":\"汉族\",\"politicalStatus\":\"13\",\"politicalStatusValue\":\"群众\",\"nationality\":\"156\",\"nationalityValue\":\"中国\",\"houseAddr\":\"330302\",\"houseAddrValue\":\"浙江省温州市鹿城区\",\"houseDetailAddr\":\"南郊街道横塘巷26--3号\",\"specialIdentity\":\"99\",\"specialIdentityValue\":\"其他\",\"identity\":\"09\",\"identityValue\":\"无业人员\",\"workAddr\":\"不详\",\"position\":\"不详\",\"specialty\":\"90\",\"specialtyValue\":\"其他专长\",\"education\":\"70\",\"educationValue\":\"初中\",\"work\":\"Y00\",\"workValue\":\"不便分类的其他从业人员\",\"dormCode\":\"3305\",\"prisonId\":\"330301131\",\"prisonName\":\"温州市三垟强制隔离戒毒所\",\"detoxLimit\":\"14\",\"detoxLimitValue\":\"两年\",\"detoxBegin\":\"20180905\",\"detoxEnd\":\"20180905\",\"imprisonLimit\":\"20200904\",\"holdBegin\":\"20180821\",\"brief\":\"2018年08月21日该王丽跃因吸食毒品被公安机关查获，尿检呈阳性。\",\"comeDate\":\"20180905092658\",\"comeReason\":\"01\",\"comeReasonValue\":\"\",\"transactor\":\"叶军\",\"transactorPhone\":\"588588\",\"manageType\":\"1\",\"manageTypeValue\":\"重点\",\"emphasisPersoner\":\"1\",\"emphasisPersonerValue\":\"否\"}],\"firstPage\":1,\"prePage\":0,\"nextPage\":0,\"lastPage\":1,\"isFirstPage\":true,\"isLastPage\":true,\"hasPreviousPage\":false,\"hasNextPage\":false,\"navigatePages\":8,\"navigatepageNums\":[1]}";
		if("".equals(datas)||null==datas){
			return;
		}
		JSONObject jsonObject = new JSONObject(datas);
		int total = jsonObject.getInt("total");
		JSONArray dataArray = jsonObject.getJSONArray("list");
		if(total==0){
			return;
		}
		List<Object> list = dataArray.toList();
		try {
			execDeal(list);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*for (int key=0;key<list.size();key++) {
			Object object = list.get(key);
			//JSONObject object = new JSONObject(bean);
			@SuppressWarnings("unchecked")
			Map<String, Object> userMap = (Map<String, Object>)object;//object.toMap();
			String number_id = Util.isEmpt(userMap.get("number"));
			TJcDetoxInfo haveDetoxInfo = jcDetoxInfoService.findOne(number_id);
			if (null != haveDetoxInfo) {// 若本库有有此数据，则更新本库的时间
				String updateTime = haveDetoxInfo.getUpdateTime();
				if(null==updateTime||"".equals(updateTime)){// 如果本库没有操作过，则先删除后新增
					jcDetoxInfoService.deleteById(number_id);// 删除此条记录
					String ksId = haveDetoxInfo.getKsUserId();
					if(null!=ksId&&!"".equals(ksId)){
						KSUtil.deleteUserById(ksId);// 删除旷视数据
					}
					jcDetoxInfoService.addDetoxInfoByMap(userMap);// 新增到本地库
				}
				//updatePersonByMap(haveDetoxInfo, userMap);备用2018-10-24
			} else {// 如果本库无数据，需要新增到本库
				jcDetoxInfoService.addDetoxInfoByMap(userMap);
			}
		}*/
	}
	
	
	public void execDeal(List<Object> list) throws InterruptedException {
		int count = 50;
		int listSize = list.size();
		int runSize = (listSize / count) + 1;
		List<Object> newlist = null;
		ExecutorService executor = Executors.newFixedThreadPool(runSize);
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(runSize);
		for (int i = 0; i < runSize; i++) {
			if ((i + 1) == runSize) {
				int startIndex = (i * count);
				int endIndex = list.size();
				newlist = list.subList(startIndex, endIndex);
			} else {
				int startIndex = (i * count);
				int endIndex = (i + 1) * count;
				newlist = list.subList(startIndex, endIndex);
			}
			Runnable mythead = dealThread(newlist, begin, end);
			executor.execute(mythead);
		}

		begin.countDown();
		end.await();

		executor.shutdown();
	}

	public Runnable dealThread(List<Object> list, CountDownLatch begin,
			CountDownLatch end) {
		Thread thread = null;
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 业务处理代码
					for (int key=0;key<list.size();key++) {
						Object object = list.get(key);
						//JSONObject object = new JSONObject(bean);
						@SuppressWarnings("unchecked")
						Map<String, Object> userMap = (Map<String, Object>)object;//object.toMap();
						String number_id = Util.isEmpt(userMap.get("number"));
						TJcDetoxInfo haveDetoxInfo = jcDetoxInfoService.findOne(number_id);
						if (null != haveDetoxInfo) {// 若本库有有此数据，则更新本库的时间
							String updateTime = haveDetoxInfo.getUpdateTime();
							if(null==updateTime||"".equals(updateTime)){// 如果本库没有操作过，则先删除后新增
								/*
								jcDetoxInfoService.deleteById(number_id);// 删除此条记录
								String ksId = haveDetoxInfo.getKsUserId();
								if(null!=ksId&&!"".equals(ksId)){
									KSUtil.deleteUserById(ksId);// 删除旷视数据
								}
								jcDetoxInfoService.addDetoxInfoByMap(userMap);// 新增到本地库
								*/
								jcDetoxInfoService.updatePersonByMap(haveDetoxInfo, userMap);//备用2018-10-24
							}
							//jcDetoxInfoService.updatePersonByMap(haveDetoxInfo, userMap);//备用2018-10-24
						} else {// 如果本库无数据，需要新增到本库
							jcDetoxInfoService.addDetoxInfoByMap(userMap);
						}
					}
					
					/*for (int i = 0; i < list.size(); i++) {
						{
						TJcDetoxInfo jcDetoxInfo = list.get(i);
						jcDetoxInfoService.add(jcDetoxInfo);
						}
					}*/
					// ....
					begin.await();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					end.countDown();
				}
			}
		});
		return thread;
	}
}
