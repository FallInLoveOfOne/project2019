package cn.innosoft.en.releaseRecord.report.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the T_FCF_REPORT database table.
 * 
 */
@Entity
@Table(name="T_FCF_REPORT")
@NamedQuery(name="TFcfReport.findAll", query="SELECT t FROM TFcfReport t")
public class TFcfReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CREATE_TIME")
	private String createTime;

	@Column(name="DOWNLOAD_NUM")
	private String downloadNum;
	@Id
	private String id;

	@Column(name="REPORT_NAME")
	private String reportName;

	@Column(name="REPORT_TYPE")
	private String reportType;

	public TFcfReport() {
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDownloadNum() {
		return this.downloadNum;
	}

	public void setDownloadNum(String downloadNum) {
		this.downloadNum = downloadNum;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportType() {
		return this.reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

}