package ru.kpfu.itis.group11403.sharipova.consoleTableViewer.student;

import ru.kpfu.itis.group11403.sharipova.consoleTableViewer.table.LabelProvider;

public class StudentLabelProvider implements LabelProvider<Student> {
	private final  String[] HEADERS = {"Name", "Grade", "Year"};

	private final  int NAME  = 0;
	private final  int GRADE  = 1;
	private final  int YEAR = 2;
	@Override
	public int getColumnCount() {
		return HEADERS.length;
	}

	@Override
	public String getHeader(int col) {
		return HEADERS[col];
	}

	@Override
	public String getLabel(Student row, int col) {
		switch (col){
		case NAME:
			return row.getName();
		case GRADE:
			return Integer.toString(row.getGrade());
		case YEAR:
			return Integer.toString(row.getYear());
		}
		return null;
	}

}
