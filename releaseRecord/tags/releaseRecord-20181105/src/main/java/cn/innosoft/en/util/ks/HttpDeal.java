package cn.innosoft.en.util.ks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.innosoft.en.util.EnUtil;
import cn.innosoft.en.util.ImageUtil;
import cn.innosoft.en.util.Util;

/**
 * 请求
 * @author sh
 *
 */
public class HttpDeal {

	private final static HttpClientContext CONTEXT = HttpClientContext.create();
	
	private final static CloseableHttpClient HTTPCLIENT;

	static {
		CookieStore cookieStore = new BasicCookieStore();
		BasicClientCookie cookie = new BasicClientCookie("name", UUID
				.randomUUID().toString());
		cookie.setVersion(0);
		cookie.setDomain("/pms/"); // 设置范围
		cookie.setPath("/");
		cookieStore.addCookie(cookie);
		HTTPCLIENT = HttpClients.custom().setDefaultCookieStore(cookieStore)
				.build();
	}

	/**
	 * 处理get请求.
	 * 
	 * @param url
	 *            请求路径
	 * @return json
	 */
	public static String get(String url) {
		// 实例化get方法
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("Accept", "application/json");
		httpget.setHeader("user-agent", "Koala Admin");
		// 请求结果
		CloseableHttpResponse response = null;
		String content = "";
		try {
			// 执行get方法
			response = HTTPCLIENT.execute(httpget, CONTEXT);
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "utf-8");
//				System.out.println(content);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*try {
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
			}*/
		}
		return content;
	}

	/**
	 * 处理post请求.
	 * 
	 * @param url
	 *            请求路径
	 * @param params
	 *            参数
	 * @return json
	 */
	public static String post(String url, Map<String, String> params) {
		// 实例化post方法
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("user-agent", "Koala Admin");
		// 处理参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}
		// 结果
		CloseableHttpResponse response = null;
		String content = "";
		try {
			// 提交的参数
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps,
					"UTF-8");
			// 将参数给post方法
			httpPost.setEntity(uefEntity);
			// 执行post方法
			response = HTTPCLIENT.execute(httpPost, CONTEXT);
			if (response.getStatusLine().getStatusCode() == 200) {
				content = EntityUtils.toString(response.getEntity(), "utf-8");
//				System.out.println("结果" + content);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/*try {
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
			}*/
		}
		return content;
	}
	
	/**
	 * 上传识别照片
	 * @param url
	 * @param subId
	 * @return
	 */
	public static String upFacePhoto(String url,String subId,String photoPath) {
		String respData = "";
		//CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			//httpClient = HttpClients.createDefault();
			// 把一个普通参数和文件上传给下面这个地址 是一个servlet
			HttpPost httpPost = new HttpPost(url);

			// 把文件转换成流对象FileBody
			FileBody bin = new FileBody(new File(photoPath));
			StringBody subjectId = new StringBody(subId, ContentType.create(
					"text/plain", Consts.UTF_8)); 

			HttpEntity reqEntity = MultipartEntityBuilder.create()
					// 相当于<input type="file" name="file"/>
					.addPart("photo", bin).addPart("subject_id", subjectId).build();
					// 相当于<input type="text" name="userName" value=userName>
					//.addPart("userName", userName).addPart("pass", password)
					//.build();

			httpPost.setEntity(reqEntity);

			// 发起请求 并返回请求的响应
			response = HTTPCLIENT.execute(httpPost,CONTEXT);

			// 获取响应对象
			HttpEntity resEntity = response.getEntity();
			if (resEntity != null) {
				// 打印响应长度
				// 打印响应内容
				respData = EntityUtils.toString(resEntity,
						Charset.forName("UTF-8"));
			}

			// 销毁
			EntityUtils.consume(resEntity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*try {
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
			}*/
		}
		return respData;
	}
	
	/**
	 * delete 请求
	 * @param id
	 * @return
	 */
	public static String delete(String url,Map<String,String> headers/*,String encode*/) {
//		HttpResponse response = new HttpResponse();  
        /*if(encode == null){    
            encode = "utf-8";    
        }*/    
        String content = null;    
        //since 4.3 不再使用 DefaultHttpClient    
//        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();     
        HttpDelete httpdelete = new HttpDelete(url);    
        //设置header  
        if (headers != null && headers.size() > 0) {  
            for (Map.Entry<String, String> entry : headers.entrySet()) {  
                httpdelete.setHeader(entry.getKey(),entry.getValue());  
            }  
        }  
        CloseableHttpResponse httpResponse = null;    
        try {    
            httpResponse = HTTPCLIENT.execute(httpdelete,CONTEXT);    
            HttpEntity entity = httpResponse.getEntity();    
            content = EntityUtils.toString(entity, Charset.forName("UTF-8"));    
            /*response.setBody(content);  
            response.setHeaders(httpResponse.getAllHeaders());  
            response.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());  
            response.setStatusCode(httpResponse.getStatusLine().getStatusCode());*/  
        } catch (Exception e) {    
            e.printStackTrace();    
        }finally {
			/*try {
				if (httpResponse != null) {
					httpResponse.close();
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
			}*/
		}      
        return content;    
	}
	
	/**
	 * 1:1静态识别
	 * @param url
	 * @param subId
	 * @param photoPath
	 * @return
	 */
	public static String sbOne2one(String url,String subId,String photoPath) {
		String respData = "";
		//CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			//httpClient = HttpClients.createDefault();
			// 把一个普通参数和文件上传给下面这个地址 是一个servlet
			HttpPost httpPost = new HttpPost(url);
			// 把文件转换成流对象FileBody
			FileBody bin = new FileBody(new File(photoPath));
			StringBody subjectId = new StringBody(subId, ContentType.create(
					"text/plain", Consts.UTF_8)); 
			HttpEntity reqEntity = MultipartEntityBuilder.create()
					// 相当于<input type="file" name="file"/>
					.addPart("image", bin).addPart("person_id", subjectId).build();
					// 相当于<input type="text" name="userName" value=userName>
			httpPost.setEntity(reqEntity);
			// 发起请求 并返回请求的响应
			response = HTTPCLIENT.execute(httpPost,CONTEXT);
			// 获取响应对象
			HttpEntity resEntity = response.getEntity();
			if (resEntity != null) {
				// 打印响应长度
				// 打印响应内容
				respData = EntityUtils.toString(resEntity,
						Charset.forName("UTF-8"));
			}
			// 销毁
			EntityUtils.consume(resEntity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return respData;
	}
	
	/**
	 * 获取输入流
	 * @param urlPath
	 * @return
	 */
	public static InputStream getInputStream(String urlPath){
		InputStream inputStream=null;
		HttpURLConnection httpURLConnection=null;
		try{
		URL url=new URL(urlPath);
		if(url!=null){
		httpURLConnection =(HttpURLConnection)url.openConnection();
		//设置连接网络超时时间
		httpURLConnection.setConnectTimeout(3000);
		httpURLConnection.setDoInput(true);
		//表示设置本次http请求使用的GET方式请求
		httpURLConnection.setRequestMethod("GET");
		int responseCode=httpURLConnection.getResponseCode();
		if(responseCode==200){
		//从服务器中获得一个输入流
		inputStream=httpURLConnection.getInputStream();
		}
		}
		}catch(MalformedURLException e){
		e.printStackTrace();
		}catch(IOException e){
		e.printStackTrace();
		}
		return inputStream;
	}
	
	/**
	 * 保留在本地
	 * @param url
	 */
	public static void saveImage(String url,String path){
		InputStream inputStream=getInputStream(url);
		byte[] data=new byte[1024];
		int len=0;
		FileOutputStream fileoutputStream =null;
		try{
		fileoutputStream=new FileOutputStream(path);
		while((len=inputStream.read(data))!=-1){
		fileoutputStream.write(data,0,len);
		}
		}catch(IOException e){
		e.printStackTrace();
		}finally{
		if(inputStream!=null){
		try{
		inputStream.close();
		}catch(IOException e){
		e.printStackTrace();
		}
		}
		}
	}
	
	public static String getContentByUrl(String url) {
		String result = "";

		String line = "";

		StringBuffer sb = new StringBuffer();

		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
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

				// 此处获得即为跨域访问的返回值，这次测试获取的是JSON格式的字串
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
	 * put请求
	 * @param url
	 * @param stringJson
	 * @param headers
	 * @param encode
	 * @return
	 */
	public static String httpPut(String url,String stringJson,Map<String,String> headers, String encode){  
        if(encode == null){  
            encode = "utf-8";  
        }  
        HttpPut httpput = new HttpPut(url);
        //设置header
        httpput.setHeader("Accept", "application/json");
        httpput.setHeader("Content-type", "application/json");    
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpput.setHeader(entry.getKey(),entry.getValue());
            }
        }
        //组织请求参数  
        StringEntity stringEntity = new StringEntity(stringJson, encode);  
        httpput.setEntity(stringEntity);  
        /* map形式提交参数 2018-10-10
        
        Map<String,String> params = null;
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		} 
		// 提交的参数
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps,"UTF-8");
		httpput.setEntity(uefEntity);	
          
        */
        String content = null;  
        CloseableHttpResponse  httpResponse = null;  
        try {  
            //响应信息
            httpResponse = HTTPCLIENT.execute(httpput,CONTEXT);  
            content = EntityUtils.toString(httpResponse.getEntity(), encode/*"utf-8"*/); 
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{
        	/*try {
			if (httpResponse != null) {
				httpResponse.close();
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
			}*/
        	
        }  
        return content;  
    }
	

	public static void main(String[] args) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "sanyang@megvii.com");
		map.put("password", "123456");
		// 登录
//		post("http://41.213.199.239/auth/login", map);

		// 获取识别记录
		// String queryCon =
		// "?start=&end=&user_role=0&user_name=&screen_id=&subject_id=45&page=1&size=10";
		// subject_id=45,subject_id=57(测试使用)
		/*String queryCon = "?subject_id=57";
		String bdData = get("http://41.213.199.239/event/events" + queryCon);
		Map<String, Object> bdMap = JsonUtils.parseJsonToMap(bdData);
		String code = bdMap.get("code").toString();// 0
		String sbJson = bdMap.get("data").toString();// []:标识无识别记录，
		String sb = sbJson.substring(sbJson.indexOf("{"),
				sbJson.indexOf("}") + 1);
		Map<String, Object> sbMap = JsonUtils.parseJsonToMap(sb);
		System.out.println("识别记录：" + bdData);*/

		// 添加
		/*Map<String, String> addMap = new HashMap<String, String>();
		addMap.put("name", "吸毒人员");
		addMap.put("job_number", "977");
		addMap.put("avatar",
				ImageUtil.GetImageStr("D:/abiubiu/20180913145946143.jpg"));
		addMap.put("gender", "1");
		addMap.put("subject_type", "1");
		addMap.put("start_time", "2018223345");
		addMap.put("end_time", "2018223345");
		addMap.put("entry_date", "2018");
		String data = post("http://41.213.199.239/subject", addMap);
		System.out.println("添加的人员信息："+data);*/
		
		// 上传识别头像（id:57,58）
		/*String url = "http://41.213.199.239/subject/photo";
		String id = "57";
		String photoPath = "D:/abiubiu/20180913145946143.jpg";
		String respData = upFacePhoto(url,id,photoPath);
		System.out.println("识别头像响应信息："+respData);*/
		
		// 删除用户
//		System.out.println("删除结果："+delete("http://41.213.199.239/subject/138",null));// 138
		
//		System.out.println("获取get请求结果:"+get("http://10.118.5.86:8380/jc/prisoner/findPhotoByNumber?prisonId=330301131&number=330301131201808050001"));
		String dataString = HttpDeal.get("http://10.118.5.86:8380/jc/prisoner/findPhotoByNumber?prisonId=330301131&number=330301131201808050001");
//		String dataString2 = "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";
		dataString = dataString.replaceAll("\"", "");
		dataString = new String(dataString.getBytes());
		dataString = dataString.replaceAll("\"", "");
		dataString = dataString.replaceAll("\"", "");
//		System.out.println("直接拷贝base64："+dataString2);
//		System.out.println("get获取base64："+dataString);
//		System.out.println("字符串比较："+dataString2.equals(dataString));
		String pathString = "D:/ccc/"+Util.getCurTimeUUID()+".jpg";
		EnUtil.createFile(pathString);
		ImageUtil.GenerateImage(dataString, pathString);

	}

}
