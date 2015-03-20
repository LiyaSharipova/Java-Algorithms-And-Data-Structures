package ru.kpfu.itis.group11403.sharipova.consoleTableViewer.student;

import java.awt.Label;

import ru.kpfu.itis.group11403.sharipova.consoleTableViewer.table.ConsoleTableViewer;
import ru.kpfu.itis.group11403.sharipova.consoleTableViewer.table.LabelProvider;
import ru.kpfu.itis.group11403.sharipova.consoleTableViewer.table.ModelProvider;
import ru.kpfu.itis.group11403.sharipova.consoleTableViewer.table.TableViewerException;

public class Test {

	public static void main(String[] args) {
		Student[] students= new Student[3];
		students[0] = new Student(10, 1940, "John");
		students[1] = new Student(11, 1942,"Paul");
		students[2] = new Student(22, 1943,"George");
		
		LabelProvider<Student> labelProvider= new StudentLabelProvider();
		ModelProvider<Student> modelProvider=new StudentModelProvider(students);
		ConsoleTableViewer<Student> table = 
				new ConsoleTableViewer<Student>(labelProvider, modelProvider);
		try {
			table.show();
		} catch (TableViewerException e) {
			e.printStackTrace();
		}
	}

}
