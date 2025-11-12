package JavaVTI;

public class TypeQuestion {
	private  int typeID;
	private  TypeName typeName;
	
	public enum TypeName{ESSAY, MULTIPLE_CHOICE};
	
	public TypeQuestion(int typeID, TypeName typeName) {
		this.typeID = typeID;
		this.typeName = typeName;
	}
	
	public int getTypeID() {return typeID;}
	public void setTypeID(int typeID) {this.typeID = typeID;}
	
	public TypeName getTypeName() {return typeName;}
	public void setTypeName(String TypeName) {this.typeName = typeName;}
	
	@Override
	public String toString() {
		return String.format("TypeQuestion{ID = %d, Name = %s}", typeID, typeName);
	}
}
