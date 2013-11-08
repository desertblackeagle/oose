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
		if(whichGame == 1){
			if(this.getColor() == 0){ //假如為紅色
				if(toX < 6 && toX > 2 && toY > 6 && toY < 10){
					if(toX == getX()){ //只能移動Y軸
						return true; 
						}
					else if(toY == getY()){ //只能移動X軸
						if( == null){ //若沒有碰頭
							return true; 
						}
						else{
							return false;
						}
					}
				}
				else{
					return false;
				}
			}
			else if(this.getColor() == 1){ //假如為黑色
				if(toX < 6 && toX > 2 && toY > -1 && toY < 5){
					if(toX == getX()){ //只能移動Y軸
						return true; 
						}
					else if(toY == getY()){ //只能移動X軸
						if(){ //若沒有碰頭
							return true; 
						}
						else{
							return false;
						}
					}
				}
				else{
					return false;
				}
			}
		}
		return false;
	}
}

