package cn.innosoft.en.util;

import java.io.Serializable;
import java.util.List;

public class FullEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int subject_type;// 用户类型
	private String email;// 邮箱
	private boolean password_reseted;// 是否重置过密码
	private String name;// 姓名
	private String pinyin;// 姓名的拼音
	private int gender;// 性别	0-未选择，1-男，2-女
	private String phone;// 电话
	private String avatar;// 头像地址
	private String department;// 部门
	private String title;// 职位
	private String description;// 签名
	private String job_number;// 工号
	private String remark;// 备注
	private int birthday;// 生日 时间戳（秒）
	private int entry_date;// 入职时间	时间戳（秒）
	private List<Object> photos;// 识别照片列表
	private int purpose;// (访客属性) 来访目的	0: 其他, 1: 面试, 2: 商务, 3: 亲友, 4: 快递送货
	private String interviewee;// (访客属性) 受访人
	private String come_from;// (访客属性) 来访单位
	private int start_time;// (访客属性) 预定来访时间	时间戳（秒）
	private int end_time;// ((访客属性) 预定离开时间	时间戳（秒）
	private boolean visit_notify;// ((访客属性) 预定离开时间	时间戳（秒）
	public int getSubject_type() {
		return subject_type;
	}
	public void setSubject_type(int subject_type) {
		this.subject_type = subject_type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isPassword_reseted() {
		return password_reseted;
	}
	public void setPassword_reseted(boolean password_reseted) {
		this.password_reseted = password_reseted;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getDepartment() {
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
	public List<Object> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Object> photos) {
		this.photos = photos;
	}
	public int getPurpose() {
		return purpose;
	}
	public void setPurpose(int purpose) {
		this.purpose = purpose;
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
	}
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
	public boolean isVisit_notify() {
		return visit_notify;
	}
	public void setVisit_notify(boolean visit_notify) {
		this.visit_notify = visit_notify;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
