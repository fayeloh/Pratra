/**
 * 2015-07-09
 * @author 罗伟凡
 * 登陆界面
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
 * @author 罗伟凡 登录界面
 */
public class LoginView extends JFrame {
	public LoginControl loginControl = new LoginControl();
	// private HomeView homeView;
	private JFrame frame = new JFrame("物业管理系统");
	private JButton[] btn = new JButton[3];
	private JLabel[] lab = new JLabel[4];
	private JTextField[] text = new JTextField[2];

	private final JDesktopPane desktopPane = new JDesktopPane();
	private final JLabel lblNewLabel = new JLabel("New label"); // 图片

	// 验证码 varification code
	private JTextField[] varText = new JTextField[4]; // 验证码的输入框

	public LoginView() {
		// frame.setVisible(true);
		super();
		intiGUI();

		frame.setResizable(false);
		frame.setVisible(true);
	}

	private void intiGUI() {

		frame.getContentPane().setLayout(null);
		///////////// 验证码文本框//////
		for (int i = 0; i < varText.length; i++) { // 用for循环提高代码的复用性
			varText[i] = new JTextField(3);
			varText[i].setFont(new Font("宋体", 1, 18));// 设置字体，宋体，18号字体
			varText[i].setBounds(80 + 50 * i, 380, 50, 50);
			frame.getContentPane().add(varText[i]);
		}
		//////////////// 标签////////////
		for (int i = 0; i < lab.length; i++) {
			lab[i] = new JLabel();
			lab[i].setForeground(Color.white);
			lab[i].setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 22));
			frame.getContentPane().add(lab[i]);
		}
		lab[0].setBounds(129, 200, 81, 72); // 用户名标签
		lab[1].setBounds(139, 280, 71, 60); // 密码标签
		lab[2].setBounds(290, 380, 80, 50); // 验证码
		String data = loginControl.run();
		lab[2].setText(data);
		lab[3].setBounds(291, 619, 194, 93); // 右下方标签
		lab[0].setText("用户名");
		lab[1].setText("密码");
		lab[3].setText("用户登录系统！");
		///////////// 文本框//////////////
		for (int i = 0; i < text.length; i++) {
			text[i] = new JTextField();
			frame.getContentPane().add(text[i]);
		}
		text[0].setBounds(213, 220, 126, 40); // 用户名文本
		text[1].setBounds(213, 290, 126, 40); // 密码文本
		//////////////// 按钮/////////////////////
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton();
			btn[i].setFont(new Font("宋体", Font.BOLD, 18));
			frame.getContentPane().add(btn[i]);
		}
		btn[0].setText("登录");
		btn[1].setText("重置");
		btn[2].setForeground(Color.white);
		btn[2].setText("<html><body>看不清楚<br/>换一张</body></html>");
		Color c = new Color(125, 125, 125);
		btn[2].setBackground(c);

		btn[0].setBounds(108, 480, 88, 48); // 登陆按钮
		btn[1].setBounds(260, 480, 100, 48);// 重置按钮
		btn[2].setBounds(370, 380, 120, 50);// 验证码按钮

		frame.getContentPane().add(desktopPane);
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource(
				"/\u7269\u4E1A\u8D44\u6599/1e6f7a7e52ecef2275e1397ba9b66b53083e3084603a6-pZ7F6s_fw658.jpg")));
		lblNewLabel.setBounds(0, 0, 495, 764);

		desktopPane.setBounds(0, -27, 495, 739);
		desktopPane.add(lblNewLabel); // 加图片

		frame.setSize(501, 750);
		frame.setLocation(650, 150);

		btn[0].addActionListener(new ActionListener() { // 登录按钮的监听机制

			public void actionPerformed(ActionEvent e) {
				try {
					String data = getInputAndValidate();// 获取输入的数
					int i = JOptionPane.showConfirmDialog(null, "是否备份数据", "提示信息", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null);
					if (i == JOptionPane.YES_NO_OPTION) {
						HomeView farme = new HomeView();
						setVisible(true);
						frame.setVisible(false); // 打开HomeView界面的同时关闭LoginView
					} else {
						HomeView farme = new HomeView();
						setVisible(true);
						frame.setVisible(false); // 打开HomeView界面的同时关闭LoginView
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(LoginView.this, "验证码错误");
				} catch (RuntimeException e2) {
					JOptionPane.showMessageDialog(LoginView.this, "验证码错误");
				}
			}

		});
		btn[1].addActionListener(new ActionListener() { // 重置的监听机制

			public void actionPerformed(ActionEvent e) {// 点击后清空输入框内容
				text[0].setText("");
				text[1].setText("");
				for (int i = 0; i < varText.length; i++) {
					varText[i].setText("");
				}
				lab[3].setText("用户登录系统!");
				String data = loginControl.run();
				lab[2].setText(data);

			}
		});
		btn[2].addActionListener(new ActionListener() { // “看不清楚换一张”的监听机制

			@Override
			public void actionPerformed(ActionEvent e) {// 点击刷新
				lab[2].setText("");
				String num = loginControl.run();
				lab[2].setText(num); // 更新验证码

			}
		});
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 表示系统退出
			}
		});

	}

	private String getInputAndValidate() { // 获取输入的数，以便判断验证码是否正确
		String result = "";

		for (int x = 0; x < varText.length; x++) {
			String input = varText[x].getText();
			Integer inputNum = Integer.parseInt(input);// 输入的不是数字的话会有NumberFormatException错误
			if (result.contains(inputNum + "")) {
				throw new RuntimeException("数字重复了");// 数字重复的话会抛出异常
			}
			result += input;
		}
		return result;
	}

}
