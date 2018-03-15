package com.pratra.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import com.pratra.biz.EventHandleBiz;
import com.pratra.control.EventHandleControl;
import com.pratra.dao.UserDAOImpl;
import com.pratra.entity.WriUser;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;

/**
 * @author 罗伟凡
 * @主界面类
 */

public class TableView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	UserDAOImpl userDAOImpl = new UserDAOImpl();
	EventHandleBiz eventHandleBiz = new EventHandleBiz();
	WriUser wriUser = new WriUser();
	EventHandleControl eventHandleControl = new EventHandleControl();
	QueryView q = new QueryView();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableView frame = new TableView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public TableView() throws SQLException {
		setVisible(true);
		setTitle("物业资料录入编辑窗口");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 700);

		contentPane = new JPanel();// 内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTree tree = new JTree();// 树状图
		tree.setBounds(10, 66, 180, 600);
		contentPane.add(tree);

		JScrollPane scrollPane = new JScrollPane();// 滚动面板
		scrollPane.setBounds(190, 66, 1000, 600);
		contentPane.add(scrollPane);

		JToolBar toolBar = new JToolBar(); // 工具栏
		toolBar.setBounds(0, 10, 1700, 60);
		contentPane.add(toolBar);

		tree.setModel(new DefaultTreeModel( // 树状图
				new DefaultMutableTreeNode("物业项目") {
					{
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("祥瑞花园小区");
						node_1.add(new DefaultMutableTreeNode("1号楼"));
						node_1.add(new DefaultMutableTreeNode("2号楼"));
						add(node_1);
						add(new DefaultMutableTreeNode("祥瑞商业步行街"));
					}
				}));

		/**
		 * 以下为表格
		 */

		Object[][] tableValues = userDAOImpl.query();
		String[] columnNames = eventHandleControl.getTitle();
		TableModel tableModel = new DefaultTableModel(tableValues, columnNames);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);// 滚动面板上添加表格
		table.setRowSorter(new TableRowSorter(tableModel));

		/////////// 工具栏/////////////
		//////////////////// 增加/////////////////////////////
		JButton addBtn = new JButton("");// 增加F5
		addBtn.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F1.jpg")));

		toolBar.add(addBtn);
		JButton wriBtn = new JButton("");// 编辑F6
		wriBtn.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F2.jpg")));
		toolBar.add(wriBtn);
		wriBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedRow = table.getSelectedRow();
				int selectedColumn = table.getSelectedColumn();
				if (selectedRow != -1) {
					// ((AbstractTableModel)
					// tableModel).fireTableCellUpdated(selectedRow,selectedColumn);
					// ///为什么要转型
				}
			}
		});

		JButton deleteBtn = new JButton("");// 删除F7
		deleteBtn.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F3.jpg")));
		toolBar.add(deleteBtn);

		JButton btnNewButton_3 = new JButton("");// 批处理
		btnNewButton_3.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F4.jpg")));
		toolBar.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("");// 移动F9
		btnNewButton_4.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F5.jpg")));
		toolBar.add(btnNewButton_4);

		JButton checkBtn = new JButton("");// 查找F10
		checkBtn.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F6.jpg")));
		toolBar.add(checkBtn);

		JButton frist = new JButton("");// 头一条
		frist.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F7.jpg")));
		toolBar.add(frist);

		JButton front = new JButton("");// 前一条
		front.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F8.jpg")));
		toolBar.add(front);

		JButton next = new JButton("");// 下一条
		next.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F9.jpg")));
		toolBar.add(next);

		JButton last = new JButton("");// 末一条
		last.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F10.jpg")));
		toolBar.add(last);

		JButton shezhi = new JButton("");// 设置
		shezhi.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F11.jpg")));
		toolBar.add(shezhi);

		JButton btnNewButton_11 = new JButton("");// 审核
		btnNewButton_11.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F12.jpg")));
		toolBar.add(btnNewButton_11);

		JButton print = new JButton("");// 打印F11:print
		print.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F13.jpg")));
		toolBar.add(print);

		JButton close = new JButton("");// 关闭F12
		close.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F14.jpg")));
		toolBar.add(close);

		addBtn.addActionListener(new ActionListener() { // 增加按钮监听机制

			@Override
			public void actionPerformed(ActionEvent e) {
				AddView addView = new AddView();
			}
		});
		wriBtn.addActionListener(new ActionListener() { // 编辑按钮监听机制

			@Override
			public void actionPerformed(ActionEvent e) {
				AddView addView = new AddView();

			}
		});
		deleteBtn.addActionListener(new ActionListener() { // 删除按钮

			public void actionPerformed(ActionEvent e) {
				DeleteMiniView m = new DeleteMiniView();
				m.b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String id = m.ID(); // 根据id删除数据
						System.out.println(id);
						userDAOImpl.delete(id);

					}
				});
			}
		});
		checkBtn.addActionListener(new ActionListener() {// 查找按钮
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckMiniView m = new CheckMiniView();
				m.b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String id = m.ID();
						wriUser = userDAOImpl.check(id);
						q.init(wriUser); // 调用QueryView类的init方法传递要查找信息javabean
					}
				});

			}
		});
		frist.addActionListener(new ActionListener() { // 头一条按钮

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frist, "头一条已显示在下列表格中");
			}
		});
		front.addActionListener(new ActionListener() { // 前一条按钮

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(front, "前一条已显示在下列表格中");

			}
		});
		next.addActionListener(new ActionListener() { // 下一条按钮

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(next, "下一条已显示在下列表格中");

			}
		});
		last.addActionListener(new ActionListener() { // 末一条按钮

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(last, "末一条已显示");

			}
		});
		shezhi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WarmView1 w = new WarmView1(); // 调用warmView1类
				w.setVisible(true);
			}
		});

		print.addActionListener(new ActionListener() { // 打印表格按钮

			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleBiz.print(wriUser);// 调用逻辑层的print方法打印表格
				JOptionPane.showMessageDialog(print, "打印成功，文件是位于E盘的物业资料表格.xls");
			}
		});
		close.addActionListener(new ActionListener() { // 关闭按钮

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // 0为关闭

			}
		});
	}

}
