package com.pratra.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.pratra.control.EventHandleControl;
import com.pratra.entity.WriUser;

/**
 * 本类用于构建增加数据的GUI窗体 技术：JavaBean
 */
public class AddView extends JFrame {
	private EventHandleControl eventHandleControl;
	private WriUser wriUser;
	AddMiniView miniView;

	public static void main(String[] args) {
		AddView a = new AddView();
	}

	public AddView() {
		init();
		eventHandleControl = new EventHandleControl();
		wriUser = new WriUser();
	}
	//// 如何简化设置文本框大小的代码

	JFrame f = new JFrame("增加");

	JTextField[][] text1 = new JTextField[4][3];
	JTextField phtext = new JTextField(); // phone输入框
	JTextField idtext = new JTextField(); // id输入框
	JLabel[][] lab1 = new JLabel[4][3];
	JLabel phlab = new JLabel(); // phone标签
	JLabel idlab = new JLabel("id：");// id标签
	JButton btn = new JButton("确定");

	public void init() {
		for (int x = 0; x < lab1.length; x++) { // 用for循环提高代码的复用性

			for (int y = 0; y < text1[2].length; y++) {
				text1[x][y] = new JTextField();
				text1[x][y].setBounds(120 + 205 * x, 120 + 80 * y, 120, 30);
				f.add(text1[x][y]);
				text1[x][y].setFont(new Font("宋体", 2, 16));
			}
		}
		idtext.setBounds(120, 40, 120, 30);
		idtext.setFont(new Font("宋体", 2, 16));
		phtext.setFont(new Font("宋体", 2, 16));
		phtext.setBounds(325, 40, 120, 30);
		btn.setBounds(450, 380, 60, 40);

		for (int x = 0; x < lab1.length; x++) {

			for (int y = 0; y < lab1[2].length; y++) {
				lab1[x][y] = new JLabel();
				lab1[x][y].setFont(new Font("宋体", 2, 16));
				lab1[x][y].setBounds(30 + 210 * x, 120 + 80 * y, 100, 30);
				f.add(lab1[x][y]);
			}
		}
		lab1[0][0].setText("状态：");
		lab1[0][1].setText("物业位置：");
		lab1[0][2].setText("房号：");
		lab1[1][0].setText("租户名称：");
		lab1[1][1].setText("物业类型：");
		lab1[1][2].setText("建筑面积：");

		lab1[2][0].setText("套内面积：");
		lab1[2][1].setText("公摊面积：");
		lab1[2][2].setText("租金：");

		lab1[3][0].setText("合同编号：");
		lab1[3][1].setText("合同起日：");
		lab1[3][2].setText("合同止日：");
		phlab.setText("联系电话:");
		phlab.setFont(new Font("宋体", 2, 16));
		phlab.setBounds(240, 40, 100, 30);
		idlab.setBounds(80, 40, 50, 30);
		idlab.setFont(new Font("宋体", 2, 16));
		f.add(idlab);
		f.add(idtext);
		f.add(phlab);
		f.add(phtext);
		f.add(btn);
		f.setLayout(null);

		f.setLocation(300, 300);
		f.setSize(1000, 500);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String state = text1[0][0].getText();
				String place = text1[0][1].getText();
				String no = text1[0][2].getText();

				String name = text1[1][0].getText();
				String kind = text1[1][1].getText();
				String strar = text1[1][2].getText();

				String inspa = text1[2][0].getText();
				String diar = text1[2][1].getText();
				String rent = text1[2][2].getText();

				String cono = text1[3][0].getText();
				String cost = text1[3][1].getText();
				String cofi = text1[3][2].getText();

				String id = idtext.getText();
				String phone = phtext.getText();
				wriUser.setState(state); // 将数据付给WriUser这个数据载体
				wriUser.setPlace(place);
				wriUser.setNo(no);
				wriUser.setName(name);
				wriUser.setKind(kind);
				wriUser.setStrar(strar);
				wriUser.setInspa(inspa);
				wriUser.setDiar(diar);
				wriUser.setRent(rent);
				wriUser.setCono(cono);
				wriUser.setCost(cost);
				wriUser.setCofi(cofi);
				wriUser.setPhone(phone);
				wriUser.setId(id);
				eventHandleControl.insert(wriUser);// 调用eventHandleControl的insert方法，执行对数据库的增加操作
				JOptionPane.showMessageDialog(f, "已增加");
			}
		});

		f.setVisible(true);
	}

}
