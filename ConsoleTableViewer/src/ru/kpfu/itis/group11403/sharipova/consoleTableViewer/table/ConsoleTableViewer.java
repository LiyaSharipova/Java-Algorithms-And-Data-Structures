package ru.kpfu.itis.group11403.sharipova.consoleTableViewer.table;

import java.util.Arrays;

public class ConsoleTableViewer<T> {
	LabelProvider<T> labelProvider;
	ModelProvider<T> modelProvider;

	public ConsoleTableViewer(LabelProvider<T> labelProvider,
			ModelProvider<T> modelProvider) {
		super();
		this.labelProvider = labelProvider;
		this.modelProvider = modelProvider;
	}

    // returns the maximum length of the label in a column
	private int getMaxLengthOfLabel(int col){
		int maxLength=labelProvider.getHeader(col).length();
		T[] array=modelProvider.getElements();
		for(int i=0; i<array.length; i++){
			if (labelProvider.getLabel(array[i], col).length()>maxLength){
				maxLength=labelProvider.getLabel(array[i], col).length();
			}
		}
		return maxLength;
	}
    // adds " " to make label equal to maximum length of the label in a column
	private void stringFormat(int col, String s) {

		int k=getMaxLengthOfLabel(col)-s.length();
		for (int j = 0; j < k; j++) {
			System.out.print(" ");
		}
	}
	//prints first, last, afterheader strips
	private void firstLast(char c){
		int lengthOfFirst=labelProvider.getColumnCount();
		for (int i=0; i<labelProvider.getColumnCount(); i++){
			lengthOfFirst+=getMaxLengthOfLabel(i);
		}
		for (int i=0; i<lengthOfFirst; i++ ){
			System.out.print(c);		  
		}
		System.out.println(c);
	}
	public void show() throws TableViewerException {
		if(labelProvider == null || modelProvider == null) {
			throw new TableViewerException("labelProvider or modelProvider can't be null");
		}
		T[] model = modelProvider.getElements();
		Arrays.sort(model, modelProvider.getComparator());
		firstLast('_');
		for (int i = 0; i < labelProvider.getColumnCount(); i++) {
			System.out.print("|");
			System.out.print(labelProvider.getHeader(i));
			stringFormat(i, labelProvider.getHeader(i));			
		}

		System.out.println("|");
		firstLast('=');
		for(int i=0; i<modelProvider.getElements().length; i++){
			for (int j=0; j<labelProvider.getColumnCount(); j++){
				System.out.print("|"+labelProvider.getLabel(model[i], j));
				stringFormat(j, labelProvider.getLabel(model[i],j));				
			}
			System.out.println("|");
		}
		firstLast('-');
	}
}
