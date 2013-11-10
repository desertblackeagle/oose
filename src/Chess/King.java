package Chess;

public class King extends Chess{
	public King(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("King");
		setEatRule("Cannon,Elephant,Horse,King,Pawn,Rook,Warrior");
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int whichGame ,Chess[][] board)
	{
		int count = 0;
		if(whichGame == 1){
			
			if(this.getColor() == 0){ //假如為紅色
				if(board[toY][toX] != null && board[toY][toX].getName().equals("King"))//飛將
				{ 
					for(int i = getY() ; i>0 ; i--)
					{
						if(board[i][toX] != null)
						{
							return false; 
						}
					}
					return true; 
				}
				if(toX < 6 && toX > 2 && toY > 6 && toY < 10){
					if(toX == getX() && Math.abs(toY - getY())==1){ //只能移動Y軸
						return true; 
						}
					else if (toY == getY() && Math.abs(toX - getX())==1)
					{
						return true; 
					}
					
				}
				else{
					return false;
				}
			}
			else if(this.getColor() == 1){ //假如為黑色
				if(board[toY][toX] != null && board[toY][toX].getName().equals("King"))//飛將
				{ 
					for(int i = getY() ; i <= 9 ; i++)
					{
						if(board[i][toX] != null)
						{
							return false; 
						}
					}
					return true; 
				}
				if(toX < 6 && toX > 2 && toY > -1 && toY < 5){
					if(toX == getX()&& Math.abs(toY - getY())==1){ //只能移動Y軸
						return true; 
					}
					else if (toY == getY() && Math.abs(toX - getX())==1)
					{
						return true; 
					}
					
				
					else{
						return false;
					}
				}
			}
		}
		return false;
	}			
}

