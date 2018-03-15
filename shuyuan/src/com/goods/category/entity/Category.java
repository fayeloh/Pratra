package com.goods.category.entity;

import java.util.List;

/**
 * 分类的实体类
 * 子父类关联的关系
 * @author lenovo
 *
 */
public class Category {
	private String cid;//主键
	private String cname;//分类名
	private Category parent; //父类
	private String desc;//描述
	private List<Category> children;//子类
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
}
