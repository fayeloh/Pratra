package com.pratra.entity;

import java.util.Date;

/**
 * @JavaBean
 * @����Ϊ��ҵ�̶��շѳ�����
 * @���ݿ���Ϊtb_copy
 */

public class CopyUser {
	private String place; // ��ҵλ��
	private int no; // ����
	private String name; // �⻧����
	private String kind; // �շ����
	private String project; // �շ���Ŀ
	private int period; // �շ�����
	private Date stdt; // ��ʼ����
	private int stnum; // ��ʼ����
	private Date fidt; // ��ֹ����
	private int finum; // ��ֹ����

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
