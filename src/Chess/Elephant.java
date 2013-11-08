package Chess;

public class Elephant extends Chess{
	public Elephant(int color , boolean chessCover , int x ,int y)
	{
		super(color, chessCover, x, y);
		setName("Elephant");
		setEatRule("Rook,Horse,Cannon,Pawn");
	}
	@Override
	public boolean moveRule(int toX ,int toY ,int whichGame ,Chess[][] board)
	{
		if(whichGame == 1){
			if(this.getColor() == 0){ //假如為紅色
				if(toY > 4 && toY < 10 && toX > -1 && toX < 9){ //假如沒過河或超過範圍
					if((getX()+ 1) == toX && getY()+ 1 == toY){ //只能斜向移動
						if(){ //如果沒有塞象眼
							return true;
						}
						else{
							return false;
						}
					}
					else if((getX()- 1) == toX && getY()- 1 == toY){ //只能斜向移動
						if(){ //如果沒有塞象眼
							return true;
						}
						else{
							return false;
						}
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else if(this.getColor() == 1){//假如為黑色
				if(toY > -1 && toY < 5 && toX > -1 && toX < 9){ //假如沒過河或超過範圍
					if((getX()+ 1) == toX && getY()+ 1 == toY){ //只能斜向移動
						if(){ //如果沒有塞象眼
							return true;
						}
						else{
							return false;
						}
					}
					else if((getX()- 1) == toX && getY()- 1 == toY){ //只能斜向移動
						if(){ //如果沒有塞象眼
							return true;
						}
						else{
							return false;
						}
					}
					else{
						return false;
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