package com.pratra.entity;

/**
 * @JavaBean
 * @����Ϊ�շ���Ŀ����¼��༭
 * @���ݿ���tb_insert
 */

public class InsertUser {
	private String kind; // �շ����
	private String project; // �շ���Ŀ
	private int period; // �շ�����
	private String price; // �շѼ۸�
	private String explain; // �շ�˵��
	private String remark; // ��ע

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
