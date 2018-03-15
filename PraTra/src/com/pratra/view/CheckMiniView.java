package com.pratra.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 执行查询查找的GUI界面
 */
public class CheckMiniView {
	// 请输入id的界面
	JFrame f = new JFrame("MiniView");
	JLabel l = new JLabel("请输入id:");
	JTextField t = new JTextField();
	JButton b = new JButton("确定");
	String id;

	public CheckMiniView() {
		init();
		ID();
	}

	private void init() { // 初始化界面

		f.setLayout(null);
		l.setBounds(120, 35, 80, 50);
		t.setBounds(200, 40, 120, 40);
		b.setBounds(200, 100, 60, 30);
		f.add(b);
		f.add(l);
		f.add(t);
		f.setBounds(300, 300, 500, 200);
		f.setVisible(true);
	}

	public String ID() {
		id = t.getText(); // 得到用户输入的id
		return id;
	}
}
