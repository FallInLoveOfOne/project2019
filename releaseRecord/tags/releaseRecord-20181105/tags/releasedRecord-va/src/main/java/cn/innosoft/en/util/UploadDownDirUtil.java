package cn.innosoft.en.util;

/**
 * 
 * @author 棒
 * 上传附件时分类文件夹名称共用类
 *
 */
public final class UploadDownDirUtil {
	
	/**
	 * 构造方法
	 */
	private UploadDownDirUtil(){
		
	}
	
	/**
	 * 新闻图片上传暂存文件夹名称
	 */
	public static final String PICTURE_SAVE_PATH  = "platform/pictureSavePath";
	
	/**
	 * 资料上传暂存文件夹名称
	 */
	public static final String DATA_SAVE_PATH  = "platform/dataSavePath";
	
	/**
	 * 下载文件暂存目录
	 */
	public static final String DOWNLOAD_SAVE_PATH  = "downloadSavePath";
	
	/**
	 * 静态页面保存数据库地址
	 */
	public static final String NEWS_HEML_PATH  = "/platform/newsHtml/";
	
	/**
	 * 富文本图片存放路径
	 */
	public static final String UM_PICTURE_PATH  = "/platform/umPicture/";

}
