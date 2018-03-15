package com.pratra.entity;

/**
 * @JavaBean
 * @此类为物业数据统计报表窗口
 * @数据库名为tb_stat
 */

public class StatUser {
	private String state; // 状态
	private int prono; // 物业数量

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getProno() {
		return prono;
	}

	public void setProno(int prono) {
		this.prono = prono;
	}

}
