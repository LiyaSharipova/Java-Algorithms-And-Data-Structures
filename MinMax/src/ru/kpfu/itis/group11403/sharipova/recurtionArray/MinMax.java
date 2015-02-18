package ru.kpfu.itis.group11403.sharipova.recurtionArray;

public class MinMax {
	
	private static int[] getMinMax(int array[], int left, int right) {
		int[] result= new int[2];
		// Точка выхода рекурсии 
		// случай массива длины=2
		if (right - left== 1) {
			if(array[left]<array[right]){
				result[0]=array[left];
				result[1]=array[right];
			}
			else{
				result[0]=array[right];
				result[1]=array[left];
			}
			return result;
		}
		// Находим середину
		int medium = (left + right) / 2;

		// Мин и макс двух массивов
		int[] x = getMinMax(array, left, medium);
		int[] y = getMinMax(array, medium, right);

		// Выбираем мин и макс из результатов
		if (x[0] < y[0]){
			result[0]=x[0];
		}
		else{
			result[0]=y[0];
		}
		if(x[1] < y[1]){
			result[1]=y[1];
		}
		else{
			result[1]=x[1];
		}
			return result;
	}


	public static void main(String[] args) {
		int[] minMax=getMinMax(new int[]{3,1,9,1, 0}, 0, 4);
		System.out.println("min="+minMax[0]);
		System.out.println("max="+minMax[1]);
	}

}