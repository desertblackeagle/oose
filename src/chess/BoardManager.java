package chess;

/* @author Red Rose
 * Function:a manager to control board
 * @ version 1.0
 * Last Update:2013/10/7
 */

public class BoardManager {
	
	public void moveTo(){
		moveChess();
		if(canMove()){
			if(haveTarget()){
				if(canEat()){
					eatChess();
				}
				else{
					//move back
		   		}
			}
		}else{
			//move back
		}
	}
	
	private void moveChess(){
		
	}
	
	private boolean canMove(){
		return true;
	}
	
	private boolean haveTarget(){
		return true;
	}
	
	private boolean canEat(){
		return true;
	}
	
	private void eatChess(){
		
	}
}
