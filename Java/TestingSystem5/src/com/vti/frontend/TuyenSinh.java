package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Block;
import com.vti.entity.Candidate;
import com.vti.entity.ITuyenSinh;

public class TuyenSinh implements ITuyenSinh {
	Scanner sc = new Scanner(System.in);
	List<Candidate> candidateList = Candidate.getAllCandidates();
	Block block;

	@Override
	public void themThiSinh() {
		System.out.println("Nhập số báo danh: ");
		int candidateNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập họ và tên: ");
		String name = sc.nextLine();
		System.out.println("Nhập địa chỉ: ");
		String address = sc.nextLine();
		System.out.println("Nhập mức ưu tiên: ");
		String priority = sc.nextLine();
		System.out.println("Nhập vào khối thi (A, B, C): ");
		String block = sc.nextLine();

		Candidate candidate = new Candidate(candidateNumber, name, address, priority, new Block(block));
	}

	@Override
	public void hienThiThongTin() {
		for (Candidate cd : candidateList) {
			System.out.println("Số báo danh: " + cd.getCandidateNumber());
			System.out.println("Họ và tên: " + cd.getName());
			System.out.println("Địa chỉ: " + cd.getAddress());
			System.out.println("Mức ưu tiên: " + cd.getPriority());
			System.out.println("Khối thi: " + cd.getBlock().getBlockSubject());
		}

	}

	@Override
	public void timKiemTheoSbd() {
		System.out.println("Nhập vào số báo danh bạn muốn tìm: ");
		int candidateNumber = sc.nextInt();

		Candidate candidate = Candidate.getCandidateByNumber(candidateNumber);

		this.hienThiThongTin();
	}

	public static void main(String[] args) {
		TuyenSinh ts = new TuyenSinh();
		while (true) {
			System.out.println("╔══════════════════════════════════╗");
			System.out.println("║            MENU CHÍNH            ║");
			System.out.println("╠══════════════════════════════════╣");
			System.out.println("║  1. Thêm mới thí sinh            ║");
			System.out.println("║  2. Hiện thị thông tin           ║");
			System.out.println("║  3. Tìm kiếm theo số báo danh    ║");
			System.out.println("║  4. Thoát khỏi chương trình      ║");
			System.out.println("╚══════════════════════════════════╝");
			System.out.print("→ Nhập lựa chọn (1–4): ");
			int choose = ts.sc.nextInt();
			switch (choose) {
			case 1: {
				ts.themThiSinh();
				break;
			}
			case 2: {
				ts.hienThiThongTin();
				break;
			}
			case 3: {
				ts.timKiemTheoSbd();
				break;
			}
			case 4: {
				return;
			}
			}
		}

	}
}
