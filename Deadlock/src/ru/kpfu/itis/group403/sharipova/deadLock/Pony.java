package ru.kpfu.itis.group403.sharipova.deadLock;
import java.util.Random;


public class Pony implements Runnable{
	private String name;
	//    private int step;   
	private Random random = new Random();

	@Override
	public void run() {
		int path=100;
		while(path>0){
			path-= random.nextInt(5);
			System.out.println(name+ ". я сходил");
			synchronized (" the 1st pony ") {
				synchronized (" the 2nd pony ") {

				}
			}
			synchronized (" the 2nd pony ") {
				synchronized (" the 1st pony ") {

				}
			}
			//?????????????
//			Thread.yield();
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				path=-1;
//			}
		}
		System.out.println(name);
		//       Thread.yield();
	}
	public Pony(String name) {
		super();
		this.name = name;
	}

}
