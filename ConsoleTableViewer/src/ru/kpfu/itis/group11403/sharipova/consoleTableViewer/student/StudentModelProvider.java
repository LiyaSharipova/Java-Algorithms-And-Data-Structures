package ru.kpfu.itis.group11403.sharipova.consoleTableViewer.student;

import java.util.Comparator;

import ru.kpfu.itis.group11403.sharipova.consoleTableViewer.table.ModelProvider;

public class StudentModelProvider implements ModelProvider<Student> {
	
	Student[] students;
	public StudentModelProvider(Student[] students){
		this.students=students;
	}
	
	@Override
	public Student[] getElements() {
		return students;
	}

	@Override
	public Comparator<Student> getComparator() {
		
		return new StudentHelper().compareByName();
	}

}
