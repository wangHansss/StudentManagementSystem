package ѧ����Ϣ����������;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Stu_manage_GUI_test extends Stu_manage_GUI{
	public static void main(String[] args){
		new Stu_manage_GUI_test().setVisible(true);
	}
	
	public Stu_manage_GUI_test(){
		super();
		queryFruitItem();
	}
	
	public void queryFruitItem() {
		String[] thead = new String[]{"ѧ��","����","�Ա�","��������","ѧԺ"};
		String[][] tbody = new String[][]{
				{"1","��","��","19990101","�����"},
				{"2","��","Ů","19990401","�����"},
				};
		TableModel data = new DefaultTableModel(tbody,thead);
		table.setModel(data);
	}

	public void showStudent() {
		System.out.println("��ʾ");
	}
	public void addStudent() {	
		System.out.println("����");
	}
	public void delStudent() {
		System.out.println("ɾ��");
	}
	public void updateStudent() {
		System.out.println("�޸�");
	}
}
