package com.pratra.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SpringLayout;

public class WarmView1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarmView1 frame = new WarmView1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WarmView1() {
		setTitle("\u63D0\u793A\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel label = new JLabel("设置已完成");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 61, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 45, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, 111, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, 372, SpringLayout.WEST, contentPane);
		contentPane.add(label);
		
		JButton button = new JButton("\u786E\u5B9A");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 173, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 299, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, 392, SpringLayout.WEST, contentPane);
		contentPane.add(button);
	}
}
