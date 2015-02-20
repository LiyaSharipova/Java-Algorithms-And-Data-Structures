package ru.kpfu.itis.group11403.sharipova.fastMultiply;

public class FastMultiply {
	//���������� ���� ������������
	public static long getSign(long x, long y){
		long sign= (long)(Math.signum(x)*Math.signum(y)) ;
		return sign;
	}
	//���-� ����������� ������������, �� ���. �� ����������� ���������
	public static int getCapasity(long x){
		int n=Long.toBinaryString(x).length();
		return n;
	}
	//��������� ����� �� 2 ����� ����������� n/2
	//����� �������� ����. ������� � ����� �� n/2 �����
	public static long getLeftPart(long x){
		return x>>getCapasity(x)/2;
	}
	//������ �������� ��������� ����������� ������� ����� � �����, 
    //������� 2^(n/2)-1, ����� �������� ����� �����
	public static long getRightPart(long x){
		long mask=(long)Math.pow(2, (getCapasity(x)/2))-1;
		return x&mask;
	}


	public static long multiply(long x, long y){
		long s=getSign(x,y);
		x=Math.abs(x);
		y=Math.abs(y);
		int n=getCapasity(x);
		if (n==1){
			if((x==1)&&(y==1)){
				return s;
			}
			else return(0);		
		}
		else{
			long A=getLeftPart(x);
			long B=getRightPart(x);
			long C=getLeftPart(y);
			long D=getRightPart(y);
			long m1=A*C;
			long m2=(A-B)*(D-C);
			long m3=B*D;
			return (s*(m1*(long)Math.pow(2, n)+(m1+m2+m3)*(long)Math.pow(2, n/2)+m3));
		}
	}
    
	public static void main(String[] args) {
	  
	   
//	   String s= Integer.toBinaryString(a);
	   System.out.println(multiply(15, 10));

	}

}
