package com.pratra.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 罗伟凡 界面类
 */
public class HomeView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView homeView = new HomeView();

					homeView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeView() {
		setVisible(true);
		setTitle("Home物业管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1680, 21);
		contentPane.add(menuBar);
		/////////////////////////////////// 菜单栏///////////////////////////////////
		JMenu mnNewMenu = new JMenu("物业收费管理");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("物业资料录入编辑");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem menuItem = new JMenuItem("物业固定收费抄录修改");
		mnNewMenu.add(menuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("物业收费单据录入编辑");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem menuItem_1 = new JMenuItem("物业收费单据统计查询");
		mnNewMenu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("物业收费明细统计查询");
		mnNewMenu.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("物业收费单据台帐管理");
		mnNewMenu.add(menuItem_3);

		JMenuItem menuItem_4 = new JMenuItem("物业收费图表显示");
		mnNewMenu.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("物业数据统计报表");
		mnNewMenu.add(menuItem_5);

		JMenu menu_1 = new JMenu("物业应收费用管理");
		menuBar.add(menu_1);
		/////////////////////////// 物业应收费管理的子菜单//////////////////////////////////

		JMenuItem menuItem_9 = new JMenuItem("\u5BB6\u5EAD\u6210\u5458\u67E5\u8BE2");
		menu_1.add(menuItem_9);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u7269\u4E1A\u62A5\u4FEE\u7BA1\u7406");
		menu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u7269\u4E1A\u6295\u8BC9\u7BA1\u7406");
		menu_1.add(mntmNewMenuItem_3);

		JMenuItem menuItem_10 = new JMenuItem("\u7269\u4E1A\u4FDD\u4FEE\u7EDF\u8BA1");
		menu_1.add(menuItem_10);

		JMenuItem menuItem_11 = new JMenuItem("\u7269\u4E1A\u6295\u8BC9\u7EDF\u8BA1");
		menu_1.add(menuItem_11);

		JMenuItem menuItem_12 = new JMenuItem("\u4FDD\u5B89\u4E8B\u4EF6\u7BA1\u7406");
		menu_1.add(menuItem_12);

		JMenuItem menuItem_13 = new JMenuItem("\u505C\u8F66\u573A\u7BA1\u7406");
		menu_1.add(menuItem_13);

		JMenuItem menuItem_14 = new JMenuItem("\u7EF4\u4FEE\u5DE5\u7A0B\u7BA1\u7406");
		menu_1.add(menuItem_14);

		JMenu menu_2 = new JMenu("\u57FA\u672C\u6570\u636E\u5F55\u5165\u7F16\u8F91");
		menuBar.add(menu_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u6536\u8D39\u7C7B\u522B\u8D44\u6599\u5F55\u5165\u7F16\u8F91");
		menu_2.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u6536\u8D39\u9879\u76EE\u8D44\u6599\u5F55\u5165\u7F16\u8F91");
		menu_2.add(mntmNewMenuItem_5);

		JMenuItem menuItem_15 = new JMenuItem("\u7269\u4E1A\u72B6\u6001\u989C\u8272\u5F55\u5165\u7F16\u8F91");
		menu_2.add(menuItem_15);

		JMenuItem menuItem_16 = new JMenuItem("\u91D1\u989D\u5C0F\u6570\u4F4D\u6570\u4FEE\u6539\u7F16\u8F91");
		menu_2.add(menuItem_16);

		JMenuItem menuItem_17 = new JMenuItem("\u5355\u4F4D\u90E8\u95E8\u8D44\u6599\u5F55\u5165\u7F16\u8F91");
		menu_2.add(menuItem_17);

		JMenuItem menuItem_18 = new JMenuItem("\u5355\u4F4D\u5458\u5DE5\u8D44\u6599\u5F55\u5165\u7F16\u8F91");
		menu_2.add(menuItem_18);

		JMenu menu_3 = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		menuBar.add(menu_3);

		JMenuItem menuItem_19 = new JMenuItem("\u7528\u6237\u7BA1\u7406");
		menu_3.add(menuItem_19);

		JMenuItem menuItem_20 = new JMenuItem("\u7528\u6237\u53E3\u4EE4\u4FEE\u6539");
		menu_3.add(menuItem_20);

		JMenuItem menuItem_21 = new JMenuItem("\u6570\u636E\u5907\u4EFD");
		menu_3.add(menuItem_21);

		JMenuItem menuItem_22 = new JMenuItem("\u6570\u636E\u6062\u590D");
		menu_3.add(menuItem_22);

		JMenuItem menuItem_23 = new JMenuItem("\u8FC7\u65F6\u6570\u636E\u5220\u9664");
		menu_3.add(menuItem_23);

		JMenuItem menuItem_24 = new JMenuItem("\u6570\u636E\u4FEE\u590D");
		menu_3.add(menuItem_24);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u7F16\u53F7\u65B9\u5F0F\u8BBE\u7F6E\u4FEE\u6539");
		menu_3.add(mntmNewMenuItem_6);

		JMenuItem menuItem_25 = new JMenuItem("\u8F6F\u4EF6\u6CE8\u518C\u7CFB\u5217\u53F7");
		menu_3.add(menuItem_25);

		JMenuItem mntmt = new JMenuItem("\u9000\u51FA[T]");
		menu_3.add(mntmt);

		JMenu mnF = new JMenu("\u5E2E\u52A9[F1]");
		menuBar.add(mnF);

		JMenuItem mntmF = new JMenuItem("\u5E2E\u52A9  F1");
		mnF.add(mntmF);

		JMenuItem menuItem_26 = new JMenuItem("\u5173\u4E8E");
		mnF.add(menuItem_26);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(37, 93, 923, 522);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setToolTipText("");
		tabbedPane.addTab("物业收费管理", null, panel, null);
		panel.setLayout(null);

		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setIcon(
				new ImageIcon(HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u672A\u6807\u9898-1.jpg")));
		btnNewButton_8.setBounds(176, 68, 74, 64);
		panel.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74063.jpg")));
		btnNewButton_9.setBounds(121, 227, 74, 64);
		panel.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74061.jpg")));
		btnNewButton_10.setBounds(430, 149, 80, 64);
		panel.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74062.jpg")));
		btnNewButton_11.setBounds(675, 51, 74, 64);
		panel.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74064.jpg")));
		btnNewButton_12.setBounds(738, 210, 93, 81);
		panel.add(btnNewButton_12);

		JLabel label = new JLabel("\u6536\u8D39\u9879\u76EE\u8D44\u6599\u5F55\u5165\u7F16\u8F91");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(121, 142, 200, 50);
		panel.add(label);

		JLabel lblNewLabel_7 = new JLabel("\u7269\u4E1A\u8D44\u6599\u5F55\u5165\u7F16\u8F91");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(102, 301, 200, 50);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\u7269\u4E1A\u56FA\u5B9A\u6536\u8D39\u4FEE\u6539\u7F16\u8F91");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(708, 292, 200, 50);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("\u7269\u4E1A\u5E94\u6536\u8D39\u5F55\u5165\u7F16\u8F91");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(399, 239, 200, 50);
		panel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("\u7269\u4E1A\u6536\u8D39\u5355\u636E\u5F55\u5165\u7F16\u8F91");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(650, 125, 200, 50);
		panel.add(lblNewLabel_10);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		panel_4.setBounds(0, 352, 918, 141);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton_13 = new JButton("\u7269\u4E1A\u6536\u8D39\u5355\u636E\u7EDF\u8BA1\u67E5\u8BE2");
		btnNewButton_13.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_13.setBounds(42, 10, 184, 23);
		panel_4.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("\u7269\u4E1A\u6536\u8D39\u660E\u7EC6\u67E5\u8BE2");
		btnNewButton_14.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_14.setBounds(42, 59, 184, 23);
		panel_4.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("\u7269\u4E1A\u5E94\u6536\u8D39\u7528\u7EDF\u8BA1\u67E5\u8BE2");
		btnNewButton_15.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_15.setBounds(350, 10, 184, 23);
		panel_4.add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton("\u7269\u4E1A\u5E94\u6536\u8D39\u7528\u53F0\u8D26\u7BA1\u7406");
		btnNewButton_16.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_16.setBounds(350, 59, 184, 23);
		panel_4.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("\u7269\u4E1A\u6536\u8D39\u5355\u636E\u7BA1\u7406");
		btnNewButton_17.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_17.setBounds(350, 108, 184, 23);
		panel_4.add(btnNewButton_17);

		JButton btnNewButton_18 = new JButton("\u7269\u4E1A\u72B6\u6001\u56FE\u8868\u663E\u793A");
		btnNewButton_18.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_18.setBounds(626, 10, 160, 23);
		panel_4.add(btnNewButton_18);

		JButton btnNewButton_19 = new JButton("\u7269\u4E1A\u6570\u636E\u7EDF\u8BA1\u62A5\u8868");
		btnNewButton_19.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_19.setBounds(626, 59, 160, 23);
		panel_4.add(btnNewButton_19);

		JLabel lblNewLabel_11 = new JLabel("\u7269\u4E1A\u6536\u8D39\u7BA1\u7406");
		lblNewLabel_11.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_11.setBounds(383, 10, 166, 36);
		panel.add(lblNewLabel_11);

		////////////////////////////// 选择面板///////////////////////////

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("物业应收费用管理", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel label_1 = new JLabel("\u7269\u4E1A\u5E94\u6536\u8D39\u7528\u7BA1\u7406");
		label_1.setBounds(371, 5, 176, 65);
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_1.add(label_1);

		JButton btnNewButton_20 = new JButton("");
		btnNewButton_20.setIcon(
				new ImageIcon(HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u672A\u6807\u9898-1.jpg")));
		btnNewButton_20.setBounds(141, 56, 77, 65);
		panel_1.add(btnNewButton_20);

		JButton btnNewButton_21 = new JButton("");
		btnNewButton_21.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74063.jpg")));
		btnNewButton_21.setBounds(141, 203, 77, 70);
		panel_1.add(btnNewButton_21);

		JButton btnNewButton_22 = new JButton("");
		btnNewButton_22.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74064.jpg")));
		btnNewButton_22.setBounds(141, 350, 93, 76);
		panel_1.add(btnNewButton_22);

		JButton btnNewButton_23 = new JButton("");
		btnNewButton_23.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74061.jpg")));
		btnNewButton_23.setBounds(491, 203, 77, 70);
		panel_1.add(btnNewButton_23);

		JButton btnNewButton_24 = new JButton("");
		btnNewButton_24.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74062.jpg")));
		btnNewButton_24.setBounds(744, 203, 71, 65);
		panel_1.add(btnNewButton_24);

		JLabel lblNewLabel_12 = new JLabel("\u6536\u8D39\u9879\u76EE\u8D44\u6599\u5F55\u5165\u7F16\u8F91");
		lblNewLabel_12.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(97, 125, 176, 26);
		panel_1.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("\u7269\u4E1A\u8D44\u6599\u5F55\u5165\u7F16\u8F91");
		lblNewLabel_13.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(122, 275, 128, 41);
		panel_1.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("\u7269\u4E1A\u56FA\u5B9A\u6536\u8D39\u6284\u5F55\u4FEE\u6539");
		lblNewLabel_14.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(122, 436, 151, 33);
		panel_1.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("\u7269\u4E1A\u5E94\u6536\u8D39\u7528\u5F55\u5165\u7F16\u8F91");
		lblNewLabel_15.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(473, 283, 140, 26);
		panel_1.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("\u7269\u4E1A\u6536\u8D39\u5355\u636E\u5F55\u5165\u7F16\u8F91");
		lblNewLabel_16.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(719, 278, 169, 28);
		panel_1.add(lblNewLabel_16);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("物业日常管理", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel_17 = new JLabel("\u7269\u4E1A\u65E5\u5E38\u7BA1\u7406");
		lblNewLabel_17.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_17.setBounds(368, 22, 201, 34);
		panel_2.add(lblNewLabel_17);

		JButton btnNewButton_25 = new JButton("");
		btnNewButton_25.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74061.jpg")));
		btnNewButton_25.setBounds(105, 70, 84, 62);
		panel_2.add(btnNewButton_25);

		JLabel lblNewLabel_18 = new JLabel("\u4FDD\u5B89\u4E8B\u4EF6\u7BA1\u7406");
		lblNewLabel_18.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_18.setBounds(105, 163, 131, 24);
		panel_2.add(lblNewLabel_18);

		JButton btnNewButton_26 = new JButton("");
		btnNewButton_26.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74061.jpg")));
		btnNewButton_26.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_26.setBounds(105, 226, 84, 62);
		panel_2.add(btnNewButton_26);

		JLabel lblNewLabel_19 = new JLabel("\u505C\u8F66\u573A\u7BA1\u7406");
		lblNewLabel_19.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_19.setBounds(105, 297, 84, 24);
		panel_2.add(lblNewLabel_19);

		JButton btnNewButton_27 = new JButton("");
		btnNewButton_27.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74061.jpg")));
		btnNewButton_27.setBounds(105, 377, 84, 68);
		panel_2.add(btnNewButton_27);

		JLabel lblNewLabel_20 = new JLabel("\u7EF4\u4FEE\u5DE5\u7A0B\u7BA1\u7406");
		lblNewLabel_20.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_20.setBounds(98, 455, 111, 28);
		panel_2.add(lblNewLabel_20);

		JButton btnNewButton_28 = new JButton("");
		btnNewButton_28.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u65E5\u5E38\u7BA1\u7406.jpg")));
		btnNewButton_28.setBounds(431, 70, 93, 62);
		panel_2.add(btnNewButton_28);

		JButton btnNewButton_29 = new JButton("");
		btnNewButton_29.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74061.jpg")));
		btnNewButton_29.setBounds(440, 226, 84, 62);
		panel_2.add(btnNewButton_29);

		JButton btnNewButton_30 = new JButton("");
		btnNewButton_30.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u6536\u8D39\u7BA1\u74061.jpg")));
		btnNewButton_30.setBounds(440, 383, 84, 62);
		panel_2.add(btnNewButton_30);

		JLabel lblNewLabel_21 = new JLabel("\u7269\u4E1A\u62A5\u4FEE\u7BA1\u7406");
		lblNewLabel_21.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_21.setBounds(431, 310, 93, 24);
		panel_2.add(lblNewLabel_21);

		JLabel lblNewLabel_22 = new JLabel("\u7269\u4E1A\u4FDD\u4FEE\u7EDF\u8BA1");
		lblNewLabel_22.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_22.setBounds(710, 302, 85, 15);
		panel_2.add(lblNewLabel_22);

		JButton btnNewButton_31 = new JButton("");
		btnNewButton_31.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u65E5\u5E38\u7BA1\u74062.jpg")));
		btnNewButton_31.setBounds(710, 224, 70, 64);
		panel_2.add(btnNewButton_31);

		JButton btnNewButton_32 = new JButton("");
		btnNewButton_32.setIcon(new ImageIcon(
				HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u65E5\u5E38\u7BA1\u74062.jpg")));
		btnNewButton_32.setBounds(725, 383, 70, 62);
		panel_2.add(btnNewButton_32);

		JLabel lblNewLabel_23 = new JLabel("\u5BB6\u5EAD\u6210\u5458\u67E5\u8BE2");
		lblNewLabel_23.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_23.setBounds(431, 168, 93, 15);
		panel_2.add(lblNewLabel_23);

		JLabel lblNewLabel_24 = new JLabel("\u7269\u4E1A\u6295\u8BC9\u7BA1\u7406");
		lblNewLabel_24.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_24.setBounds(429, 458, 111, 22);
		panel_2.add(lblNewLabel_24);

		JLabel lblNewLabel_25 = new JLabel("\u7269\u4E1A\u6295\u8BC9\u7EDF\u8BA1");
		lblNewLabel_25.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_25.setBounds(711, 458, 103, 22);
		panel_2.add(lblNewLabel_25);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		tabbedPane.addTab("基本数据录入编辑", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("基本数据录入编辑");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(315, 30, 166, 45);
		panel_3.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(
				new ImageIcon(HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u672A\u6807\u9898-1.jpg")));
		btnNewButton_2.setBounds(113, 78, 73, 50);
		panel_3.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(
				new ImageIcon(HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u672A\u6807\u9898-1.jpg")));
		btnNewButton_3.setBounds(43, 205, 62, 50);
		panel_3.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(
				new ImageIcon(HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u672A\u6807\u9898-1.jpg")));
		btnNewButton_4.setBounds(113, 317, 62, 50);
		panel_3.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(
				new ImageIcon(HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u672A\u6807\u9898-1.jpg")));
		btnNewButton_5.setBounds(334, 205, 62, 50);
		panel_3.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(
				new ImageIcon(HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u672A\u6807\u9898-1.jpg")));
		btnNewButton_6.setBounds(610, 142, 62, 50);
		panel_3.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(
				new ImageIcon(HomeView.class.getResource("/\u7269\u4E1A\u8D44\u6599/\u672A\u6807\u9898-1.jpg")));
		btnNewButton_7.setBounds(627, 292, 62, 50);
		panel_3.add(btnNewButton_7);

		JLabel lblNewLabel_1 = new JLabel("收费类别录入编辑");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(85, 142, 117, 15);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("收费项目资料录入编辑");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(12, 275, 174, 15);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("物业状态颜色录入编辑");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(63, 392, 174, 15);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("单位员工资料录入编辑");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(299, 275, 140, 15);
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("金额小数位数修改编辑");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(604, 218, 166, 15);
		panel_3.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("单位部门资料录入编辑");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(610, 371, 174, 15);
		panel_3.add(lblNewLabel_6);

		//////////////////////////// 工具栏/////////////////////
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.inactiveCaption);
		toolBar.setBounds(0, 20, 960, 63);
		contentPane.add(toolBar);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1
				.setIcon(new ImageIcon(HomeView.class.getResource("/\u5DE5\u5177\u680F/\u5DE5\u5177\u680F1.jpg")));
		toolBar.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_1) {
					new CheckView();
				}
			}
		});

		JButton button = new JButton("");
		button.setBackground(SystemColor.inactiveCaption);
		button.setIcon(new ImageIcon(HomeView.class.getResource("/\u5DE5\u5177\u680F/\u5DE5\u5177\u680F2.jpg")));
		toolBar.add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					new CheckView();
				}

			}
		});

		JButton button_1 = new JButton("");
		button_1.setBackground(SystemColor.inactiveCaption);
		button_1.setIcon(new ImageIcon(HomeView.class.getResource("/\u5DE5\u5177\u680F/\u5DE5\u5177\u680F3.jpg")));
		toolBar.add(button_1);
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button_1) {
					new CheckView();
				}

			}
		});

		JButton btnNewButton = new JButton(""); // 备份
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setIcon(new ImageIcon(HomeView.class.getResource("/\u5DE5\u5177\u680F/\u5DE5\u5177\u680F4.jpg")));
		toolBar.add(btnNewButton);

		JButton button_2 = new JButton(""); // 退出
		button_2.setBackground(SystemColor.inactiveCaption);
		button_2.setIcon(new ImageIcon(HomeView.class.getResource("/\u5DE5\u5177\u680F/\u5DE5\u5177\u680F5.jpg")));
		toolBar.add(button_2);
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1); // 关闭窗体

			}
		});
	}
}
