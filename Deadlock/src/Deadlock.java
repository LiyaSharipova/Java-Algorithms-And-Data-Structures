


public class Deadlock {
	public static void main(String[] args) {

		Thread th1= new Thread(new Pony(" the 1st pony "));
		th1.start();
		Thread th2= new Thread(new Pony(" the 2nd pony "));
		th2.start();
	}
}
