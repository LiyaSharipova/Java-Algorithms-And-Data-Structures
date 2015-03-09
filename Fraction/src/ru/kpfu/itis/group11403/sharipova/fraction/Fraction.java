package ru.kpfu.itis.group11403.sharipova.fraction;

public class Fraction {
	public static int gcd(int a, int b) {
        if (b == 0) return a;
        int x = a % b;
        return gcd(b, x);
    }
	
	public static void main(String[] args) {

		try {
			
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			
			if(b == 0) {
				System.err.println("Деление на ноль");
				return;
			}
			
			int gcd = gcd(a,b);
			
			System.out.println(a / gcd + "/" + b / gcd);
			
		} catch(NumberFormatException e) {
			System.err.println("Текстовый ввод: " + e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Передано меньше 2х аргументов: " + e.getMessage());
		}

	}

}
