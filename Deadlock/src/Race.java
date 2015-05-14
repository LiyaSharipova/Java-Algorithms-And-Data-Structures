
public class Race {
	public static void main(String[] args) {
        Thread th1= new Thread(new Pony("Leo") );
        th1.start();
        th1.interrupt();
        Thread th2=new Thread(new Pony("Lenyash2"));
        th2.start();
        Thread th3=new Thread(new Pony("Liya"));
        th3.start();
        Thread th4=new Thread(new Pony("Lenyash"));
        th4.start();
        Thread th5=new Thread(new Pony("Airat"));
        th5.start();

	}
}
