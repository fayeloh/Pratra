package com.pratra.entity;

import java.util.Date;

/**
 * @JavaBean
 * @此类为物业固定收费抄表窗口
 * @数据库名为tb_copy
 */

public class CopyUser {
	private String place; // 物业位置
	private int no; // 房号
	private String name; // 租户名称
	private String kind; // 收费类别
	private String project; // 收费项目
	private int period; // 收费周期
	private Date stdt; // 起始日期
	private int stnum; // 起始表数
	private Date fidt; // 终止日期
	private int finum; // 终止表数

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Date getStdt() {
		return stdt;
	}

	public void setStdt(Date stdt) {
		this.stdt = stdt;
	}

	public int getStnum() {
		return stnum;
	}

	public void setStnum(int stnum) {
		this.stnum = stnum;
	}

	public Date getFidt() {
		return fidt;
	}

	public void setFidt(Date fidt) {
		this.fidt = fidt;
	}

	public int getFinum() {
		return finum;
	}

	public void setFinum(int finum) {
		this.finum = finum;
	}

}
