package ru.kpfu.itis.group403.sharipova.deadLock;


public class Deadlock {
	
	public static void main(String[] args) {
		Pony pony1=new Pony("1");
		Pony pony2=new Pony("2");
		Thread th1= new Thread(pony1);
		th1.start();
		Thread th2= new Thread(pony2);
		th2.start();
	}
}
