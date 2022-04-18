package service;

import java.util.ArrayList;
import java.util.Date;

import AdminDao.AdminDao;
import Student.Student;

public class AdminService {
	private AdminDao adminDao = new AdminDao();	
	//查询服务
	public ArrayList<Student> showStudent() {
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<Student> data = adminDao.queryAllData();
		//返回数据
		return data;
	} 
	//添加服务
	public boolean addStudent(String number, String name, String sex, String birth, String college) {
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<Student> data = showStudent();
		//使用输入的编号与所有数据对比
		for (int i = 0; i < data.size(); i++) {
			Student student = data.get(i);
			//如果存在重复编号数据，则添加不成功
			if(number.equals(student.getNumber())) {
				return false;
			}
		}
		//如果没有重复编号，将数据封装为Student对象
		Student thisStudent = new Student(number, name, sex, birth, college);
		//调用Dao层的添加数据方法
		adminDao.addStudent(thisStudent);
		//在添加数据后，返回添加成功
		return true;
	}
	//修改服务
	public boolean updateStudent(String number, String name, String sex, String birth, String college) {		
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<Student> data = showStudent();
		//使用输入的编号与所有数据对比
		for (int i = 0; i < data.size(); i++) {
			Student student = data.get(i);
			//如果存在相同编号数据，则可以更新
			if(number.equals(student.getNumber())) {
				//调用Dao层的删除指定编号数据方法
				adminDao.delStudent(number);
				//如果没有重复编号，将数据封装为FruitItem对象
				Student thisStudent = new Student(number, name, sex, birth, college);
				//调用Dao层的添加数据方法
				adminDao.addStudent(thisStudent);
				//在修改数据后，返回添加成功
				return true;
			}
		}
		//如果不存在相同编号数据，则不可以更新
		return false;
	}
	//删除服务
	public boolean delStudent(String delNumber) {		
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<Student> data = showStudent();
		//使用输入的编号与所有数据对比
		for (int i = 0; i < data.size(); i++) {
			Student student = data.get(i);
			//如果存在相同编号数据，则可以删除
			if(delNumber.equals(student.getNumber())) {
				//调用Dao层的删除指定编号数据方法
				adminDao.delStudent(delNumber);
				//在删除数据后，返回添加成功
				return true;
			}
		}
		//如果不存在相同编号数据，则不可以删除
		return false;
}
}
