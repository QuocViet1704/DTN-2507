package com.vti.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Person {
	private Scanner sc = new Scanner(System.in);
	private String name;
	private String gender;
	private LocalDate dOb;
	private String address;

	public Person() {
	}

	public Person(String name, String gender, LocalDate dOb, String address) {
		this.name = name;
		this.gender = gender;
		this.dOb = dOb;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getdOb() {
		return dOb;
	}

	public void setdOb(LocalDate dOb) {
		this.dOb = dOb;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void inputInfo() {
		System.out.println("--------------------------");
		System.out.print("Nhập tên: ");
		this.name = sc.nextLine();
		System.out.print("Nhập giới tính: ");
		this.gender = sc.nextLine();
		System.out.print("Nhập ngày sinh(dd/MM/yyyy): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String input = sc.nextLine();
		this.dOb = LocalDate.parse(input, formatter);
		System.out.print("Nhập địa chỉ: ");
		this.address = sc.nextLine();
	}

	public void showInfo() {
		System.out.println("--------------------------");
		System.out.println("Tên: " + this.name);
		System.out.println("Giới tính: " + this.gender);
		System.out.println("Ngày sinh: " + this.dOb);
		System.out.println("Địa chỉ: " + this.address);
	}

}
