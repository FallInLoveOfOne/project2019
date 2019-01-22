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
			  //彩信
			  Mms mms = new Mms("http://127.0.0.1:9090/openmasservice"); //彩信接口地址
			  String[] destinationAddresses = new String[]{"13700000000"};//发送对象：11数字手机号码
			  String subject="彩信测试";//彩信标题
			  String extendCode = "0101"; //自定义扩展码（模块），可以为空，将显示在手机终端来信号码末位，注：来信号码总长度不能超过20位
			  String ApplicationID= "default";//应用账号
			  String Password = "default";//应用密码
			  MmsContent mmsContent = MmsContent.CreateFromFile("1.gif");
			  MmsBuilder body = new MmsBuilder();//构建彩信
			  body.AddContent(mmsContent);
			  mmsContent = MmsContent.CreateFromBytes("你好".getBytes());
			  mmsContent.setCharset("gb2312");
			  mmsContent.setContentID("2");
			  mmsContent.setContentType(MmsConst.TEXT);
			  body.AddContent(mmsContent);
			  String content = body.BuildContentToXml();
		
			  String GateWayid ="";
			  //发送彩信 方法三
			  GateWayid = mms.SendMessage(destinationAddresses, subject,content, extendCode, ApplicationID, Password);
			  System.out.println(GateWayid);
			  
			  //发送彩信 方法四
			  //设置定时时间
			  Calendar expectSendTime = Calendar.getInstance();
			  expectSendTime.add(Calendar.MINUTE, 5);
			  GateWayid = mms.SendMessage(destinationAddresses,subject, content, extendCode, ApplicationID, Password, expectSendTime);
			  System.out.println(GateWayid);
			  
			  
			  //开始时间01-01 - 结束时间12-31
			  Calendar beginTime = Calendar.getInstance();
			  beginTime.set(Calendar.MONTH, 0);
			  beginTime.set(Calendar.DAY_OF_MONTH,1);
			  Calendar endTime = Calendar.getInstance();
			  endTime.set(Calendar.MONTH, 11);
			  endTime.set(Calendar.DAY_OF_MONTH,31);
			  //定时 每月的7号 10:12:11
			  PeriodValue  periodValue = new PeriodValue();
			  periodValue.setDay(7);
			  PeriodTime periodTime = new PeriodTime();
			  periodTime.setHour(10);
			  periodTime.setMinute(12);
			  periodTime.setSecond(11);
			  
			 
			  //定时任务 方法二
			  GateWayid=mms.AddTask(PeriodType.Month, periodValue, periodTime, destinationAddresses, subject,content, extendCode, ApplicationID, Password, beginTime, endTime);
			  System.out.println(GateWayid);
			 
			  //定时任务 方法四
			  GateWayid = mms.AddTask(PeriodType.Month, periodValue, periodTime, destinationAddresses,subject, content, extendCode, ApplicationID, Password);
			  System.out.println(GateWayid);
			  
			  //删除定时 方法一
			  mms.RemoveTask(GateWayid);
			  //删除定时 方法二
			  mms.RemoveTask(GateWayid, Password);
			  
			  //获取上行彩信 方法一
			  String MessageID = "02e2021b-e544-45df-87f0-192c96083826";
			  // 短信的MessageID获取方式：
			  // 1.客户开发工程师在项目中开放WebService接口
			  // 2.OpenMAS服务调用WebServcie接口，将MessageID通过参数的方式传递给应用系统
			  // 3.应用系统通过该MessageID去获取短信信息
			  // 注意：该MessageID不是发送短信是返回的ID
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
