package com.goods.pager;
/**
 * 表达式类，作为sql的条件
 * @author lenovo
 *
 */
public class Expression {
	private String name;//名字
	private String operator;//运算符
	private String value;//值
	@Override
	public String toString() {
		return "Expression [name=" + name + ", operator=" + operator
				+ ", value=" + value + "]";
	}
	public Expression() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expression(String name, String operator, String value) {
		super();
		this.name = name;
		this.operator = operator;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
