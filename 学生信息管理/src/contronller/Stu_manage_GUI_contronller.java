package contronller;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import ѧ����Ϣ����������.Stu_manage_GUI;
import Student.Student;
import service.AdminService;

public class Stu_manage_GUI_contronller extends Stu_manage_GUI{
	//��������࣬�ṩ�������ܷ���
	private AdminService adminService = new AdminService();	
	//���췽��
	public Stu_manage_GUI_contronller() {
		super();
	}
	public Stu_manage_GUI_contronller(Frame owner, boolean modal) {
		super();		//  �˴�super���ô�������	
		//��������ʱչʾ����
		showStudent();
	}	
	//��ѯ����
	@Override
	public void showStudent() {
		//������ͷ
		String[] thead = {"ѧ��","����","�Ա�","��������","ѧԺ"};

		//����adminService�Ĳ�ѯ����
		ArrayList<Student> dataList = adminService.showStudent();
		//����list2Array����������ѯ���ļ���תΪ���飬����ΪJTable��ֵ
		String[][] tbody = list2Array(dataList);
		//����ѯ���Ľ��Ϊtable��ֵ
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);
	}
	//��������תΪ��ά���鷽��
	public String[][] list2Array(ArrayList<Student> list){		
		//����FruitItem��model�뼯�����ݶ���JTable�����ݶ�ά����
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
	//��ӷ���
	@Override
	public void addStudent() {
		//��ȡ����
		String addNumber = textField_1.getText();
		String addName = textField.getText();
		String addSex = textField_3.getText();
		String addBirth = textField_2.getText();
		String addCollege = textField_4.getText();
		//����adminService����ӷ���
		boolean addSuccess = adminService.addStudent(addNumber, addName,
				addSex, addBirth,addCollege);             
		//�����ӳɹ�
		if(addSuccess) {
			//��Ӻ�ˢ�±��
			showStudent();
		}else {
			//û����ӳɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "ѧ��ѧ�Ų����ظ�,��������!");
		}
	}
	//�޸ķ���
	
	public void updateStudent() {		
		//��ȡ����
		String updateNumber = textField_1.getText();
		String updateName = textField.getText();
		String updateSex = textField_3.getText();
		String updateBirth = textField_2.getText();
		String updateCollege = textField_4.getText();
		//����adminService���޸ķ���
		boolean updateSuccess = adminService.updateStudent(updateNumber,
				updateName, updateSex, updateBirth, updateCollege);		
		//����޸ĳɹ�
		if(updateSuccess) {
			//�޸ĺ�ˢ�±��
			showStudent();
		}else {
			//û���޸ĳɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "û�����ѧ�ŵ�ѧ��,��������!");
		}
	}  
	//ɾ������
	@Override
	public void delStudent() {		
		//��ȡ����
		String delNumber = textField_1.getText();
		//����adminService��ɾ������
		boolean delSuccess = adminService.delStudent(delNumber);		
		//���ɾ���ɹ�
		if(delSuccess) {
			//ɾ����ˢ�±��
			showStudent();
		}else {
			//û��ɾ���ɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "û�����ѧ�ŵ�ѧ��,��������!");
		}
	}
}

