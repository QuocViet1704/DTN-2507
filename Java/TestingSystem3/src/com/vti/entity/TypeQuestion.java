package com.vti.entity;

public class TypeQuestion {
	private  int id;
	private  TypeName name;
	
	public enum TypeName{ESSAY, MULTIPLE_CHOICE};
	
	public TypeQuestion(int typeID, TypeName typeName) {
		this.id = id;
		this.name = name;
	}
	
	public int getTypeID() {return id;}
	public void setTypeID(int typeID) {this.id = id;}
	
	public TypeName getTypeName() {return name;}
	public void setTypeName(String TypeName) {this.name = name;}
	
	@Override
	public String toString() {
		return String.format("TypeQuestion{ID = %d, Name = %s}", id, name);
	}
}
