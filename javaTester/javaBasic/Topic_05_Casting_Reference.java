package javaBasic;

public class Topic_05_Casting_Reference {
	
	protected String name;

	public String getName() {
		return name;
		
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void printName() {
		System.out.println("Tên là: "+name);
	}
	
	public static void main(String[] args) {
		Topic_05_Casting_Reference student1 = new Topic_05_Casting_Reference();
		Topic_05_Casting_Reference student2 = new Topic_05_Casting_Reference();
		student1.setName("Nguyễn Văn An");
		student2.setName("Lê Văn Lời");
		
		student1.printName();
		student2.printName();
		//ép kiểu
		student2=student1;
		student1.printName();
		student2.printName();
		student2.setName("Phan Văn Như");
		student1.printName();
		student2.printName();
	}

}
