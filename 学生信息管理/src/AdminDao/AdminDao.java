package AdminDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Student.Student;
import tools.JDBCUtils;
public class AdminDao {
	public ArrayList<Student> queryAllData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "SELECT * FROM student";
			rs = stmt.executeQuery(sql);
			// ��������
			while (rs.next()) {
				Student student = new Student();
				student.setNumber(rs.getString("ѧ��"));
				student.setName(rs.getString("����"));
				student.setSex(rs.getString("�Ա�"));
				student.setBirth(rs.getString("��������"));
				student.setCollege(rs.getString("ѧԺ"));
				list.add(student);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	//�������
	public void addStudent(Student student) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "INSERT INTO student(ѧ��,����,�Ա�,��������,ѧԺ)"
					+ "VALUES(" + student.getNumber() + ",'" + student.getName()
					+ "','" + student.getSex() + "','" + student.getBirth()+ "','" + student.getCollege()+ "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				System.out.println("�������ݳɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}	
	}
	//ɾ������
	public void delStudent(String delNumber) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "DELETE FROM student WHERE ѧ��=" + delNumber;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
             System.out.println("ɾ�����ݳɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
}
