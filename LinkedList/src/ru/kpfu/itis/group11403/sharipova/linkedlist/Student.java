package ru.kpfu.itis.group11403.sharipova.linkedlist;

import java.util.Arrays;


public class Student {
	private int grade;
	private int year;
	private String name;
	public Student(int grade, int year, String name){
		this.grade=grade;
		this.year=year;
		this.name=name;
	}
	public int getGrade() {
		return grade;
	}
	public int getYear() {
		return year;
	}
	public String getName() {
		return name;
	}
	public static void main(String[] args) {
        
		Student[] students = new Student[15];
		students[0] = new Student(10, 1940, "John");
		students[1] = new Student(11, 1942,"Paul");
		students[2] = new Student(22, 1943,"George ");
		students[3] = null;
		students[4] = new Student(33, 1940,"Ringo");
		students[5] = new Student(44, 1970,"Blackbird");
		students[6] = new Student(55, 1999,"singing");
		students[7] = new Student(66, 2000,"in the dead");
		students[8] = new Student(77, 1996,"of night");
		students[9] = new Student(88, 1998,"Take these");
		students[10] = new Student(90, 1997,"broken wings");
		students[11] = new Student(96, 1990,"and learn to fly");
		students[12] = new Student(98, 1989,"All your life");
		students[13] = new Student(99, 1995,"You were only waiting");
		students[14] = new Student(100, 1996,"for this moment to arise");
		
		System.out.println("Sort by grade, but print song:)");
		Arrays.sort(students, new StudentHelper().compareByGrade());

		for(int i = 0; i < students.length; i++){
			if (students[i]!=null){
				System.out.println(students[i].getName());
			}
		}
		System.out.println();
		System.out.println("Now it's sorted by \"name\"");
		Arrays.sort(students, new StudentHelper().compareByName());
	
		for(int i = 0; i < students.length; i++){
			if (students[i]!=null){
				System.out.println(students[i].getName());
			}
		}
		System.out.println();
		System.out.println("Finally, by year");
		Arrays.sort(students, new StudentHelper().compareByYear());

		for(int i = 0; i < students.length; i++){
			if (students[i]!=null){
				System.out.println(students[i].getYear());
			}
		}
	}
}
