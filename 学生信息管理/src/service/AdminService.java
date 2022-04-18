package service;

import java.util.ArrayList;
import java.util.Date;

import AdminDao.AdminDao;
import Student.Student;

public class AdminService {
	private AdminDao adminDao = new AdminDao();	
	//��ѯ����
	public ArrayList<Student> showStudent() {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<Student> data = adminDao.queryAllData();
		//��������
		return data;
	} 
	//��ӷ���
	public boolean addStudent(String number, String name, String sex, String birth, String college) {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<Student> data = showStudent();
		//ʹ������ı�����������ݶԱ�
		for (int i = 0; i < data.size(); i++) {
			Student student = data.get(i);
			//��������ظ�������ݣ�����Ӳ��ɹ�
			if(number.equals(student.getNumber())) {
				return false;
			}
		}
		//���û���ظ���ţ������ݷ�װΪStudent����
		Student thisStudent = new Student(number, name, sex, birth, college);
		//����Dao���������ݷ���
		adminDao.addStudent(thisStudent);
		//��������ݺ󣬷�����ӳɹ�
		return true;
	}
	//�޸ķ���
	public boolean updateStudent(String number, String name, String sex, String birth, String college) {		
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<Student> data = showStudent();
		//ʹ������ı�����������ݶԱ�
		for (int i = 0; i < data.size(); i++) {
			Student student = data.get(i);
			//���������ͬ������ݣ�����Ը���
			if(number.equals(student.getNumber())) {
				//����Dao���ɾ��ָ��������ݷ���
				adminDao.delStudent(number);
				//���û���ظ���ţ������ݷ�װΪFruitItem����
				Student thisStudent = new Student(number, name, sex, birth, college);
				//����Dao���������ݷ���
				adminDao.addStudent(thisStudent);
				//���޸����ݺ󣬷�����ӳɹ�
				return true;
			}
		}
		//�����������ͬ������ݣ��򲻿��Ը���
		return false;
	}
	//ɾ������
	public boolean delStudent(String delNumber) {		
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<Student> data = showStudent();
		//ʹ������ı�����������ݶԱ�
		for (int i = 0; i < data.size(); i++) {
			Student student = data.get(i);
			//���������ͬ������ݣ������ɾ��
			if(delNumber.equals(student.getNumber())) {
				//����Dao���ɾ��ָ��������ݷ���
				adminDao.delStudent(delNumber);
				//��ɾ�����ݺ󣬷�����ӳɹ�
				return true;
			}
		}
		//�����������ͬ������ݣ��򲻿���ɾ��
		return false;
}
}
