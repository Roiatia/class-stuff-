package Files;

public class Student {
private String first_name;
private String last_name;
private int id;
private int grade1;
private int grade2;	
	
	public Student (String first_name , String last_name , int id ) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.id = id;
			
	}
	
	public void setGrades(int grade1 , int grade2) {
		this.grade1 = grade1;
		this.grade2 = grade2;

	}
	
	public double getAvg() {
		return (grade1 + grade2 ) / 2;
	}
	
	
	
}
