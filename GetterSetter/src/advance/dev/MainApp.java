package advance.dev;

import java.lang.reflect.Array;
import java.util.Scanner;

class Student {
	private String name;
	private int age;
	private String address;
	private String phoneNumber;
	private float GPA;

	// Getter và Setter cho thuộc tính name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Getter và Setter cho thuộc tính age
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else {
			System.out.println("Tuổi phải là số nguyên lớn hơn 0.");
		}
	}

	// Getter và Setter cho thuộc tính address
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Getter và Setter cho thuộc tính phoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// Getter và Setter cho thuộc tính GPA
	public float getGPA() {
		return GPA;
	}

	public void setGPA(float GPA) {
		if (GPA >= 0) {
			this.GPA = GPA;
		} else {
			System.out.println("Điểm trung bình phải là số thực lớn hơn hoặc bằng 0.");
		}
	}
}

public class MainApp {

	// Phương thức nhập thông tin cho một sinh viên từ bàn phím
	public static Student inputStudent(Scanner scanner) {
		Student student = new Student();

		System.out.print("Nhập tên: ");
		student.setName(scanner.nextLine());

		System.out.print("Nhập tuổi: ");
		student.setAge(scanner.nextInt());
		scanner.nextLine(); // Đọc ký tự new line sau khi đọc số tuổi

		System.out.print("Nhập địa chỉ: ");
		student.setAddress(scanner.nextLine());

		System.out.print("Nhập số điện thoại: ");
		student.setPhoneNumber(scanner.nextLine());

		System.out.print("Nhập điểm trung bình: ");
		student.setGPA(scanner.nextFloat());
		scanner.nextLine(); // Đọc ký tự new line sau khi đọc điểm trung bình

		return student;
	}

	// Phương thức in thông tin của một sinh viên
	public static void printStudent(Student student) {
		System.out.println("Tên: " + student.getName());
		System.out.println("Tuổi: " + student.getAge());
		System.out.println("Địa chỉ: " + student.getAddress());
		System.out.println("Số điện thoại: " + student.getPhoneNumber());
		System.out.println("Điểm trung bình: " + student.getGPA());
		System.out.println();
	}

	// Phương thức nhập thông tin cho danh sách sinh viên từ bàn phím
	public static Student[] inputStudents(Scanner scanner, int numStudents) {
		Student[] students = new Student[numStudents];

		for (int i = 0; i < numStudents; i++) {
			System.out.println("Nhập thông tin cho sinh viên thứ " + (i + 1) + ":");
			students[i] = inputStudent(scanner);
		}

		return students;
	}

	// Phương thức in danh sách sinh viên
	public static void printStudents(Student[] students) {
		System.out.println("Danh sách sinh viên:");
		for (Student student : students) {
			printStudent(student);
		}
	}

	// Phương thức sắp xếp danh sách sinh viên theo điểm trung bình tăng dần
	public static void sortStudentsByGPA(Student[] students) {
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = i + 1; j < students.length; j++) {
				if (students[i].getGPA() > students[j].getGPA()) {
					// Hoán đổi vị trí của hai sinh viên
					Student temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Nhập số lượng sinh viên
		System.out.print("Nhập số lượng sinh viên: ");
		int numStudents = scanner.nextInt();
		scanner.nextLine(); // Đọc ký tự new line sau khi đọc số lượng sinh viên

		// Nhập thông tin cho danh sách sinh viên
		Student[] students = inputStudents(scanner, numStudents);

		// In danh sách sinh viên
		printStudents(students);

		// Sắp xếp danh sách sinh viên theo điểm trung bình tăng dần
		sortStudentsByGPA(students);

		// In danh sách sinh viên sau khi được sắp xếp
		System.out.println("Danh sách sinh viên sau khi sắp xếp theo điểm trung bình:");
		printStudents(students);

		scanner.close();

	}
}
