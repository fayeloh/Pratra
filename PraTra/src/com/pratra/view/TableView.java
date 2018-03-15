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
 * @author ��ΰ��
 * @��������
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
		setTitle("��ҵ����¼��༭����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 700);

		contentPane = new JPanel();// �������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTree tree = new JTree();// ��״ͼ
		tree.setBounds(10, 66, 180, 600);
		contentPane.add(tree);

		JScrollPane scrollPane = new JScrollPane();// �������
		scrollPane.setBounds(190, 66, 1000, 600);
		contentPane.add(scrollPane);

		JToolBar toolBar = new JToolBar(); // ������
		toolBar.setBounds(0, 10, 1700, 60);
		contentPane.add(toolBar);

		tree.setModel(new DefaultTreeModel( // ��״ͼ
				new DefaultMutableTreeNode("��ҵ��Ŀ") {
					{
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("����԰С��");
						node_1.add(new DefaultMutableTreeNode("1��¥"));
						node_1.add(new DefaultMutableTreeNode("2��¥"));
						add(node_1);
						add(new DefaultMutableTreeNode("������ҵ���н�"));
					}
				}));

		/**
		 * ����Ϊ���
		 */

		Object[][] tableValues = userDAOImpl.query();
		String[] columnNames = eventHandleControl.getTitle();
		TableModel tableModel = new DefaultTableModel(tableValues, columnNames);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);// �����������ӱ��
		table.setRowSorter(new TableRowSorter(tableModel));

		/////////// ������/////////////
		//////////////////// ����/////////////////////////////
		JButton addBtn = new JButton("");// ����F5
		addBtn.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F1.jpg")));

		toolBar.add(addBtn);
		JButton wriBtn = new JButton("");// �༭F6
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
					// ///ΪʲôҪת��
				}
			}
		});

		JButton deleteBtn = new JButton("");// ɾ��F7
		deleteBtn.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F3.jpg")));
		toolBar.add(deleteBtn);

		JButton btnNewButton_3 = new JButton("");// ������
		btnNewButton_3.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F4.jpg")));
		toolBar.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("");// �ƶ�F9
		btnNewButton_4.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F5.jpg")));
		toolBar.add(btnNewButton_4);

		JButton checkBtn = new JButton("");// ����F10
		checkBtn.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F6.jpg")));
		toolBar.add(checkBtn);

		JButton frist = new JButton("");// ͷһ��
		frist.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F7.jpg")));
		toolBar.add(frist);

		JButton front = new JButton("");// ǰһ��
		front.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F8.jpg")));
		toolBar.add(front);

		JButton next = new JButton("");// ��һ��
		next.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F9.jpg")));
		toolBar.add(next);

		JButton last = new JButton("");// ĩһ��
		last.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F10.jpg")));
		toolBar.add(last);

		JButton shezhi = new JButton("");// ����
		shezhi.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F11.jpg")));
		toolBar.add(shezhi);

		JButton btnNewButton_11 = new JButton("");// ���
		btnNewButton_11.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F12.jpg")));
		toolBar.add(btnNewButton_11);

		JButton print = new JButton("");// ��ӡF11:print
		print.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F13.jpg")));
		toolBar.add(print);

		JButton close = new JButton("");// �ر�F12
		close.setIcon(new ImageIcon(TableView.class
				.getResource("/\u7269\u4E1A\u8D44\u6599/\u7269\u4E1A\u8D44\u6599\u5DE5\u5177\u680F14.jpg")));
		toolBar.add(close);

		addBtn.addActionListener(new ActionListener() { // ���Ӱ�ť��������

			@Override
			public void actionPerformed(ActionEvent e) {
				AddView addView = new AddView();
			}
		});
		wriBtn.addActionListener(new ActionListener() { // �༭��ť��������

			@Override
			public void actionPerformed(ActionEvent e) {
				AddView addView = new AddView();

			}
		});
		deleteBtn.addActionListener(new ActionListener() { // ɾ����ť

			public void actionPerformed(ActionEvent e) {
				DeleteMiniView m = new DeleteMiniView();
				m.b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String id = m.ID(); // ����idɾ������
						System.out.println(id);
						userDAOImpl.delete(id);

					}
				});
			}
		});
		checkBtn.addActionListener(new ActionListener() {// ���Ұ�ť
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckMiniView m = new CheckMiniView();
				m.b.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String id = m.ID();
						wriUser = userDAOImpl.check(id);
						q.init(wriUser); // ����QueryView���init��������Ҫ������Ϣjavabean
					}
				});

			}
		});
		frist.addActionListener(new ActionListener() { // ͷһ����ť

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frist, "ͷһ������ʾ�����б����");
			}
		});
		front.addActionListener(new ActionListener() { // ǰһ����ť

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(front, "ǰһ������ʾ�����б����");

			}
		});
		next.addActionListener(new ActionListener() { // ��һ����ť

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(next, "��һ������ʾ�����б����");

			}
		});
		last.addActionListener(new ActionListener() { // ĩһ����ť

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(last, "ĩһ������ʾ");

			}
		});
		shezhi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				WarmView1 w = new WarmView1(); // ����warmView1��
				w.setVisible(true);
			}
		});

		print.addActionListener(new ActionListener() { // ��ӡ���ť

			@Override
			public void actionPerformed(ActionEvent e) {
				eventHandleBiz.print(wriUser);// �����߼����print������ӡ���
				JOptionPane.showMessageDialog(print, "��ӡ�ɹ����ļ���λ��E�̵���ҵ���ϱ��.xls");
			}
		});
		close.addActionListener(new ActionListener() { // �رհ�ť

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // 0Ϊ�ر�

			}
		});
	}

}
