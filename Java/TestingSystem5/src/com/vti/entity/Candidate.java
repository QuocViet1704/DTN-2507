package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class Candidate {
	private int candidateNumber;
	private String name;
	private String address;
	private String priority;
	Block block;

	private static List<Candidate> candidateList = new ArrayList<>();

	public Candidate(int candidateNumber, String name, String address, String priority, Block block) {
		super();
		this.candidateNumber = candidateNumber;
		this.name = name;
		this.address = address;
		this.priority = priority;
		this.block = block;

		candidateList.add(this);
	}

	public int getCandidateNumber() {
		return candidateNumber;
	}

	public void setCandidateNumber(int candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public static Candidate getCandidateByNumber(int sbd) {
		for (Candidate cd : candidateList) {
			if (cd.getCandidateNumber() == sbd) {
				return cd;
			}
		}
		return null;
	}

	public static List<Candidate> getAllCandidates() {
		return candidateList;
	}

}
