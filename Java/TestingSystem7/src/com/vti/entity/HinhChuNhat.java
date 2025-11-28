package com.vti.entity;

public class HinhChuNhat extends HinhHoc {
	private double cr;
	private double cd;

	public HinhChuNhat(double cr, double cd) {
		super();
		this.cr = cr;
		this.cd = cd;
	}

	@Override
	public double chuVi() {
		return (this.cd + this.cr) * 2;
	}

	@Override
	public double dienTich() {
		return this.cd * this.cr;
	}

	public double getCr() {
		return cr;
	}

	public void setCr(double cr) {
		this.cr = cr;
	}

	public double getCd() {
		return cd;
	}

	public void setCd(double cd) {
		this.cd = cd;
	}

	@Override
	public String toString() {
		return String.format("HinhChuNhat [chieu rong= %.2f, chieu dai= %.2f]", cr, cd);
	}

}
