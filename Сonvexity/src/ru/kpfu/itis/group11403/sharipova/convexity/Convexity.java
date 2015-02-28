package ru.kpfu.itis.group11403.sharipova.convexity;
import java.util.Scanner;
public class Convexity {
	public static Point getVectorCor(Point begin, Point end){
		return new Point(end.getX()-begin.getX(), end.getY()-begin.getY());
	}
	public static boolean isConvex(Point[] polygon){
		//треугольник всегда выпуклый
		if(polygon.length < 3) {
			return true;
		}
		//рассм-м векторные произв-я пар векторов в порядке обхода
		else{	
			Point vect1 = getVectorCor(polygon[polygon.length - 1], polygon[0]);
			Point vect2 = getVectorCor(polygon[0], polygon[1]);
			//формула вект произв-я векторов, лежащих в пл-ти XY, 
			//т.e получаем координату z для вект произв-я
			double mult = vect1.getX() * vect2.getY() - vect2.getX() * vect1.getY();
			//минус показывает то, что внутренний угол между векторами > 180 
			// +, что угол<180
			double sign = Math.signum(mult);
			for(int i=1; i<polygon.length-2; i++){
				vect1=getVectorCor(polygon[i], polygon[i+1]);
				vect2=getVectorCor(polygon[i+1], polygon[i+2]);
				mult = vect1.getX() * vect2.getY() - vect2.getX() * vect1.getY();
				//все углы должны быть<180, след-но все вект. произв-я должны быть полож-ми
				if(sign*Math.signum(mult)<0){
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		Point[] polygon = new Point[n];

		System.out.println("Введите координаты вершин в порядке обхода ");
		for (int i = 0; i < polygon.length; i++) {
			polygon[i] = new Point(scan.nextInt(), scan.nextInt());
		}
		scan.close();
		System.out.println(isConvex(polygon) ? "Выпуклый" : "Не выпуклый" );

	}

}
