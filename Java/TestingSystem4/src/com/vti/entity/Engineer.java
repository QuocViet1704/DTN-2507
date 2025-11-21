package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends Staff {
	public String training;

	List<Engineer> engineers = new ArrayList<>();

	public Engineer(String name, int age, Gender gender, String address, String training) {
		super(name, age, gender, address);
		this.training = training;

		engineers.add(this);
	}

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

}
