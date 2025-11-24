package com.vti.entity;

public class Block {
	private String blockName;
	private String blockSubject;

	public Block(String blockName) {
		super();
		this.blockName = blockName;
	}

	public String getBlockSubject() {
		switch (this.blockName) {
		case "A": {
			this.blockSubject = "Toán, Lý, Hóa";
			break;
		}
		case "B": {
			this.blockSubject = "Toán, Sinh, Hóa";
			break;
		}
		case "C": {
			this.blockSubject = "Văn, Sử, Địa";
			break;
		}
		}
		return this.blockSubject;
	}
}
