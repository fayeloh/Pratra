package com.goods.pager;

import java.util.List;

/**
 * 分页实体
 * @author lenovo
 *
 */
public class PageBean<T> {  //泛型类的作用？
	private int pc;//当前页数
	private int tr;//总记录数
	private int ps;//当前页记录数
	private String url;//请求的路径与参数
	private List<T> beanList;
	//得到总页数
	public int getTp(){
		int tp = tr / ps;
		return tr % ps == 0 ? tp : tp + 1;
		
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
}
