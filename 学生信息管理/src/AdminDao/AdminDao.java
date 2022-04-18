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
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM student";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
				Student student = new Student();
				student.setNumber(rs.getString("学号"));
				student.setName(rs.getString("姓名"));
				student.setSex(rs.getString("性别"));
				student.setBirth(rs.getString("出生年月"));
				student.setCollege(rs.getString("学院"));
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
	//添加数据
	public void addStudent(Student student) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "INSERT INTO student(学号,姓名,性别,出生年月,学院)"
					+ "VALUES(" + student.getNumber() + ",'" + student.getName()
					+ "','" + student.getSex() + "','" + student.getBirth()+ "','" + student.getCollege()+ "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				System.out.println("插入数据成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}	
	}
	//删除数据
	public void delStudent(String delNumber) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "DELETE FROM student WHERE 学号=" + delNumber;
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
             System.out.println("删除数据成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
	}
}
