
public class Player implements Runnable{
	private String move;
	private Game game;
	private  int diff;
	@Override
	public void run() {
		// TODO Auto-generated method stub
       while( true){
//    	   game.move(move);
    	   game.calculate(diff);
       }
	}
	public Player(String move, Game game, int diff) {
		
		this.move = move;
		this.game = game;
		this.diff=diff;
	}


}
