package myjava.sms;

import javax.jws.WebService;

import org.tempuri.SmsImplementationStub.DateTime;
import org.tempuri.SmsImplementationStub.PeriodTime;
import org.tempuri.SmsImplementationStub.PeriodType;
import org.tempuri.SmsImplementationStub.PeriodValue;

@WebService
public interface ISmsWebService {
	
	///短信发送
	public String SendMessage(String[] destinationAddresses,
	                       String Message,
	                       String externcode,
	                       String ApplicationID,
	                       String Password);

	 ///短信定时发送
	 public String SendMessage(String[] destinationAddresses,
	                    String message, 
	                    String extendCode,
	                    String applicationId, 
	                    String password,
	                    DateTime expectSendTime);

	 ///WapPush发送
	 public String SendWapPush(String[] destinationAddresses, 
	                       String message,String url, 
	                       String extendCode, 
	                       String applicationId, 
	                       String password);

	 ///WapPush定时发送
	 public String SendWapPush(String[] destinationAddresses, 
	                       String message,
	                       String url, 
	                       String extendCode, 
	                       String applicationId, 
	                       String password, 
	                       DateTime expectSendTime);
	 ///定时任务添加
	 public String AddTask(PeriodType periodType, 
	                   PeriodValue periodValue, 
	                   PeriodTime periodTime, 
	                   String[] destinationAddresses, 
	                   String message, 
	                   String extendCode, 
	                   String applicationId, 
	                   String password);

	 ///定时任务添加，含截至时间
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

	 ///任务删除
	 public void RemoveTask(String taskId);

}
