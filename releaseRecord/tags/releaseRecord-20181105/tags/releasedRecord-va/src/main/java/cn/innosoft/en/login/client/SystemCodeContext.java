/**
 * 
 */
package cn.innosoft.en.login.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import cn.innosoft.en.login.client.model.ClientCode;
import cn.innosoft.en.login.client.model.LoginSystem;
import cn.innosoft.en.login.client.model.LoginUser;





/**
 * @author huangwb
 * @date 2014-5-14 下午5:14:46
 */
public class SystemCodeContext {

	/**
	 * 用户拥有的全局代码合集
	 */
	private static Map<String, List<ClientCode>> globalCodes;

	private static Map<String, String> globalCoedStrings = new HashMap<String, String>();

	public static Map<String, List<ClientCode>> getGlobalCodes() {
		return globalCodes;
	}

	public static void setGlobalCodes(Map<String, List<ClientCode>> globalCodes) {
		SystemCodeContext.globalCodes = globalCodes;
		globalCoedStrings = new HashMap<String, String>();
	}

	/**
	 * 根据代码集ID,得到代码集对应的代码，不支持层级.
	 * 
	 * @param codeIndexId
	 *            代码集ID
	 * @return 代码集JSON串
	 */
	public static String getSelectTemplate(String codeIndexId, String url) {
		List<ClientCode> userCodes = getUserCodes(codeIndexId, url);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		boolean needDelete = false;
		if (userCodes != null) {
			for (ClientCode cc : userCodes) {
				sb.append("{");
				sb.append("\"value\":").append("\"").append(cc.getCodeValue()).append("\"");
				sb.append(",\"text\":").append("\"").append(cc.getCodeNameCn()).append("\"");
				sb.append("},");
				needDelete = true;
			}
		}
		if (needDelete) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * 根据代码集ID,得到代码集对应的代码.支持多个代码集，不支持层级.
	 * 
	 * @param codeIndexIds
	 *            多个代码集ID
	 * @return 代码集JSON串
	 */
	public static String getSelectTemplate(String[] codeIndexIds, String url) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		boolean needDelete = false;
		for (String codeIndexId : codeIndexIds) {
			sb.append("\"").append(codeIndexId).append("\":").append(getSelectTemplate(codeIndexId, url)).append(",");
			needDelete = true;
		}
		if (needDelete) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * 根据代码集ID,得到代码集对应的代码，支持层级.
	 * 
	 * @param codeIndexId
	 *            代码集ID
	 * @return 代码集JSON串
	 */
	public static String getTreeTemplate(String codeIndexId, String url) {
		String retString = "";
		// 指定代码集中用户可见的代码ID
		List<ClientCode> userCodes = getUserCodes(codeIndexId, url);
		List<String> codeIds = getUserCodesId(userCodes);
		// 先从缓存层次中找
		if (globalCoedStrings.containsKey(codeIndexId)) {
			retString = globalCoedStrings.get(codeIndexId);
		} else {
			// 当前系统指定代码集中所有的代码
			List<ClientCode> systemCodes = getGlobalCodes().get(codeIndexId);
			StringBuilder sb = new StringBuilder();
			List<ClientCode> topCodes = getSameLevelCodeBySerial(codeIndexId, systemCodes);
			sb.append("[");
			sb.append(getCodeString(topCodes, systemCodes, codeIds));
			sb.append("]");
			retString = sb.toString();
		}

		// 对返回数据与用户可见数据进行比对，可见的去掉disabled
		for (String id : codeIds) {
			retString = retString.replace(",\"disabled\":\"" + id + "_true\"", "");
		}
		retString = retString.replaceAll("\"disabled\":\"[\\w]*?_true\"", "\"disabled\":\"true\"");

		return retString;
	}

	/**
	 * 拼接代码层级数据.
	 * 
	 * @param topCodes
	 *            某一层次的代码
	 * @param systemCodes
	 *            当前系统指定代码集中所有的代码
	 * @param codeIds
	 *            指定代码集中用户可见的代码ID
	 * @return 代码层级数据
	 */
	private static String getCodeString(List<ClientCode> topCodes, List<ClientCode> systemCodes, List<String> codeIds) {
		StringBuilder sb = new StringBuilder();
		boolean needDelete = false;
		for (ClientCode code : topCodes) {
			sb.append("{");
			sb.append("\"value\":").append("\"").append(code.getCodeValue()).append("\"");
			sb.append(",\"text\":").append("\"").append(code.getCodeNameCn()).append("\"");

			// 预先占个位
			sb.append(",\"disabled\":").append("\"").append(code.getCodeId()).append("_true\"");

			// disabled在后面加上
			// if (!codeIds.contains(code.getCodeId())) {
			// sb.append("disabled:").append("true,");
			// }
			List<ClientCode> childCodes = getSameLevelCode(code.getCodeId(), systemCodes);
			if (childCodes != null && childCodes.size() > 0) {
				sb.append(",\"child\":").append("[");
				sb.append(getCodeString(childCodes, systemCodes, codeIds));
				sb.append("]");
			}
			sb.append("},");
			needDelete = true;
		}
		if (needDelete) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * 获取代码中某一层次的代码.
	 * 
	 * @param pCodeId
	 *            代码的父ID
	 * @param allCodes
	 *            指定代码集中代码
	 * @return 代码中某一层次的代码
	 */
	private static List<ClientCode> getSameLevelCode(String pCodeId, List<ClientCode> allCodes) {
		List<ClientCode> retCodes = new ArrayList<ClientCode>();
		for (ClientCode code : allCodes) {
			if (pCodeId.equals(code.getpCodeId())) {
				retCodes.add(code);
				continue;
			}
		}
		return retCodes;
	}

	/**
	 * 获取代码集下一层代码.
	 * 
	 * @param codeIdxSerial
	 *            代码集的标识
	 * @param allCodes
	 *            指定代码集中代码
	 * @return 代码集下一层代码
	 */
	private static List<ClientCode> getSameLevelCodeBySerial(String codeIdxSerial, List<ClientCode> allCodes) {
		List<ClientCode> retCodes = new ArrayList<ClientCode>();
		for (ClientCode code : allCodes) {
			if (code.getpCodeId().equals(code.getCodeIdxId()) && codeIdxSerial.equals(code.getCodeIdxSerial())) {
				retCodes.add(code);
				continue;
			}
		}
		return retCodes;
	}

	/**
	 * 获取代码id.
	 * 
	 * @param list
	 *            代码集合
	 * @return 代码id集合
	 */
	private static List<String> getUserCodesId(List<ClientCode> list) {
		if (list == null) {
			list = new ArrayList<ClientCode>();
		}
		List<String> ids = new ArrayList<String>();
		for (ClientCode ele : list) {
			ids.add(ele.getCodeId());
		}
		return ids;
	}


	/**
	 * 获取用户本系统拥有的代码id.
	 * 
	 * @return 代码id集合
	 */
	public static List<ClientCode> getUserCodes(String codeIndexId) {
		LoginUser user = LoginUserContext.getCurrentLoginUser();
		LoginSystem system = user.getSystem();
		return system.getGlobalCodes().get(codeIndexId);
	}

	public static List<ClientCode> getUserCodes(String codeIndexId, String url) {
		if (StringUtils.hasText(url)) {
			LoginUser user = LoginUserContext.getCurrentLoginUser();
			LoginSystem system = user.getSystem();
			List<ClientCode> list = system.getSpecCodes().get(codeIndexId).get(url);
			if (list == null || list.size() == 0) {
				return system.getGlobalCodes().get(codeIndexId);
			}
			return list;
		} else {
			return getUserCodes(codeIndexId);
		}
	}

	// public static List<ClientCode> getUserCodes2(String codeIndexId) {
	// List<ClientCode> allCodes = new ArrayList<ClientCode>();
	// allCodes.add(createClientCode("c01", "p01", "c01", "c01"));
	// allCodes.add(createClientCode("c0101", "c01", "c0101", "c0101"));
	// allCodes.add(createClientCode("c010101", "c0101", "c010101", "c010101"));
	// allCodes.add(createClientCode("c0202", "c02", "c0202", "c0202"));
	// return allCodes;
	// }
	//
	// public static void main(String[] args) {
	// globalCodes = new HashMap<String, List<ClientCode>>();
	// List<ClientCode> allCodes = new ArrayList<ClientCode>();
	// allCodes.add(createClientCode("c01", "p01", "c01", "c01"));
	// allCodes.add(createClientCode("c02", "p01", "c02", "c02"));
	// allCodes.add(createClientCode("c0101", "c01", "c0101", "c0101"));
	// allCodes.add(createClientCode("c0102", "c01", "c0102", "c0102"));
	// allCodes.add(createClientCode("c0202", "c02", "c0202", "c0202"));
	// allCodes.add(createClientCode("c010101", "c0101", "c010101", "c010101"));
	// globalCodes.put("p01", allCodes);
	// // getTreeTemplate("p01");
	// System.out.println(getTreeTemplate("p01"));
	//
	// // System.out
	// //
	// .println("[{value:'c01',text:'c01',disabled:'true',child:[{value:'c0101',text:'c0101',disabled:'true',child:[{value:'c010101',text:'c010101',disabled:'true',},]},{value:'c0102',text:'c0102',disabled:'c0102_true',},]},{value:'c02',text:'c02',disabled:'c02_true',child:[{value:'c0202',text:'c0202',disabled:'true',},]},]"
	// // .replaceAll("disabled:'[\\w]*?_true'", ""));
	// }
	//
	// private static ClientCode createClientCode(String id, String pid, String
	// value, String name) {
	// ClientCode c1 = new ClientCode();
	// c1.setCodeId(id);
	// c1.setpCodeId(pid);
	// c1.setCodeValue(value);
	// c1.setCodeNameCn(name);
	// return c1;
	// }

}

