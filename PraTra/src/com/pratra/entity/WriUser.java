package com.pratra.entity;

/**
 * @JavaBean
 * @此类为物业资料录入编辑窗口的javabean
 * @数据库名为tb_write
 */

public class WriUser {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String state; // 状态
	private String place; // 物业位置
	private String no; // 房号
	private String name; // 租户名称
	private String kind; // 物业类型
	private String strar; // 建筑面积
	private String inspa; // 套内面积
	private String diar; // 公摊面积
	private String rent; // 租金
	private String cono; // 合同编号
	private String cost; // 合同起日
	private String cofi; // 合同止日
	private String phone; // 联系电话

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
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

	public String getStrar() {
		return strar;
	}

	public void setStrar(String strar) {
		this.strar = strar;
	}

	public String getInspa() {
		return inspa;
	}

	public void setInspa(String inspa) {
		this.inspa = inspa;
	}

	public String getDiar() {
		return diar;
	}

	public void setDiar(String diar) {
		this.diar = diar;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getCono() {
		return cono;
	}

	public void setCono(String cono) {
		this.cono = cono;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getCofi() {
		return cofi;
	}

	public void setCofi(String cofi) {
		this.cofi = cofi;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
