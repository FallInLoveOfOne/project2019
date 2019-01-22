package myjava.sms;

import java.util.Calendar;

import com.chinamobile.openmas.client.Mms;
import com.chinamobile.openmas.entity.MmsMessage;
import com.chinamobile.openmas.entity.PeriodTime;
import com.chinamobile.openmas.entity.PeriodType;
import com.chinamobile.openmas.entity.PeriodValue;
import com.chinamobile.openmas.tools.MmsBuilder;
import com.chinamobile.openmas.tools.MmsConst;
import com.chinamobile.openmas.tools.MmsContent;

public class OpenMasMmsTestTemp {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		  {
			  //����
			  Mms mms = new Mms("http://127.0.0.1:9090/openmasservice"); //���Žӿڵ�ַ
			  String[] destinationAddresses = new String[]{"13700000000"};//���Ͷ���11�����ֻ�����
			  String subject="���Ų���";//���ű���
			  String extendCode = "0101"; //�Զ�����չ�루ģ�飩������Ϊ�գ�����ʾ���ֻ��ն����ź���ĩλ��ע�����ź����ܳ��Ȳ��ܳ���20λ
			  String ApplicationID= "default";//Ӧ���˺�
			  String Password = "default";//Ӧ������
			  MmsContent mmsContent = MmsContent.CreateFromFile("1.gif");
			  MmsBuilder body = new MmsBuilder();//��������
			  body.AddContent(mmsContent);
			  mmsContent = MmsContent.CreateFromBytes("���".getBytes());
			  mmsContent.setCharset("gb2312");
			  mmsContent.setContentID("2");
			  mmsContent.setContentType(MmsConst.TEXT);
			  body.AddContent(mmsContent);
			  String content = body.BuildContentToXml();
		
			  String GateWayid ="";
			  //���Ͳ��� ������
			  GateWayid = mms.SendMessage(destinationAddresses, subject,content, extendCode, ApplicationID, Password);
			  System.out.println(GateWayid);
			  
			  //���Ͳ��� ������
			  //���ö�ʱʱ��
			  Calendar expectSendTime = Calendar.getInstance();
			  expectSendTime.add(Calendar.MINUTE, 5);
			  GateWayid = mms.SendMessage(destinationAddresses,subject, content, extendCode, ApplicationID, Password, expectSendTime);
			  System.out.println(GateWayid);
			  
			  
			  //��ʼʱ��01-01 - ����ʱ��12-31
			  Calendar beginTime = Calendar.getInstance();
			  beginTime.set(Calendar.MONTH, 0);
			  beginTime.set(Calendar.DAY_OF_MONTH,1);
			  Calendar endTime = Calendar.getInstance();
			  endTime.set(Calendar.MONTH, 11);
			  endTime.set(Calendar.DAY_OF_MONTH,31);
			  //��ʱ ÿ�µ�7�� 10:12:11
			  PeriodValue  periodValue = new PeriodValue();
			  periodValue.setDay(7);
			  PeriodTime periodTime = new PeriodTime();
			  periodTime.setHour(10);
			  periodTime.setMinute(12);
			  periodTime.setSecond(11);
			  
			 
			  //��ʱ���� ������
			  GateWayid=mms.AddTask(PeriodType.Month, periodValue, periodTime, destinationAddresses, subject,content, extendCode, ApplicationID, Password, beginTime, endTime);
			  System.out.println(GateWayid);
			 
			  //��ʱ���� ������
			  GateWayid = mms.AddTask(PeriodType.Month, periodValue, periodTime, destinationAddresses,subject, content, extendCode, ApplicationID, Password);
			  System.out.println(GateWayid);
			  
			  //ɾ����ʱ ����һ
			  mms.RemoveTask(GateWayid);
			  //ɾ����ʱ ������
			  mms.RemoveTask(GateWayid, Password);
			  
			  //��ȡ���в��� ����һ
			  String MessageID = "02e2021b-e544-45df-87f0-192c96083826";
			  // ���ŵ�MessageID��ȡ��ʽ��
			  // 1.�ͻ���������ʦ����Ŀ�п���WebService�ӿ�
			  // 2.OpenMAS�������WebServcie�ӿڣ���MessageIDͨ�������ķ�ʽ���ݸ�Ӧ��ϵͳ
			  // 3.Ӧ��ϵͳͨ����MessageIDȥ��ȡ������Ϣ
			  // ע�⣺��MessageID���Ƿ��Ͷ����Ƿ��ص�ID
			  MmsMessage mo = mms.GetMessage(MessageID);
			  if(mo !=null)
				  System.out.println(mo.toString());
			  
		  }catch(Exception ex)
		  {
			  System.err.println(ex);
		  }
		  System.exit(0);

	}

}
