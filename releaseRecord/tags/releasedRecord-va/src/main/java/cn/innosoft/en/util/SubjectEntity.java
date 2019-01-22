package cn.innosoft.en.util;

import java.io.Serializable;
import java.util.List;

/**
 * 基本信息实体
 * @author sh
 *
 */
public class SubjectEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int start_time;// 来访时间
	private int end_time;// 离开时间
	private int purpose;// 来访目的
	private int birthday;// 生日
	private int entry_date;// 入职时间
//	private List<String> photo_ids;// 识别头像列表
	private int gender;// 性别{0: 未选择, 1: 男, 2: 女}
//	private String email;// 邮箱
//	private String phone;// 手机
	private String avatar;// 头像图片base64编码
//	private String department;// 部门
//	private String title;// 职位
//	private String description;// 签名
//	private String interviewee;// 受访人
//	private String come_from;// 来访单位
	private String job_number;// 工号
	private String remark;// 备注
	private int subject_type;// 用户类型 {0:员工, 1:访客, 2: VIP访客}
	private String name;// 姓名
	
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	public int getEnd_time() {
		return end_time;
	}
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
	public int getPurpose() {
		return purpose;
	}
	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public int getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(int entry_date) {
		this.entry_date = entry_date;
	}
	/*public List<String> getPhoto_ids() {
		return photo_ids;
	}
	public void setPhoto_ids(List<String> photo_ids) {
		this.photo_ids = photo_ids;
	}*/
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	/*public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}*/
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/*public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInterviewee() {
		return interviewee;
	}
	public void setInterviewee(String interviewee) {
		this.interviewee = interviewee;
	}
	public String getCome_from() {
		return come_from;
	}
	public void setCome_from(String come_from) {
		this.come_from = come_from;
	}*/
	public String getJob_number() {
		return job_number;
	}
	public void setJob_number(String job_number) {
		this.job_number = job_number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSubject_type() {
		return subject_type;
	}
	public void setSubject_type(int subject_type) {
		this.subject_type = subject_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
