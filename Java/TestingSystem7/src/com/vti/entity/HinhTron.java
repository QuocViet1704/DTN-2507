package com.vti.entity;

public class HinhTron extends HinhHoc {
	private double bk;
	private static final double PI = 3.14;

	public HinhTron(double bk) {
		this.bk = bk;
	}

	public double getBk() {
		return bk;
	}

	public void setBk(double bk) {
		this.bk = bk;
	}

	@Override
	public double chuVi() {
		return 2 * PI * bk;
	}

	@Override
	public double dienTich() {
		return PI * bk * bk;
	}

	@Override
	public String toString() {
		return String.format("HinhTron [ban kinh= %.2f]", bk);
	}
}
