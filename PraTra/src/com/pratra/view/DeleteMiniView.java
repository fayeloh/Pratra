package com.pratra.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 根据输入的id删除数据库中的相关数据
 */
public class DeleteMiniView {
	// 请输入id的界面
	JFrame f = new JFrame("MiniView");
	JLabel l = new JLabel("请输入id:");
	JTextField t = new JTextField(); // 输入id的文本框
	JButton b = new JButton("确定");
	String id;

	public DeleteMiniView() {
		init();
		ID();
	}

	private void init() {

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
		id = t.getText();
		return id;
	}
}
