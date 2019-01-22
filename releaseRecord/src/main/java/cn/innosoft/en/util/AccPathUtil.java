package cn.innosoft.en.util;

public class AccPathUtil {

	// 人员附件目录
	public static String accPerPath = "";

	// 根据类型获取路径
	public static String getAccPath(String type) {
		String accDir = EnUtil.addPathSep(PropsUtil.getValue("accDirPath"))+"qyzb\\"+"accSaveDir"+"\\";
		switch (type) {
		case "report":
			accDir = accDir+"report";
		    break;
		case "table":
			accDir = accDir+"table";
		    break;
		case "org":
			accDir = accDir+"org";
		    break;
		case "per":
			accDir = accDir+"per";
		    break;
		case "taskSub":
			accDir = accDir+"taskSub";
		    break;
		case "taskSubCopy":
			accDir = accDir+"taskSubCopy";
		    break;
		case "other":
			accDir = accDir+"other";
		    break;
		case "document":
			accDir = accDir+"document";
		    break;
		case "class":
			accDir = accDir+"class";
		    break;
		case "acc":
			accDir = accDir+"acc";
		    break;
		default:
			accDir = accDir+"default";
		    break;
		}
		return accDir;
	}
}
