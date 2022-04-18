package contronller;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import 学生信息管理主界面.Stu_manage_GUI;
import Student.Student;
import service.AdminService;

public class Stu_manage_GUI_contronller extends Stu_manage_GUI{
	//定义服务类，提供完整功能服务
	private AdminService adminService = new AdminService();	
	//构造方法
	public Stu_manage_GUI_contronller() {
		super();
	}
	public Stu_manage_GUI_contronller(Frame owner, boolean modal) {
		super();		//  此处super的用处？？？	
		//创建对象时展示数据
		showStudent();
	}	
	//查询方法
	@Override
	public void showStudent() {
		//定义表格头
		String[] thead = {"学号","姓名","性别","出生年月","学院"};

		//调用adminService的查询服务
		ArrayList<Student> dataList = adminService.showStudent();
		//调用list2Array方法，将查询到的集合转为数组，方便为JTable赋值
		String[][] tbody = list2Array(dataList);
		//将查询到的结果为table赋值
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);
	}
	//集合数据转为二维数组方法
	public String[][] list2Array(ArrayList<Student> list){		
		//根据FruitItem的model与集合数据定义JTable的数据二维数组
		String[][] tbody = new String[list.size()][5];	
		for (int i = 0; i < list.size(); i++) {
			Student student = list.get(i);
			tbody[i][0] = student.getNumber();
			tbody[i][1] = student.getName();
			tbody[i][2] = student.getSex();
			tbody[i][3] = student.getBirth();
			tbody[i][4] = student.getCollege();
		}		
		return tbody;
	}
	//添加方法
	@Override
	public void addStudent() {
		//获取数据
		String addNumber = textField_1.getText();
		String addName = textField.getText();
		String addSex = textField_3.getText();
		String addBirth = textField_2.getText();
		String addCollege = textField_4.getText();
		//调用adminService的添加服务
		boolean addSuccess = adminService.addStudent(addNumber, addName,
				addSex, addBirth,addCollege);             
		//如果添加成功
		if(addSuccess) {
			//添加后刷新表格
			showStudent();
		}else {
			//没有添加成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "学生学号不能重复,请检查数据!");
		}
	}
	//修改方法
	
	public void updateStudent() {		
		//获取数据
		String updateNumber = textField_1.getText();
		String updateName = textField.getText();
		String updateSex = textField_3.getText();
		String updateBirth = textField_2.getText();
		String updateCollege = textField_4.getText();
		//调用adminService的修改服务
		boolean updateSuccess = adminService.updateStudent(updateNumber,
				updateName, updateSex, updateBirth, updateCollege);		
		//如果修改成功
		if(updateSuccess) {
			//修改后刷新表格
			showStudent();
		}else {
			//没有修改成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "没有这个学号的学生,请检查数据!");
		}
	}  
	//删除方法
	@Override
	public void delStudent() {		
		//获取数据
		String delNumber = textField_1.getText();
		//调用adminService的删除服务
		boolean delSuccess = adminService.delStudent(delNumber);		
		//如果删除成功
		if(delSuccess) {
			//删除后刷新表格
			showStudent();
		}else {
			//没有删除成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "没有这个学号的学生,请检查数据!");
		}
	}
}

