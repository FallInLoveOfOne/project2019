package myjava.sms;


import java.rmi.RemoteException;

import com.chinamobile.openmas.client.Sms;

public class Test {
	
	public static void main(String[] args) throws RemoteException {
		/*Sms sms = SmsProvider.getSms();
		String[] destinationAddresses = new String[] { "18767090630" };
		String message = "������Ϣ";
		String GateWayid = sms.SendMessage(destinationAddresses, message, extendCodeSmsProvider.EXTENDCODE, SmsProvider.APPLICATIONID, SmsProvider.PASSWORD);
		System.out.println("sendmessageId**********" + GateWayid);*/
		try {
			Sms sms = new Sms("http://hz009.openmas.net:9080/OpenMasService");//���Žӿڵ�ַ
			String[] destinationAddresses = new String[] { "18767090630" };//���Ͷ���11�����ֻ�����
			String message = "3435dsfdsfds���ŵ�˵��%%%88***";//��������
			String extendCode = "2"; //�Զ�����չ�루ģ�飩������Ϊ�գ�����ʾ���ֻ��ն����ź���ĩλ��ע�����ź����ܳ��Ȳ��ܳ���20λ
			String ApplicationID = "8027002";//Ӧ���˺�
			String Password = "uepKATiRTLy8";//Ӧ������
			
			// ���Ͷ��� ������
			String GateWayid = "";
			GateWayid = sms.SendMessage(destinationAddresses, message,
					extendCode, ApplicationID, Password);
			System.out.println(GateWayid);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

}
