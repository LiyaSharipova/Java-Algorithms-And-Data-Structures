package ru.kpfu.itis.group11403.sharipova.convexity;
import java.util.Scanner;
public class Convexity {
	public static Point getVectorCor(Point begin, Point end){
		return new Point(end.getX()-begin.getX(), end.getY()-begin.getY());
	}
	public static boolean isConvex(Point[] polygon){
		//����������� ������ ��������
		if(polygon.length < 3) {
			return true;
		}
		//�����-� ��������� ������-� ��� �������� � ������� ������
		else{	
			Point vect1 = getVectorCor(polygon[polygon.length - 1], polygon[0]);
			Point vect2 = getVectorCor(polygon[0], polygon[1]);
			//������� ���� ������-� ��������, ������� � ��-�� XY, 
			//�.e �������� ���������� z ��� ���� ������-�
			double mult = vect1.getX() * vect2.getY() - vect2.getX() * vect1.getY();
			//����� ���������� ��, ��� ���������� ���� ����� ��������� > 180 
			// +, ��� ����<180
			double sign = Math.signum(mult);
			for(int i=1; i<polygon.length-2; i++){
				vect1=getVectorCor(polygon[i], polygon[i+1]);
				vect2=getVectorCor(polygon[i+1], polygon[i+2]);
				mult = vect1.getX() * vect2.getY() - vect2.getX() * vect1.getY();
				//��� ���� ������ ����<180, ����-�� ��� ����. ������-� ������ ���� �����-��
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

		System.out.println("������� ���������� ������ � ������� ������ ");
		for (int i = 0; i < polygon.length; i++) {
			polygon[i] = new Point(scan.nextInt(), scan.nextInt());
		}
		scan.close();
		System.out.println(isConvex(polygon) ? "��������" : "�� ��������" );

	}

}
