package myjava.sms;

import org.apache.axis2.AxisFault;

import com.chinamobile.openmas.client.Sms;
import com.chinamobile.openmas.entity.SmsMessage;

/**
 * Title: SmsProvider.java<br>
 * Description: ���Žӿڻ�ȡ<br>
 * Copyright (c) �ڴ���Ϣ��Ȩ���� 2012	<br>
 * Create DateTime: Jun 6, 2012 9:52:29 AM <br>
 * @author ln
 */
public class SmsProvider {

	private static Sms SMS;
	public static final String EXTENDCODE = "2";// 扩展�?
	public static final String APPLICATIONID = "8027002";// "8001001";
	public static final String PASSWORD = "uepKATiRTLy8";// "123456";
	private static final String WEBSERVICE_URL = "http://hz009.openmas.net:9080/OpenMasService";// "http://127.0.0.1:9080/OpenMasService";

	//��ʼ�����Žӿ�
	static {
		try {
			SMS = new Sms(WEBSERVICE_URL);
		} catch (AxisFault e) {
			//TODO �����־���?
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���Žӿ�
	 * @return ���ض���Mms
	 */
	public static Sms getSms() {
		if (SMS == null) {
			throw new RuntimeException("SMS init failure");
		}
		return SMS;
	}

	/**
	 * ��ȡ��������
	 * @param messageId
	 * @return
	 */
	public static SmsMessage getMmsMessage(String messageId) {
		return getSms().GetMessage(messageId);
	}
}
