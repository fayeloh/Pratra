package com.pratra.entity;

/**
 * @JavaBean
 * @此类为收费项目资料录入编辑
 * @数据库名tb_insert
 */

public class InsertUser {
	private String kind; // 收费类别
	private String project; // 收费项目
	private int period; // 收费周期
	private String price; // 收费价格
	private String explain; // 收费说明
	private String remark; // 备注

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
