package Chess;

public class Warrior extends Chess{
	public Warrior(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Warrior");
		setEatRule("Cannon,Elephant,Horse,Pawn,Rook,Warrior");
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int whichGame ,Chess[][] board)
	{
		if(whichGame == 1){
			if(this.getColor() == 0){ //假如為紅色
				if(toX >=3 && toX <=5 && toY <= 9 && toY >=7 ){ //判斷是否在九宮格內
					if(Math.abs(toX - getX()) ==1 && getY()+ 1 == toY){ //只能斜向移動
						return true;
						}
					else if(Math.abs(toX - getX()) ==1 && getY()- 1 == toY){//只能斜向移動
						return true;
						}
					
				}
				else{
					return false;
					}
			}
		
			else if(this.getColor() == 1){//假如為黑色
				if(toX >=3 && toX <=5 && toY <= 2 && toY >=0){//判斷是否在九宮格內
					if((getX()+ 1) == toX && getY()+ 1 == toY){ //只能斜向移動
						return true;
					}
					else if((getX()- 1) == toX && getY()- 1 == toY){//只能斜向移動
						return true;
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