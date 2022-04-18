package contronller;
import 学生信息管理.Stu_entry_GUI;

public class Main_Contronller extends Stu_entry_GUI{
	public void showAdminDialog() {
		// TODO Auto-generated method stub
		new Stu_manage_GUI_contronller(this, true).setVisible(true);
	}
}
