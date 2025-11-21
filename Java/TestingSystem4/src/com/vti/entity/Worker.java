package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Staff {
	private int rank;

	List<Worker> workers = new ArrayList<Worker>();

	public Worker(String name, int age, Gender gender, String address, int rank) {
		super(name, age, gender, address);
		this.rank = rank;

		workers.add(this);
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
