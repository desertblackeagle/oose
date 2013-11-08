package Chess;

public class Warrior extends Chess{
	public Warrior(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Warrior");
//		setEatRule(eatRule);
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int whichGame ,Chess[][] board)
	{
		if(whichGame == 1){
			if(this.getColor() == 0){ //假如為紅色
				if(toX > 3 || toX < 5 || toX == 3 || toX == 5 || toY > 9 || toY < 7 || toY == 9 || toY == 7){ //判斷是否在九宮格內
					if((getX()+ 1) == toX && getY()+ 1 == toY){ //只能斜向移動
						return true;
						}
					else if((getX()- 1) == toX && getY()- 1 == toY){//只能斜向移動
						return true;
						}
					else if(toX == getX()){ //只能移動Y軸
						return true; 
						}
				}
				else{
					return false;
					}
			}
		
			else if(this.getColor() == 1){//假如為黑色
				if(toX > 3 || toX < 5 || toX == 3 || toX == 5 || toY > 0 || toY < 2 || toY == 0 || toY == 2){//判斷是否在九宮格內
					if((getX()+ 1) == toX && getY()+ 1 == toY){ //只能斜向移動
						return true;
					}
					else if((getX()- 1) == toX && getY()- 1 == toY){//只能斜向移動
						return true;
					}
					else if(toX == getX()){ //只能移動Y軸
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