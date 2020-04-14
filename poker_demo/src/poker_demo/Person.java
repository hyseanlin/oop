package poker_demo;

public class Person {
	
	public String name="";
	public char gender='M';	// F: female, M: male
	public int age=0;
	
	public Person() {
		this.name = "";
		this.gender = 'M';
		this.age = 18;
	}

	public Person(String name, char gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public void displayCards() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
