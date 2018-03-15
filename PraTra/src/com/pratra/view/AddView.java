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
 * �������ڹ����������ݵ�GUI���� ������JavaBean
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
	//// ��μ������ı����С�Ĵ���

	JFrame f = new JFrame("����");

	JTextField[][] text1 = new JTextField[4][3];
	JTextField phtext = new JTextField(); // phone�����
	JTextField idtext = new JTextField(); // id�����
	JLabel[][] lab1 = new JLabel[4][3];
	JLabel phlab = new JLabel(); // phone��ǩ
	JLabel idlab = new JLabel("id��");// id��ǩ
	JButton btn = new JButton("ȷ��");

	public void init() {
		for (int x = 0; x < lab1.length; x++) { // ��forѭ����ߴ���ĸ�����

			for (int y = 0; y < text1[2].length; y++) {
				text1[x][y] = new JTextField();
				text1[x][y].setBounds(120 + 205 * x, 120 + 80 * y, 120, 30);
				f.add(text1[x][y]);
				text1[x][y].setFont(new Font("����", 2, 16));
			}
		}
		idtext.setBounds(120, 40, 120, 30);
		idtext.setFont(new Font("����", 2, 16));
		phtext.setFont(new Font("����", 2, 16));
		phtext.setBounds(325, 40, 120, 30);
		btn.setBounds(450, 380, 60, 40);

		for (int x = 0; x < lab1.length; x++) {

			for (int y = 0; y < lab1[2].length; y++) {
				lab1[x][y] = new JLabel();
				lab1[x][y].setFont(new Font("����", 2, 16));
				lab1[x][y].setBounds(30 + 210 * x, 120 + 80 * y, 100, 30);
				f.add(lab1[x][y]);
			}
		}
		lab1[0][0].setText("״̬��");
		lab1[0][1].setText("��ҵλ�ã�");
		lab1[0][2].setText("���ţ�");
		lab1[1][0].setText("�⻧���ƣ�");
		lab1[1][1].setText("��ҵ���ͣ�");
		lab1[1][2].setText("���������");

		lab1[2][0].setText("���������");
		lab1[2][1].setText("��̯�����");
		lab1[2][2].setText("���");

		lab1[3][0].setText("��ͬ��ţ�");
		lab1[3][1].setText("��ͬ���գ�");
		lab1[3][2].setText("��ֹͬ�գ�");
		phlab.setText("��ϵ�绰:");
		phlab.setFont(new Font("����", 2, 16));
		phlab.setBounds(240, 40, 100, 30);
		idlab.setBounds(80, 40, 50, 30);
		idlab.setFont(new Font("����", 2, 16));
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
				wriUser.setState(state); // �����ݸ���WriUser�����������
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
				eventHandleControl.insert(wriUser);// ����eventHandleControl��insert������ִ�ж����ݿ�����Ӳ���
				JOptionPane.showMessageDialog(f, "������");
			}
		});

		f.setVisible(true);
	}

}
