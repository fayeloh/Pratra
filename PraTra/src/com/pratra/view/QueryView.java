package com.pratra.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.pratra.entity.WriUser;

/**
 * ��ѯ���� ����Ҫ��ѯ����Ϣ
 */

public class QueryView extends JFrame {
	public static void main(String[] args) {
		new QueryView();
	}

	JLabel[][] lab1 = new JLabel[4][3];
	JLabel[][] lab2 = new JLabel[4][3];

	public void init(WriUser wriUser) {

		this.setLayout(null);
		for (int x = 0; x < lab1.length; x++) {// forѭ������ߴ���ĸ�����

			for (int y = 0; y < lab1[1].length; y++) {
				lab1[x][y] = new JLabel();
				lab1[x][y].setFont(new Font("����", 2, 14));
				lab1[x][y].setBounds(30 + 150 * x, 50 + 50 * y, 80, 30);
				this.add(lab1[x][y]);
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

		for (int i = 0; i < lab2.length; i++) {

			for (int j = 0; j < lab2[1].length; j++) {
				lab2[i][j] = new JLabel();
				lab2[i][j].setFont(new Font("����", 2, 14));
				lab2[i][j].setBounds(100 + 150 * i, 50 + 50 * j, 80, 30);
				this.add(lab2[i][j]);
			}
		}
		lab2[0][0].setText(wriUser.getState());
		lab2[0][1].setText(wriUser.getPlace());
		lab2[0][2].setText(wriUser.getNo());
		lab2[1][0].setText(wriUser.getName());
		lab2[1][1].setText(wriUser.getKind());
		lab2[1][2].setText(wriUser.getStrar());

		lab2[2][0].setText(wriUser.getInspa());
		lab2[2][1].setText(wriUser.getDiar());
		lab2[2][2].setText(wriUser.getRent());

		lab2[3][0].setText(wriUser.getCono());
		lab2[3][1].setText(wriUser.getCost());
		lab2[3][2].setText(wriUser.getCofi());
		this.setBounds(400, 400, 700, 300);
		this.setVisible(true);
	}

}
