package myjava.sms;

import javax.jws.WebService;

import org.tempuri.SmsImplementationStub.DateTime;
import org.tempuri.SmsImplementationStub.PeriodTime;
import org.tempuri.SmsImplementationStub.PeriodType;
import org.tempuri.SmsImplementationStub.PeriodValue;

@WebService
public interface ISmsWebService {
	
	///���ŷ���
	public String SendMessage(String[] destinationAddresses,
	                       String Message,
	                       String externcode,
	                       String ApplicationID,
	                       String Password);

	 ///���Ŷ�ʱ����
	 public String SendMessage(String[] destinationAddresses,
	                    String message, 
	                    String extendCode,
	                    String applicationId, 
	                    String password,
	                    DateTime expectSendTime);

	 ///WapPush����
	 public String SendWapPush(String[] destinationAddresses, 
	                       String message,String url, 
	                       String extendCode, 
	                       String applicationId, 
	                       String password);

	 ///WapPush��ʱ����
	 public String SendWapPush(String[] destinationAddresses, 
	                       String message,
	                       String url, 
	                       String extendCode, 
	                       String applicationId, 
	                       String password, 
	                       DateTime expectSendTime);
	 ///��ʱ�������
	 public String AddTask(PeriodType periodType, 
	                   PeriodValue periodValue, 
	                   PeriodTime periodTime, 
	                   String[] destinationAddresses, 
	                   String message, 
	                   String extendCode, 
	                   String applicationId, 
	                   String password);

	 ///��ʱ������ӣ�������ʱ��
	 public String AddTask(PeriodType periodType, 
	                   PeriodValue periodValue, 
	                   PeriodTime periodTime, 
	                   String[] destinationAddresses, 
	                   String message, 
	                   String extendCode, 
	                   String applicationId, 
	                   String password, 
	                   DateTime beginTime, 
	                   DateTime endTime);

	 ///����ɾ��
	 public void RemoveTask(String taskId);

}
