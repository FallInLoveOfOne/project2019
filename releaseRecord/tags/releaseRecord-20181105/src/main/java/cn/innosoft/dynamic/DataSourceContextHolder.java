package cn.innosoft.dynamic;



public class DataSourceContextHolder {

	@SuppressWarnings("rawtypes")
	private static final ThreadLocal contextHolder=new ThreadLocal();
	
	@SuppressWarnings("unchecked")
	public static void setDataSourceType(String dataSourceName){
		contextHolder.set(dataSourceName);
	}
	
	public static String getDataSourceName(){
		return (String) contextHolder.get();
	}
	
	public static void clearDataSourceType(){
		contextHolder.remove();
	}
	
}
