package ru.kpfu.itis.group11403.sharipova.fastMultiply;

public class FastMultiply {
	//определяем знак произведения
	public static long getSign(long x, long y){
		long sign= (long)(Math.signum(x)*Math.signum(y)) ;
		return sign;
	}
	//опр-м разрядность сомножителей, по усл. их разрядность совпадает
	public static int getCapasity(long x){
		int n=Long.toBinaryString(x).length();
		return n;
	}
	//разбиваем число на 2 части разрядности n/2
	//левую получаем арфм. сдвигом в право на n/2 битов
	public static long getLeftPart(long x){
		return x>>getCapasity(x)/2;
	}
	//правую получаем побитовой конъюнкцией данного числа и числа, 
    //равного 2^(n/2)-1, чтобы обнулить левую часть
	public static long getRightPart(long x){
        long mask=1;
        for ( int i=0; i<getCapasity(x)/2-1; i++){
        	mask<<=1;
        	mask|=1;
        }
		return x&mask;
		
	}


	public static long mult(long x, long y, int n){
//        n=getCapasity(x);
		long s=getSign(x,y);
		x=Math.abs(x);
		y=Math.abs(y);
//		n=getCapasity(x);
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
			long m1=mult(A,C,n/2);
			long m2=mult((A-B),(D-C), n/2);
			long m3=mult(B,D,n/2);
			
			return s*((m1<<n)+((m1+m2+m3)<<n/2)+m3);
			
		}
	}
    
	public static void main(String[] args) {
		   System.out.println(mult(15, 10, 4));
		  

	}

}
