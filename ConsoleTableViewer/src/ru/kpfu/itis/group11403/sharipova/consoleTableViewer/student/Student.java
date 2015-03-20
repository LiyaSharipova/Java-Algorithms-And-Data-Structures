package ru.kpfu.itis.group11403.sharipova.consoleTableViewer.student;

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
	
}
