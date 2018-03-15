/**
 * 2015-07-09
 * @author ��ΰ��
 * ��½����
 * */
package com.pratra.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.pratra.control.LoginControl;

import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * @author ��ΰ�� ��¼����
 */
public class LoginView extends JFrame {
	public LoginControl loginControl = new LoginControl();
	// private HomeView homeView;
	private JFrame frame = new JFrame("��ҵ����ϵͳ");
	private JButton[] btn = new JButton[3];
	private JLabel[] lab = new JLabel[4];
	private JTextField[] text = new JTextField[2];

	private final JDesktopPane desktopPane = new JDesktopPane();
	private final JLabel lblNewLabel = new JLabel("New label"); // ͼƬ

	// ��֤�� varification code
	private JTextField[] varText = new JTextField[4]; // ��֤��������

	public LoginView() {
		// frame.setVisible(true);
		super();
		intiGUI();

		frame.setResizable(false);
		frame.setVisible(true);
	}

	private void intiGUI() {

		frame.getContentPane().setLayout(null);
		///////////// ��֤���ı���//////
		for (int i = 0; i < varText.length; i++) { // ��forѭ����ߴ���ĸ�����
			varText[i] = new JTextField(3);
			varText[i].setFont(new Font("����", 1, 18));// �������壬���壬18������
			varText[i].setBounds(80 + 50 * i, 380, 50, 50);
			frame.getContentPane().add(varText[i]);
		}
		//////////////// ��ǩ////////////
		for (int i = 0; i < lab.length; i++) {
			lab[i] = new JLabel();
			lab[i].setForeground(Color.white);
			lab[i].setFont(new Font("����", Font.BOLD | Font.ITALIC, 22));
			frame.getContentPane().add(lab[i]);
		}
		lab[0].setBounds(129, 200, 81, 72); // �û�����ǩ
		lab[1].setBounds(139, 280, 71, 60); // �����ǩ
		lab[2].setBounds(290, 380, 80, 50); // ��֤��
		String data = loginControl.run();
		lab[2].setText(data);
		lab[3].setBounds(291, 619, 194, 93); // ���·���ǩ
		lab[0].setText("�û���");
		lab[1].setText("����");
		lab[3].setText("�û���¼ϵͳ��");
		///////////// �ı���//////////////
		for (int i = 0; i < text.length; i++) {
			text[i] = new JTextField();
			frame.getContentPane().add(text[i]);
		}
		text[0].setBounds(213, 220, 126, 40); // �û����ı�
		text[1].setBounds(213, 290, 126, 40); // �����ı�
		//////////////// ��ť/////////////////////
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			btn[i].setFont(new Font("����", Font.BOLD, 18));
			frame.getContentPane().add(btn[i]);
		}
		btn[0].setText("��¼");
		btn[1].setText("����");
		btn[2].setForeground(Color.white);
		btn[2].setText("<html><body>�������<br/>��һ��</body></html>");
		Color c = new Color(125, 125, 125);
		btn[2].setBackground(c);

		btn[0].setBounds(108, 480, 88, 48); // ��½��ť
		btn[1].setBounds(260, 480, 100, 48);// ���ð�ť
		btn[2].setBounds(370, 380, 120, 50);// ��֤�밴ť

		frame.getContentPane().add(desktopPane);
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource(
				"/\u7269\u4E1A\u8D44\u6599/1e6f7a7e52ecef2275e1397ba9b66b53083e3084603a6-pZ7F6s_fw658.jpg")));
		lblNewLabel.setBounds(0, 0, 495, 764);

		desktopPane.setBounds(0, -27, 495, 739);
		desktopPane.add(lblNewLabel); // ��ͼƬ

		frame.setSize(501, 750);
		frame.setLocation(650, 150);

		btn[0].addActionListener(new ActionListener() { // ��¼��ť�ļ�������

			public void actionPerformed(ActionEvent e) {
				try {
					String data = getInputAndValidate();// ��ȡ�������
					int i = JOptionPane.showConfirmDialog(null, "�Ƿ񱸷�����", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null);
					if (i == JOptionPane.YES_NO_OPTION) {
						HomeView farme = new HomeView();
						setVisible(true);
						frame.setVisible(false); // ��HomeView�����ͬʱ�ر�LoginView
					} else {
						HomeView farme = new HomeView();
						setVisible(true);
						frame.setVisible(false); // ��HomeView�����ͬʱ�ر�LoginView
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(LoginView.this, "��֤�����");
				} catch (RuntimeException e2) {
					JOptionPane.showMessageDialog(LoginView.this, "��֤�����");
				}
			}

		});
		btn[1].addActionListener(new ActionListener() { // ���õļ�������

			public void actionPerformed(ActionEvent e) {// �����������������
				text[0].setText("");
				text[1].setText("");
				for (int i = 0; i < varText.length; i++) {
					varText[i].setText("");
				}
				lab[3].setText("�û���¼ϵͳ!");
				String data = loginControl.run();
				lab[2].setText(data);

			}
		});
		btn[2].addActionListener(new ActionListener() { // �����������һ�š��ļ�������

			@Override
			public void actionPerformed(ActionEvent e) {// ���ˢ��
				lab[2].setText("");
				String num = loginControl.run();
				lab[2].setText(num); // ������֤��

			}
		});
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // ��ʾϵͳ�˳�
			}
		});

	}

	private String getInputAndValidate() { // ��ȡ����������Ա��ж���֤���Ƿ���ȷ
		String result = "";

		for (int x = 0; x < varText.length; x++) {
			String input = varText[x].getText();
			Integer inputNum = Integer.parseInt(input);// ����Ĳ������ֵĻ�����NumberFormatException����
			if (result.contains(inputNum + "")) {
				throw new RuntimeException("�����ظ���");// �����ظ��Ļ����׳��쳣
			}
			result += input;
		}
		return result;
	}

}
