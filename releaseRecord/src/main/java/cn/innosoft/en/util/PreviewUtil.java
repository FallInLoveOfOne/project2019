package cn.innosoft.en.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class PreviewUtil {
	
    public PreviewUtil() {  
    	
    }  
    
    // word转html预览
    private static boolean  wordToHtml(String s, String s1) {  
        //ComThread.InitSTA(true);  
        ComThread.InitMTA(true);  
        ActiveXComponent activexcomponent = new ActiveXComponent(  
                "Word.Application");  
        String s2 = s;  
        String s3 = s1;  
        boolean flag = false;  
        try {  
            activexcomponent.setProperty("Visible", new Variant(false));  
            Dispatch dispatch = activexcomponent.getProperty("Documents").toDispatch();  
            Dispatch dispatch1 = Dispatch.invoke(dispatch, "Open", 1,  
                    new Object[] { s2, new Variant(false), new Variant(true) },  
                    new int[1]).toDispatch();  
            Dispatch.invoke(dispatch1, "SaveAs", 1, new Object[] { s3,  
                    new Variant(8) }, new int[1]);  
            Variant variant = new Variant(false);  
            Dispatch.call(dispatch1, "Close", variant);  
            flag = true;  
        } catch (Exception exception) {  
            exception.printStackTrace();  
        } finally {  
            activexcomponent.invoke("Quit", new Variant[0]);  
            ComThread.Release();  
            ComThread.quitMainSTA();  
        }  
        return flag;  
    }  
    
    // ppt转html预览
    private static boolean pptToHtml(String s, String s1) {  
        ComThread.InitSTA();  
        ActiveXComponent activexcomponent = new ActiveXComponent(  
                "PowerPoint.Application");  
        String s2 = s;  
        String s3 = s1;  
        boolean flag = false;  
        try {  
            Dispatch dispatch = activexcomponent.getProperty("Presentations")  
                    .toDispatch();  
            Dispatch dispatch1 = Dispatch.call(dispatch, "Open", s2,  
                    new Variant(-1), new Variant(-1), new Variant(0))  
                    .toDispatch();  
            Dispatch.call(dispatch1, "SaveAs", s3, new Variant(12));  
            Variant variant = new Variant(-1);  
            Dispatch.call(dispatch1, "Close");  
            flag = true;  
        } catch (Exception exception) {  
            System.out.println("|||" + exception.toString());  
        } finally {  
            activexcomponent.invoke("Quit", new Variant[0]);  
            ComThread.Release();  
            ComThread.quitMainSTA();  
        }  
        return flag;  
    }  
    
    // excel转html预览
    private static boolean excelToHtml(String s, String s1) {  
         ComThread.InitSTA();  
         ActiveXComponent activexcomponent = new  
         ActiveXComponent("Excel.Application");  
         String s2 = s;  
         String s3 = s1;  
         boolean flag = false;  
         try  
         {  
         activexcomponent.setProperty("Visible", new Variant(false));  
         Dispatch dispatch =  
         activexcomponent.getProperty("Workbooks").toDispatch();  
         Dispatch dispatch1 = Dispatch.invoke(dispatch, "Open", 1, new  
         Object[] {  
         s2, new Variant(false), new Variant(true)  
         }, new int[1]).toDispatch();  
         Dispatch.call(dispatch1, "SaveAs", s3, new Variant(44));  
         Variant variant = new Variant(false);  
         Dispatch.call(dispatch1, "Close", variant);  
         flag = true;  
         }  
         catch(Exception exception)  
         {  
         System.out.println("|||" + exception.toString());  
         }  
         finally  
         {  
         activexcomponent.invoke("Quit", new Variant[0]);  
         ComThread.Release();  
         ComThread.quitMainSTA();  
         }  
         return flag;  
    } 
	
	// 获取文件并创建文件夹
	private static Map<String,String> getFileAndCreateDir(){
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		// 时间戳
		String time = simple.format(date);
		Map<String,String> map = new HashMap<String,String>();
		// office文件暂存路径
		String officeSavePath = PropsUtil.getValue("officeSavePath");
		// 转成html后的文件存储路径
		String htmlSavePath = PropsUtil.getValue("htmlSavePath");
		// pdf文件存储路径
		String pdfSavePath = PropsUtil.getValue("pdfSavePath");
		// imf文件存储路径
		String imgSavePath = PropsUtil.getValue("imgSavePath");
		// office文件暂存加上时间戳的路径
		String officeSaveTimePath = officeSavePath+"/"+time;
		// pdf文件加上时间戳的路径
		String pdfSavePathTime = pdfSavePath+"/"+time;
		// img文件加上时间戳的路径
		String imgSavePathTime = imgSavePath+"/"+time;
		// html文件加上时间戳的路径
		String htmlSaveTimePath = htmlSavePath+"/"+time;
		// 判断文件路径是否存在，不存在则创建
		EnUtil.createDir(officeSaveTimePath);
		EnUtil.createDir(htmlSaveTimePath);
		EnUtil.createDir(imgSavePathTime);
		EnUtil.createDir(pdfSavePathTime);
		map.put("officeSaveTimePath", officeSaveTimePath);
		map.put("htmlSaveTimePath", htmlSaveTimePath);
		map.put("imgSavePathTime", imgSavePathTime);
		map.put("pdfSavePathTime", pdfSavePathTime);
		return map;
	}

	// 判断不同类型的文件后缀名拼接出不同预览文件下载和保存的路径
	private static Map<String,String> getSuffixAndFilePath(String fileStyle,String fileStorageName,String officeSaveTimePath,String htmlSaveTimePath,String imgSavePathTime,String pdfSavePathTime){
		String fullSaveTimePath = "";
		String previewSaveTimePath = "";
		Map<String,String> map = new HashMap<String,String>();
		// 拼接完整的源文件名
		if(fileStyle.equals(".doc") || fileStyle.equals(".docx") || fileStyle.equals(".xlsx") ){
			fullSaveTimePath = officeSaveTimePath+"/"+fileStorageName;
			// 将文件后缀名替换成 .html
			String viewNameHtml = fileStorageName.replace(fileStyle,".html");
			// 需要保存的html文件夹路径加上html转换成功后的文件名完整路径
			previewSaveTimePath = htmlSaveTimePath+"/"+viewNameHtml;
		}else if(fileStyle.equals(".jpg") || fileStyle.equals(".jpeg") || fileStyle.equals(".bmp") || fileStyle.equals(".png")){
			previewSaveTimePath = imgSavePathTime+"/"+fileStorageName;
			fullSaveTimePath = previewSaveTimePath;
		}else if(fileStyle.equals(".pdf")){
			previewSaveTimePath = pdfSavePathTime+"/"+fileStorageName;
			fullSaveTimePath = previewSaveTimePath;
		}
		map.put("fullSaveTimePath", fullSaveTimePath);
		map.put("previewSaveTimePath", previewSaveTimePath);
		return map;
	}
	
	/**
	 * 
	 * @param fileStoragePathFileName 文件存储路径
	 * @param viewName 文件真实名称
	 * @param officeSavePath office文件暂存路径
	 * @param htmlSavePath 转成html后的文件存储路径
	 * @return
	 * @throws IOException 
	 */
	public static List<String> getPath(String fileStoragePathFileName, String viewName,HttpServletRequest request) throws IOException {
		List<String> list = new ArrayList<String>();
		Map<String, String> fileStoragePathFileNameMap = EnUtil.getFileNameAndParentPath(fileStoragePathFileName);
		// 文件存储名
		String fileStorageName = fileStoragePathFileNameMap.get("fileName");
		// 通过写好的方法创建并获得配置文件中各配置路径的map集合
		Map<String,String> SavePathMap = getFileAndCreateDir();
		// office文件暂存加上时间戳的路径
		String officeSaveTimePath = SavePathMap.get("officeSaveTimePath");
		// pdf文件加上时间戳的路径
		String pdfSavePathTime = SavePathMap.get("pdfSavePathTime");
		// img文件加上时间戳的路径
		String imgSavePathTime = SavePathMap.get("imgSavePathTime");
		// html文件加上时间戳的路径
		String htmlSaveTimePath = SavePathMap.get("htmlSaveTimePath");
		// 截取文件后缀名
		String fileStyle = EnUtil.getFileExtName(fileStorageName).toLowerCase();
		// // 通过写好的方法判断不同类型的文件后缀名拼接出不同预览文件下载和保存的路径
		Map<String,String> getSuffixAndFilePathMap = getSuffixAndFilePath( fileStyle, fileStorageName, officeSaveTimePath, htmlSaveTimePath, imgSavePathTime, pdfSavePathTime);
		// 完整的下载路径
		String fullSaveTimePath = getSuffixAndFilePathMap.get("fullSaveTimePath");
		// 预览文件的保存路径
		String previewSaveTimePath = getSuffixAndFilePathMap.get("previewSaveTimePath");
		File previewFile = new File(previewSaveTimePath);
		// 文件路径切割，切割成盘符和文件夹名，取文件夹名
		String fileSubpath = previewSaveTimePath.split(":/")[1];
		list.add(fileSubpath);
		list.add(viewName);
		// 通过完整文件路径名判断该文件是否已存在
		if(previewFile.exists()){
			return list;
		}
		FTPUtil.downFile(fullSaveTimePath,fileStoragePathFileName);
		// 判断word的类型 进行转换
		if(fileStyle.equals(".doc") || fileStyle.equals(".docx")){
			wordToHtml(fullSaveTimePath,previewSaveTimePath);
		}else if(fileStyle.equals(".xlsx")){
			excelToHtml(fullSaveTimePath,previewSaveTimePath);
		}
		return list;
	}

}
