package com.pratra.view;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * ����idʵ���������ݹ���
 */

public class AddMiniView {
	// ������id�Ľ���
	JFrame f = new JFrame("MiniView");
	JLabel l = new JLabel("������ id:");
	JTextField t = new JTextField();
	JButton b = new JButton("ȷ��");
	String id;

	public AddMiniView() {
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
