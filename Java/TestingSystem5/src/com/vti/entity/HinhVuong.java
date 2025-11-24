package com.vti.entity;

public class HinhVuong extends HinhChuNhat {

	@Override
	public int chuVi(int a, int b) {
		System.out.println("Tính theo chu vi hình vuông");
		return super.dienTich(a, b);
	}

	@Override
	public int dienTich(int a, int b) {
		System.out.println("Tính theo diện tích hình vuông");
		return super.dienTich(a, a);
	}

	public static void main(String[] args) {
		HinhVuong hv = new HinhVuong();
		HinhChuNhat hcn = new HinhChuNhat();
		System.out.println("Diện tích: " + hv.dienTich(5, 0));
		System.out.println("Chu vi: " + hcn.chuVi(2, 5));
	}
}
