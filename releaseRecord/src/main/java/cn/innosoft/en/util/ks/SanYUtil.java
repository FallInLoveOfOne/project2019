package cn.innosoft.en.util.ks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import cn.innosoft.en.util.PropsUtil;
import cn.innosoft.en.util.Util;

@SuppressWarnings("deprecation")
public class SanYUtil {
	
	/**
	 * 处理get请求.
	 * 
	 * @param url
	 *            请求路径
	 * @return json
	 */
	public static String httpGet(String url) {
		CloseableHttpClient httpClient = new DefaultHttpClient();
		// 实例化get方法
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("Accept", "application/json");
		httpget.setHeader("Content-Type", "application/json;charset=utf-8");
//		httpget.setHeader("user-agent", "Koala Admin");
		// 请求结果
		CloseableHttpResponse response = null;
		String content = "";
		try {
			// 执行get方法
			response = httpClient.execute(httpget);
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "utf-8");
//				System.out.println(content);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
	
	/**
	 * GET请求
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		String result = "";
		String line = "";
		StringBuffer sb = new StringBuffer();
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
//			uc.setConnectTimeout(5000);
			uc.setRequestProperty("accept", "application/json");
//			uc.setRequestProperty("connection", "Keep-Alive");
//			uc.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			uc.setDoInput(true);
			uc.setRequestProperty("Accept-Charset", "UTF-8");
			uc.setRequestProperty("contentType", "application/json;charset=utf-8");
			uc.setDoOutput(true);
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));

			while ((line = in.readLine()) != null) {
				sb.append(line);// 此处获得即为跨域访问的返回值，这次测试获取的是JSON格式的字串
			}

			in.close();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
		}

		result = new String(sb);
		return result;
	}
	
	
	
	
	/**
	 * 获取戒毒人员接口
	 * @return
	 */
	public static String getAllPerson() {
//		String url = "http://10.118.5.86:8380/jc/prisoner/findAllDetoxPeopleInfo?prisonId=330301131&size=1000";
		String url = PropsUtil.getValue("sanyangIp")+"/jc/prisoner/findAllDetoxPeopleInfo?prisonId="+PropsUtil.getValue("prisonId")+"&size=8888888";
		String data = httpGet(url);
		return data;
	}
	
	
	/**
	 * 获取单个戒毒人员信息
	 * @param number
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String getOneInfo(String number) throws UnsupportedEncodingException {
//		String url = "http://10.118.5.86:8380/jc/prisoner/findAllDetoxPeopleInfo?prisonId=330301131&number="+URLEncoder.encode(Util.isEmpt(number),"UTF-8");
//		String url = "http://10.118.5.86:8380/jc/prisoner/findAllDetoxPeopleInfo?prisonId=330301131&number=330301131201808050001";
		String url = PropsUtil.getValue("sanyangIp")+"/jc/prisoner/findAllDetoxPeopleInfo?prisonId="+PropsUtil.getValue("prisonId")+"&number="+URLEncoder.encode(Util.isEmpt(number),"UTF-8"); 
		String data = httpGet(url); 
		return data;
	}
	
	/**
	 * 获取戒毒人员头像字符串
	 * @param number
	 * @return
	 */
	public static byte[] getPersonPhoto(String number) {
//		String url = "http://10.118.5.86:8380/jc/prisoner/findPhotoByNumber?prisonId=330301131&number=330301131201808050001";
		String url = PropsUtil.getValue("sanyangIp")+"/jc/prisoner/findPhotoByNumber?prisonId="+PropsUtil.getValue("prisonId")+"&number="+number;
		String data = httpGet(url);
		data = data.replaceAll("\"", "");// 去除多余字符
		return data.getBytes();
	}
	
	/**
	 * 获取工作人员的出所流程状态
	 * @param number
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getProcessState(String number) throws UnsupportedEncodingException {
		String data = getOneInfo(number);
		if("".equals(data)||null==data){// 结果可能为空
			return null;
		}
		JSONObject jsonObject = new JSONObject(data);
		int total = jsonObject.getInt("total");
		JSONArray dataArray = jsonObject.getJSONArray("list");
		if(total>0){
			for (int key=0;key<dataArray.length();key++) {
				JSONObject object = dataArray.getJSONObject(key);
				String processState = object.getString("processState");
				if(!"".equals(processState)&&null!=processState){// 取得含有processState字段的该条数据
					return processState;
				}
			}
		}
		return null;
	}

}
