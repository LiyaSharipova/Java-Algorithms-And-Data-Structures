
public class Game {
	private int[] array= new int[3];
	private int currVal=2;
	public void move(String move) {
		System.out.println(move);
	}
	public void calculate(int diff) {
		System.out.println("я зашел я 1й");
		
		currVal+=diff;
		if((currVal>=0)&&(currVal<array.length)){
			System.out.println(array[currVal]);
		}
	
	}
	public static void main(String[] args) {
		Game game=new Game();
		Thread th1= new Thread( new Player("ping", game, 1));
		th1.start();
		Thread th2= new Thread( new Player("pong", game, -1));
		th2.start();
	}
}
