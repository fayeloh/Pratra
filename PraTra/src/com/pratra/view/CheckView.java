package com.pratra.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pratra.control.EventHandleControl;
import com.pratra.dao.UserDAOImpl;
import com.pratra.entity.WriUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

/**
 * 根据所选条件执行相关操作
 */
public class CheckView extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	UserDAOImpl userDAOImpl;
	WriUser wriUser;
	EventHandleControl eventHandleControl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckView frame = new CheckView();
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
	public CheckView() {
		setVisible(true);
		setTitle("物业资料查找窗口");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u67E5\u627E\u5B57\u6BB5");
		lblNewLabel.setBounds(10, 10, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u67E5\u627E\u5173\u7CFB");
		lblNewLabel_1.setBounds(182, 10, 54, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u67E5\u627E\u503C");
		lblNewLabel_2.setBounds(338, 10, 54, 15);
		contentPane.add(lblNewLabel_2);

		JComboBox comboBox = new JComboBox(); // 添加多选框
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "\u72B6\u6001", "\u5355\u636E\u7F16\u53F7",
				"\u7F34\u8D39\u65E5\u671F", "\u7269\u4E1A\u4F4D\u7F6E", "\u623F\u53F7", "\u79DF\u6237\u540D\u79F0",
				"\u4ED8\u6B3E\u65B9\u5F0F", "\u4EA4\u8D39\u91D1\u989D", "\u524D\u6B21\u7ED3\u8F6C",
				"\u5E94\u7F34\u91D1\u989D", "\u5B9E\u7F34\u91D1\u989D", "\u672C\u6B21\u7ED3\u5B58",
				"\u6536\u8D39\u4EBA\u5458", "\u5907\u6CE8", "\u5EFA\u6863\u4EBA\u5458", "\u5EFA\u6863\u65E5\u671F",
				"\u4FEE\u6539\u4EBA\u5458", "\u4FEE\u6539\u65E5\u671F", "\u5BA1\u6838\u4EBA\u5458",
				"\u5BA1\u6838\u65E5\u671F" }));
		comboBox.setBounds(10, 44, 113, 21);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "", "\u76F8\u4F3C", "\u7B49\u4E8E",
				"\u4E0D\u7B49\u4E8E", "\u5C0F\u4E8E\u7B49\u4E8E", "\u5927\u4E8E\u7B49\u4E8E" }));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(182, 44, 100, 21);
		contentPane.add(comboBox_1);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 478, 76);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(337, 45, 104, 21);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("查找逻辑");
		lblNewLabel_3.setBounds(20, 93, 54, 15);
		contentPane.add(lblNewLabel_3);

		JRadioButton radioButton = new JRadioButton("并且");
		buttonGroup.add(radioButton);
		radioButton.setBounds(134, 89, 92, 23);
		contentPane.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("或者");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(252, 89, 121, 23);
		contentPane.add(radioButton_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 75, 478, 50);
		contentPane.add(panel_1);

		JButton add = new JButton("增加");
		add.setBounds(11, 138, 63, 23);
		contentPane.add(add);

		JButton delete = new JButton("清除");
		delete.setBounds(90, 138, 63, 23);
		contentPane.add(delete);

		JButton btnF = new JButton("确认  F3");
		btnF.setBounds(161, 138, 92, 23);
		contentPane.add(btnF);

		JButton allData = new JButton("全部数据");
		allData.setBounds(263, 138, 93, 23);
		contentPane.add(allData);

		JButton btnNewButton = new JButton("关闭[F12]");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnNewButton.setBounds(366, 138, 93, 23);
		contentPane.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 126, 478, 136);
		contentPane.add(panel_2);

		add.addActionListener(new ActionListener() { // 增加按钮监听机制

			@Override
			public void actionPerformed(ActionEvent e) {
				AddMiniView m = new AddMiniView();
				m.b.addActionListener(new ActionListener() { // 在MiniView里面监听addView

					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(add, "必须有一个查找字段");

					}
				});

			}
		});
		delete.addActionListener(new ActionListener() { // 清除按钮的监听机制

			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteMiniView m = new DeleteMiniView();
				m.b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String id = m.ID(); // 根据输入的id删除数据库中的相关数据
						// String id = "333";
						System.out.println(id);
						userDAOImpl.delete(id);
						JOptionPane.showMessageDialog(delete, "已删除");

					}
				});
			}
		});
		allData.addActionListener(new ActionListener() { // 全部数据按钮监听机制

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					TableView t = new TableView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}
}
