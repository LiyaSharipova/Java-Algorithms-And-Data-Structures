package ru.kpfu.itis.group11403.sharipova.consoleTableViewer.table;

import java.util.Comparator;

public interface ModelProvider<T> {
	
	T[] getElements();
	Comparator<T> getComparator();
}
