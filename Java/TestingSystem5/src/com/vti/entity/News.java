package com.vti.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class News implements INews {
	Scanner sc = new Scanner(System.in);

	private int Id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;

	private static List<News> newList = new ArrayList<News>();

	public News(int id, String title, String publishDate, String author, String content, float averageRate,
			int[] rates) {
		super();
		Id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.averageRate = averageRate;
		this.rates = rates;

		newList.add(this);
	}

	public int[] getRates() {
		return rates;
	}

	public void setRates(int[] rates) {
		this.rates = rates;
	}

	private int[] rates;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}

	public static List<News> getAllNews() {
		return newList;
	}

	@Override
	public void display() {
		System.out.println("Title: " + title);
		System.out.println("Publish Date: " + publishDate);
		System.out.println("Author: " + author);
		System.out.println("Content: " + content);
		System.out.println("Average Rate: " + averageRate);
	}

	@Override
	public float Calculate() {
		averageRate = (rates[0] + rates[1] + rates[2]) / 3;
		return averageRate;
	}

}
