package 学生信息管理;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;

public abstract class Stu_entry_GUI extends JFrame {
	private JPanel contentPane;
	public Stu_entry_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("欢迎使用");

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JPanel panel_7 = new JPanel();
		panel.add(panel_7);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\uFF01");
		label.setFont(new Font("华文行楷", Font.PLAIN, 58));
		label.setForeground(SystemColor.textHighlight);
		panel_4.add(label, BorderLayout.NORTH);

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("\u70B9\u51FB\u8FDB\u5165");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		panel_5.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				showAdminDialog();
			}
		});

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Penguins.jpg"));
		panel_6.add(label_1);
	}
	public abstract void showAdminDialog();
}


