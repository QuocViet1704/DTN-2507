package com.vti.Exercise;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Group;

public class Exercise4 {
	Scanner sc = new Scanner(System.in);

	public void Question1() {
		String chuoi = sc.nextLine();
		chuoi.replace(" ", "");
		int demChuoi = chuoi.length();

		System.out.println("Số lượng từ trong xâu là: " + demChuoi);
	}

	public void Question2() {
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println("Sau khi nối 2 xâu ta được: " + s1.concat(" ").concat(s2));
	}

	public void Question3() {
		String s = sc.nextLine();
		if (Character.isLowerCase(s.charAt(0))) {
			String result = s.substring(0, 1).toUpperCase() + s.substring(1);
			System.out.println("Tên của bạn là: " + result);
		}
	}

	public void Question4() {
		String name = sc.nextLine();
		String[] s = name.split(" ");
		char[] a = {};
		int index = 1;
		for (String s1 : s) {
			a = s1.toCharArray();
			for (int i = 0; i < a.length; ++i) {
				System.out.println("Ký tự thứ " + index + " là " + a[i]);
				index++;
			}
		}
	}

	public void Question5() {
		System.out.print("Nhập họ của bạn: ");
		String lastName = sc.nextLine();
		System.out.print("Nhập tên của bạn: ");
		String firstName = sc.nextLine();

		System.out.println("Họ và tên: " + lastName.concat(" ").concat(firstName));
	}

	public void Question6() {
		String name = sc.nextLine();
		String[] hoTen = name.split(" ");
		if (hoTen.length == 2) {
			System.out.println("Họ là: " + hoTen[0]);
			System.out.println("Tên là: " + hoTen[1]);
		}

		if (hoTen.length == 3) {
			System.out.println("Họ là: " + hoTen[0]);
			System.out.println("Tên đệm là: " + hoTen[1]);
			System.out.println("Tên là: " + hoTen[2]);
		}

		if (hoTen.length > 3) {
			System.out.println("Họ là: " + hoTen[0]);
			System.out.print("Tên đệm là: ");
			for (int i = 1; i < hoTen.length - 1; ++i) {
				System.out.print(" " + hoTen[i]);
			}
			System.out.println("\nTên là: " + hoTen[hoTen.length - 1]);
		}
	}

	public void Question8() {
		Program program = new Program();
		List<Group> list = Group.getAllGroups();

		for (Group grp : list) {
			if (grp.getGroupName().contains("Java")) {
				System.out.println("Group: " + grp.getGroupID() + " " + grp.getGroupName() + " " + grp.getCreatorID());
			}
		}
	}

	public void Question10() {
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		int flag = 0;

		if (s1.length() != s2.length()) {
			System.out.println("Hai chuỗi không phải là đảo ngược của nhau!");
			System.out.println(s1.length() + " " + s2.length());
		} else {
			int j = a2.length - 1;

			for (int i = 0; i < a1.length; ++i) {
				if (a1[i] == a2[j]) {
					flag++;
				} else {
					System.out.println(i + " " + j);
					System.out.println("Hai chuỗi không phải là đảo ngược của nhau!");
					break;
				}
				j--;
			}

			if (flag == s1.length()) {
				System.out.println("Hai chuỗi là đảo ngược của nhau");
			}
		}
	}

	public void Question11() {
		String s = sc.nextLine();
		char[] a = s.toCharArray();
		int count = 0;

		for (int i = 0; i < a.length; ++i) {
			if (a[i] == 'a') {
				count++;
			}
		}
		System.out.println("Số lần xuất hiện ký tự a trong chuỗi: " + count);
	}

	public void Question12() {
		String s = sc.nextLine();
		String[] temp = s.split("");
		String result = "";
		for (int i = temp.length - 1; i >= 0; --i) {
			result = result.concat(temp[i]);
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		Exercise4 ex = new Exercise4();
		ex.Question1();
		ex.Question2();
		ex.Question3();
		ex.Question4();
		ex.Question5();
		ex.Question6();
		ex.Question8();
		ex.Question10();
		ex.Question11();
		ex.Question12();

	}
}
