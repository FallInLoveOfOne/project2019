package cn.innosoft.dynamic;


import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;



public class DynamicDataSource extends AbstractRoutingDataSource {

	/* 
	 * 该方法必须要重写  方法是为了根据数据库标示符取得当前的数据库
	 */
	@Override
	public Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSourceName();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setTargetDataSources(Map targetDataSources) {
		super.setTargetDataSources(targetDataSources);
		super.afterPropertiesSet();
	}

}