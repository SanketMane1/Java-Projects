import java.util.Scanner;

public class TicTacToe {
	
	
	private Player player1,player2;
	private Board board;
	
	
	public static void main(String args[]){
		
		TicTacToe t=new TicTacToe();
		t.startGame();
	}
	
	public void startGame() {
		Scanner sc=new Scanner(System.in);
		player1=takePlayer(1);
		player2=takePlayer(2);
		
		while(player1.getSymbol()==player2.getSymbol()) {
			
			System.out.println("Symbol already Taken choose another one");
			char c=sc.next().charAt(0);
			player2.setSymbol(c);
		}
		
		board=new Board(player1.getSymbol(),player2.getSymbol());
		
		boolean player1turn = true;
		int status=Board.incomplete;
		while(status==Board.incomplete || status==Board.invalid) {

			if(player1turn) {
				System.out.println("Player1"+player1.getName()+"'s turn");
				System.out.println("Enter x:");
				int x=sc.nextInt();
				System.out.println("Enter y:");
				int y=sc.nextInt();
				status=board.move(player1.getSymbol(),x,y);
				if(status!=Board.invalid) {
					player1turn=false;
					board.print();
				}
				else {
					System.out.println("Invalid Move!! Try again!");
				}
				
			}
			else {
				System.out.println("Player2"+player2.getName()+"'s turn");
				System.out.println("Enter x:");
				int x=sc.nextInt();
				System.out.println("Enter y:");
				int y=sc.nextInt();
				status=board.move(player2.getSymbol(),x,y);
				if(status!=Board.invalid) {
					player1turn=true;
					board.print();
				}
				else {
					System.out.println("Invalid Move!! Try again!");
				}
				
			}
		}
		
		if(status==Board.p1win) {
			System.out.println(player1.getName()+" won!!!");
		}
		else if(status==Board.p2win) {
			System.out.println(player2.getName()+" won!!!");
		}
		else
		{
			System.out.println("Match draw!!!");

		}
		
	}
	
	public Player takePlayer(int num) {
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter Player "+num+"Name");
		String name=sc.nextLine();
		System.out.println("Enter Player "+num+"Symbol");
		char c=sc.next().charAt(0);
		
		Player p= new Player(name,c);
		return p;
		
		
	}

}
