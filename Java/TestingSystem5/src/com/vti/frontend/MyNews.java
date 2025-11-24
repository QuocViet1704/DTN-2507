package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.News;

public class MyNews {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<News> newsList = News.getAllNews();
		while (true) {
			System.out.println("╔══════════════════════════════════╗");
			System.out.println("║            MENU CHÍNH            ║");
			System.out.println("╠══════════════════════════════════╣");
			System.out.println("║  1. Insert news                  ║");
			System.out.println("║  2. View list news               ║");
			System.out.println("║  3. Average rate                 ║");
			System.out.println("║  4. Exit                         ║");
			System.out.println("╚══════════════════════════════════╝");
			System.out.print("→ Nhập lựa chọn (1–4): ");

			int choose = sc.nextInt();
			sc.nextLine();

			switch (choose) {
			case 1: {
				System.out.println("====================================");
				System.out.println("Nhập title: ");
				String title = sc.nextLine();
				System.out.println("Nhập publish date: ");
				String publishDate = sc.nextLine();
				System.out.println("Nhập author: ");
				String author = sc.nextLine();
				System.out.println("Nhập content: ");
				String content = sc.nextLine();
				System.out.println("Nhập rates: ");
				int rates[] = new int[3];
				for (int i = 0; i < 3; ++i) {
					rates[i] = sc.nextInt();
					sc.nextLine();
				}

				News news = new News(choose, title, publishDate, author, content, choose, rates);
				break;
			}
			case 2: {
				for (News ns : newsList) {
					ns.display();
				}
				break;
			}
			case 3: {
				for (News ns : newsList) {
					ns.Calculate();
					ns.display();
				}
				break;
			}
			case 4: {
				return;
			}
			}
		}
	}
}
