package cn.innosoft.en.releaseRecord.releaseManager.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import cn.innosoft.en.util.KSUtil;

@Service("MessageSenderService")
public class MessageSenderService {
	
	public Map<String, Object> senderRecogResult() {
		String datas = "";//KSUtil.getRecogResult();
		if(null==datas||"".equals(datas)){
			return null;
		}
		JSONObject jsonObject = new JSONObject(datas);
		
		String type = jsonObject.getString("type");//本条信息的类型，4种，lastface（识别中）、recognized、unrecognized、gone
    	
    	JSONObject dataObject = jsonObject.getJSONObject("data");// 算法识别的底层信息，无特殊需求的话不用处理，其中track为track id。只有当type为gone的时候，这里才包含年龄性别信息。
    	JSONObject data_status = dataObject.getJSONObject("status");// 对象
    	int track = dataObject.getInt("track");
    	double timestamp = dataObject.getDouble("timestamp");
    	JSONObject data_face = dataObject.getJSONObject("face");// 对象
    	String data_face_image = data_face.getString("image");
    	JSONObject data_face_rect = data_face.getJSONObject("rect");// 对象
    	JSONObject data_person = dataObject.getJSONObject("person");// 对象
    	double quality = dataObject.getDouble("quality");
    	
    	
    	JSONObject screenObject = jsonObject.getJSONObject("screen");// 识别位置的信息，只有type不为gone时才会有
    	
    	
    	JSONObject personObject = jsonObject.getJSONObject("person");// 和底库里相似的人，只有type为recognized时才会有
    	String ksId = personObject.getString("id");
    	
    	String error = jsonObject.getString("error");// 如果open_door为false，这个字段就是不能开门的原因
    	boolean open_door = jsonObject.getBoolean("open_door");// 是否开门，只有type为recognized时才会有
    	
		return null;
	}
}
