package Chess;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int 哈囉 = 5;
		System.out.println(哈囉);
		String[] chesses = new String[16];
		chesses[0]="King";
		chesses[1]="Guard";
		chesses[2]="Guard";
		chesses[3]="Bishop";
		chesses[4]="Bishop";
		chesses[5]="Horse";
		chesses[6]="Horse";
		chesses[7]="Rook";
		chesses[8]="Rook";
		chesses[9]="Cannon";
		chesses[10]="Cannon";
		chesses[11]="Pawn";
		chesses[12]="Pawn";	
		chesses[13]="Pawn";
		chesses[14]="Pawn";
		chesses[15]="Pawn";

//		ChineseChess[] red = new ChineseChess[16];
//		ChineseChess[] black = new ChineseChess[16];
//		for(int i=0; i< 16;i++)
//		{
//			red[i]=new ChineseChess(chesses[i],"r");
//		}
//		for(int i=0; i< 16;i++)
//		{
//			black[i]=new ChineseChess(chesses[i],"b");
//		}
//
//		
//		for(int i=0 ;i <16 ;i++)
//		{
//			System.out.print(red[i].getChessName()+ "    ");
//			System.out.println(red[i].getStartPositionX() + "," + red[i].getStartPositionY());
//		}
//		System.out.println("\n\n-----Black-----\n\n");
//		for(int i=0 ;i <16 ;i++)
//		{
//			System.out.print(black[i].getChessName()+ "    ");
//			System.out.println(black[i].getStartPositionX() + "," + black[i].getStartPositionY());
//		}
		DarkChess[] red = new DarkChess[16];
		DarkChess[] black = new DarkChess[16];
		for(int i=0; i< 16;i++)
		{
			red[i]=new DarkChess(chesses[i],"r");
		}
	
//		System.out.println("Black\n\n");
		for(int i=0; i< 16;i++)
		{
			black[i]=new DarkChess(chesses[i],"r");
		}
		for(int i=0 ;i <16 ;i++)
		{
			System.out.print(red[i].getChessName()+ "    ");
			System.out.println(red[i].getStartPositionX() + "," + red[i].getStartPositionY());
		}
		System.out.println("\n\n-----Black-----\n\n");
		for(int i=0 ;i <16 ;i++)
		{
			System.out.print(black[i].getChessName()+ "    ");
			System.out.println(black[i].getStartPositionX() + "," + black[i].getStartPositionY());
		}
	}

}
