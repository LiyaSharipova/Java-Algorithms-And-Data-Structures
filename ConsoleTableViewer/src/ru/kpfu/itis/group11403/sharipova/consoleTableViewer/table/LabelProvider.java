package ru.kpfu.itis.group11403.sharipova.consoleTableViewer.table;

public interface LabelProvider<T> {
	int getColumnCount();
	String getHeader(int col);
	String getLabel(T row, int col);
	
}
