package Student;

import java.util.Date;

public class Student {
		private String number;			//ѧ��
		private String name;  			//����
		private String sex;  			//�Ա�
		private String birth;			//��������
		private String college; 		//ѧԺ
		
		public Student() {
		} 
		public Student(String number, String name, String sex, String birth, String college) {
			super();
			this.number = number;
			this.name = name;
			this.birth = birth;
			this.sex = sex;
			this.college = college;
		}
		
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getBirth() {
			return birth;
		}
		public void setBirth(String birth) {
			this.birth = birth;
		}
		public String getCollege() {
			return college;
		}
		public void setCollege(String college) {
			this.college = college;
		}
}
