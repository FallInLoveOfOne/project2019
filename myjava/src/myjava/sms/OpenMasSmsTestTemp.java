package myjava.sms;

import java.util.*;

import com.chinamobile.openmas.client.*;
import com.chinamobile.openmas.entity.*;

public class OpenMasSmsTestTemp {
	public static void main(String[] args) {
		try {
			// ����
			Sms sms = new Sms("http://127.0.0.1:9080/OpenMasService");//���Žӿڵ�ַ
			String[] destinationAddresses = new String[] { "13700000000" };//���Ͷ���11�����ֻ�����
			String message = "���Ų���";//��������
			String extendCode = "0101"; //�Զ�����չ�루ģ�飩������Ϊ�գ�����ʾ���ֻ��ն����ź���ĩλ��ע�����ź����ܳ��Ȳ��ܳ���20λ
			String ApplicationID = "default";//Ӧ���˺�
			String Password = "default";//Ӧ������
			
			// ���Ͷ��� ������
			String GateWayid = "";
			GateWayid = sms.SendMessage(destinationAddresses, message,
					extendCode, ApplicationID, Password);
			System.out.println(GateWayid);

			// ���Ͷ��� ������ ��ʱ����
			// ���ö�ʱʱ��
			Calendar expectSendTime = Calendar.getInstance();
			expectSendTime.add(Calendar.MINUTE, 5);
			GateWayid = sms.SendMessage(destinationAddresses, message,
					extendCode, ApplicationID, Password, expectSendTime);
			System.out.println(GateWayid);

			// ��ʼʱ��01-01 - ����ʱ��12-31
			Calendar beginTime = Calendar.getInstance();
			beginTime.set(Calendar.MONTH, 0);
			beginTime.set(Calendar.DAY_OF_MONTH, 1);
			Calendar endTime = Calendar.getInstance();
			endTime.set(Calendar.MONTH, 11);
			endTime.set(Calendar.DAY_OF_MONTH, 31);
			// ��ʱ ÿ�µ�7�� 10:12:11
			PeriodValue periodValue = new PeriodValue();
			periodValue.setDay(7);
			PeriodTime periodTime = new PeriodTime();
			periodTime.setHour(10);
			periodTime.setMinute(12);
			periodTime.setSecond(11);

			// ��ʱ���� ������ ����ʼ����ֹʱ��
			GateWayid = sms.AddTask(PeriodType.Month, periodValue, periodTime, destinationAddresses, message, extendCode, ApplicationID,Password, beginTime, endTime);
			System.out.println(GateWayid);

			// ��ʱ���� ������
			GateWayid = sms.AddTask(PeriodType.Month, periodValue, periodTime, destinationAddresses, message, extendCode, ApplicationID,Password);
			System.out.println(GateWayid);

			// ɾ����ʱ ����
			sms.RemoveTask(GateWayid);

			// ��ȡ���ж���
			String MessageID = "02e2021b-e544-45df-87f0-192c96083826";
			// ���ŵ�MessageID��ȡ��ʽ��
			// 1.�ͻ���������ʦ����Ŀ�п���WebService�ӿ�
			// 2.OpenMAS�������WebServcie�ӿڣ���MessageIDͨ�������ķ�ʽ���ݸ�Ӧ��ϵͳ
			// 3.Ӧ��ϵͳͨ����MessageIDȥ��ȡ������Ϣ
			// ע�⣺��MessageID���Ƿ��Ͷ����Ƿ��ص�ID
			SmsMessage mo = sms.GetMessage(MessageID);
			if (mo != null)
				System.out.println(mo.toString());
		} catch (Exception ex) {
			System.err.println(ex);
		}
		System.exit(0);// ������������
	}

}
