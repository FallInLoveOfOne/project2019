package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Http������
 * 
 * @author sh
 *
 */
public class HttpUtil {

	/**
	 * GET
	 * 
	 * @param baseURL������url��
	 * @param params������map��
	 * @param charset���������ͣ�
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String baseURL,Map<String, String> params,String charset/*String baseUrl, String param, String charset*/) throws Exception {
		/*if (null == baseUrl || "".equals(baseUrl)) {
			return "";
		}
		charset = (null == charset || "".equals(charset) ? "UTF-8" : charset);
		String requestUrl = baseUrl + "?" + param;
		String line = "";
		StringBuffer sb = new StringBuffer();
		URL url = new URL(requestUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		in.close();
		return sb.toString();*/
		/******************************/
		charset = (null == charset || "".equals(charset) ? "UTF-8" : charset);
		String url = baseURL+"?"+getParams(params, charset);
		return getContentByUrl(url,"GET");
		
	}

	/**
	 * POST
	 * 
	 * @param baseURL������url��
	 * @param params������map��
	 * @param charset�������ʽ��
	 * @return
	 */
	public static String doPost(String baseURL,Map<String, String> params,String charset/*String baseUrl, String params, String charset*/) throws Exception {
		/*OutputStreamWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		URL url = new URL(baseUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		// ����POST�����������Ϊtrue
		conn.setDoOutput(true);
		conn.setDoInput(true);
		// �������ӳ�ʱʱ��Ͷ�ȡ��ʱʱ��
		conn.setConnectTimeout(10000);
		conn.setReadTimeout(10000);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		out = new OutputStreamWriter(conn.getOutputStream());
		// POST���������д��������
		out.write(params);
		out.flush();
		out.close();
		conn.connect();
		// ȡ������������ʹ��Reader��ȡ
		in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String line;
		while ((line = in.readLine()) != null) {
			result.append(line);
		}
		return result.toString();*/
		charset = (null == charset || "".equals(charset) ? "UTF-8" : charset);
		String url = baseURL+"?"+getParams(params, charset);
		return getContentByUrl(url,"POST");
	}
	
	
	/*************************************************/
	
	/**
	 * ͨ�ÿ�������
	 * @param url��url��ַ��
	 * @param type���������ͣ�
	 * @return
	 */
	public static String getContentByUrl(String url,String type) {
		String result = "";

		String line = "";

		StringBuffer sb = new StringBuffer();

		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			if("GET".equals(type)){
				uc.setDoInput(false);
			}
			if("POST".equals(type)){
				uc.setDoInput(true);
			}
			uc.setConnectTimeout(5000);
			uc.setRequestProperty("accept", "*/*");
			uc.setRequestProperty("connection", "Keep-Alive");
			uc.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			uc.setDoInput(true);
			uc.setRequestProperty("Accept-Charset", "UTF-8");
			uc.setRequestProperty("contentType", "UTF-8");
			uc.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));

			while ((line = in.readLine()) != null) {

				sb.append(line);

				// �˴���ü�Ϊ������ʵķ���ֵ����β��Ի�ȡ����JSON��ʽ���ִ�
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
	 * ��ȡURL��ѯ����
	 * @param params������map��
	 * @param charset�������ʽ��
	 * @return
	 * @throws Exception
	 */
	public static String getParams(Map<String, String> params,String charset) throws Exception {
		charset = (null==charset||"".equals(charset)?"UTF-8":charset);//Ĭ��UTF-8����
		String where = "";
		if(null==params){
			return "";
		}
		Set<Map.Entry<String, String>> sets = params.entrySet();
		if(null==sets){
			return "";
		}
		for(Map.Entry<String, String> entry : sets){
			String key = entry.getKey();
			String value = URLEncoder.encode(entry.getValue(), charset);
			where = where+key+"="+value+"&";
			System.out.println(key+"---"+value);
		}
		where = where.substring(0, where.length()-1);
		return where;
	}
	
	/**
	 * ��������
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String url = "http://www.tyyq.cn/webapi/api/JMaininfo/SMainInfo?isxml=false&query={\"Fields\":\"_id,title,siteid,pagedate,mediaid,url\",\"CurPage\":\"1\",\"PageSize\":\"10\",\"KeyWord\":\"\",\"SearchRange\":1,\"UnitId\":1,\"StartTime\":\"\",\"EndTime\":\"\",\"MediaIds\":[8,9],\"OrderInt\":1}";
		System.out.println("ͨ������"+getContentByUrl(url,"GET"));
		String baseUrl = "http://www.tyyq.cn/webapi/api/JMaininfo/SMainInfo";
		Map<String, String> map = new HashMap<String, String>();
		map.put("isxml", "false");
		map.put("query", "{\"Fields\":\"_id,title,siteid,pagedate,mediaid,url\",\"CurPage\":\"1\",\"PageSize\":\"10\",\"KeyWord\":\"�ձ�\",\"SearchRange\":1,\"UnitId\":1,\"StartTime\":\"\",\"EndTime\":\"\",\"MediaIds\":[8,9],\"OrderInt\":1}");
		//System.out.println(getParams(map,"UTF-8"));
		System.out.println("GET����:"+doGet(baseUrl, map, "UTF-8"));
		System.out.println("POST����:"+doPost(baseUrl, map, null));
	}

}
