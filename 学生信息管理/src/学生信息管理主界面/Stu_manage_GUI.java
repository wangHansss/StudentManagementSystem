package 学生信息管理主界面;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class Stu_manage_GUI extends JFrame {

	private JPanel contentPane;
	protected JTextField textField;
	protected JTextField textField_1;
	protected JTextField textField_2;
	protected JTextField textField_3;
	protected JTextField textField_4;
	
/*	protected JTextField updateFnumber = new JTextField(6);
	protected JTextField updateFname;
	protected JTextField updateFsex;
	protected JTextField updateFbirth;
	protected JTextField updateFcollege;
	*/
	private JScrollPane tablePane = new JScrollPane();//滚动视口

	protected JTable table1 = new JTable(); //水果列表	
	protected JTable table;
	
	JButton showButton = new JButton("\u663E\u793A");
	JButton addButton = new JButton("\u589E\u52A0");  
	JButton delButton = new JButton("\u5220\u9664");	
	JButton updateButton = new JButton("\u4FEE\u6539");	
	
	public Stu_manage_GUI() {
		addListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("\u6570\u636E\u5E93\u57FA\u672C\u64CD\u4F5C");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("隶书", Font.PLAIN, 60));
		lblNewLabel.setBounds(178, 33, 466, 62);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(52, 436, 48, 39);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(478, 436, 92, 39);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5B66\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(250, 436, 48, 39);
		contentPane.add(label_2);
		
		textField = new JTextField();				//姓名
		textField.setBounds(103, 446, 108, 21);
		contentPane.add(textField);
		textField.setColumns(10);
	
		textField_1 = new JTextField();				//学号
		textField_1.setColumns(10);
		textField_1.setBounds(301, 446, 127, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();				//出生年月
		textField_2.setColumns(10);
		textField_2.setBounds(567, 446, 156, 21);
		contentPane.add(textField_2);
	
		JLabel label_3 = new JLabel("\u6027\u522B\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(128, 485, 48, 39);
		contentPane.add(label_3);
	
		textField_3 = new JTextField();			//性别
		textField_3.setColumns(10);
		textField_3.setBounds(179, 495, 108, 21);
		contentPane.add(textField_3);
		
		JLabel label_4 = new JLabel("\u5B66\u9662\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(382, 485, 48, 39);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();			//学院
		textField_4.setColumns(10);
		textField_4.setBounds(433, 495, 108, 21);
		contentPane.add(textField_4);
		
		showButton.setFont(new Font("黑体", Font.PLAIN, 16));			//显示
		showButton.setBounds(630, 140, 93, 23);
		contentPane.add(showButton);
		
		addButton.setFont(new Font("黑体", Font.PLAIN, 16));		//增加
		addButton.setBounds(630, 208, 93, 23);
		contentPane.add(addButton);
			
		delButton.setFont(new Font("黑体", Font.PLAIN, 16));		//删除
		delButton.setBounds(630, 276, 93, 23);
		contentPane.add(delButton);
		
		updateButton.setFont(new Font("黑体", Font.PLAIN, 16));		//修改
		updateButton.setBounds(630, 345, 93, 23);
		contentPane.add(updateButton);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		contentPane.add(layeredPane);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(10, 74, 100, 31);
		contentPane.add(label_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 125, 481, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setTitle("欢迎使用");

		table1.getTableHeader().setReorderingAllowed(false);	//列不能移动
		table1.getTableHeader().setResizingAllowed(false); 	//不可拉动表格
		table1.setEnabled(false);							//不可更改数据
		tablePane.setBounds(50, 50, 500, 200);				

		tablePane.setViewportView(table1);					//视口装入表格
	}


	private void addListener() {
		showButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				showStudent();
			}
		});
		
		addButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				addStudent();
			}
		});
		
		delButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				delStudent();
			}
		});	
		
		updateButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				updateStudent();
			}
		});
	}

	public abstract void showStudent();
	public abstract void addStudent();
	public abstract void delStudent();
	public abstract void updateStudent();
}
