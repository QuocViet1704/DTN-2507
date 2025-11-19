package com.vti.frontend;

public class demo6 {
	public static void demKiTu(String chuoi) {
		String[] a = chuoi.split(" ");
		System.out.println("so luong tu: " + a.length);
	}

	public static void main(String[] args) {
//  Kiểu dữ liệu
		int a;
		a = 10;
		float f = 10.8f;

		Integer a1 = 10;
		System.out.println(a1);

		Float f1 = 10.6f;
		int i = (int) f;
		System.out.println(i);

// Chuyển đổi Primitive sang dạng Wrapper class Integer
		Integer a_wrapper = Integer.valueOf(a);
// Chuyển đổi Wrapper class sang dạnh primitive
		float f1_primitive = f1.floatValue();

//----Question 1-------
		float luongAccount1 = 5240.5f;
		float luongAccount2 = 10970.055f;
		int luongAcc1 = (int) luongAccount1;
		int luongAcc2 = (int) luongAccount2;
		System.out.println("Lương của Account 1: " + luongAcc1);
		System.out.println("Lương của Account 2: " + luongAcc2);
// Xử lí chuổi trong Java
		String myName = "Lê Quốc Việt";
		String myAge = "21";
		System.out.println("Tên của tôi là: " + myName);
		System.out.println(myName.charAt(0));
		System.out.println(myName.concat(" ").concat(myAge));

		demKiTu(myName);

	}
}
