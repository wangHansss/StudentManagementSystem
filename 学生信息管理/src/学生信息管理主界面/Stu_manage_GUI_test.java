package 学生信息管理主界面;

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
		String[] thead = new String[]{"学号","姓名","性别","出生年月","学院"};
		String[][] tbody = new String[][]{
				{"1","王","男","19990101","计算机"},
				{"2","张","女","19990401","计算机"},
				};
		TableModel data = new DefaultTableModel(tbody,thead);
		table.setModel(data);
	}

	public void showStudent() {
		System.out.println("显示");
	}
	public void addStudent() {	
		System.out.println("增加");
	}
	public void delStudent() {
		System.out.println("删除");
	}
	public void updateStudent() {
		System.out.println("修改");
	}
}
