package myjava.sms;


import java.rmi.RemoteException;

import com.chinamobile.openmas.client.Sms;

public class Test {
	
	public static void main(String[] args) throws RemoteException {
		/*Sms sms = SmsProvider.getSms();
		String[] destinationAddresses = new String[] { "18767090630" };
		String message = "测试信息";
		String GateWayid = sms.SendMessage(destinationAddresses, message, extendCodeSmsProvider.EXTENDCODE, SmsProvider.APPLICATIONID, SmsProvider.PASSWORD);
		System.out.println("sendmessageId**********" + GateWayid);*/
		try {
			Sms sms = new Sms("http://hz009.openmas.net:9080/OpenMasService");//短信接口地址
			String[] destinationAddresses = new String[] { "18767090630" };//发送对象：11数字手机号码
			String message = "3435dsfdsfds发放的说法%%%88***";//短信内容
			String extendCode = "2"; //自定义扩展码（模块），可以为空，将显示在手机终端来信号码末位，注：来信号码总长度不能超过20位
			String ApplicationID = "8027002";//应用账号
			String Password = "uepKATiRTLy8";//应用密码
			
			// 发送短信 方法三
			String GateWayid = "";
			GateWayid = sms.SendMessage(destinationAddresses, message,
					extendCode, ApplicationID, Password);
			System.out.println(GateWayid);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

}
