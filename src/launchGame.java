
import java.util.Random;
import java.util.Scanner;
class tic_tac_toe
{
	static char[][] board;
	public tic_tac_toe()
	{
		board=new char[3][3];
		init();
		
	}
 public  void init( )
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j]=' ';
			}
		}
				
	}
static void displayBoard()
{
	System.out.println("-------------");
	for(int i=0;i<board.length;i++)
	{
		System.out.print("| ");
		
		for(int j=0;j<board[i].length;j++)
		{
			System.out.print(board[i][j]+" | ");
		}
		System.out.println();
		System.out.println("-------------");
		
    }
}
static void placemark(int row,int col,char val)
{
	
	if(row>=0 && row<=2 && col>=0 && col<=2)
	{
		board[row][col]=val;
	}
	else
	{
		System.out.println("Invalid Position");
	}
}
static boolean checkColWin()
{
for(int j=0;j<=2;j++)
{
	if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
	{
		return true;
		
	}
	
}
return false;
}
static boolean checkRowWin()
{
	for(int i=0;i<=2;i++)
	{
		if(board[i][0]!=' ' &&board[i][0]==board[i][1] && board[i][1]==board[i][2])
		{	
			return true;
		}
	}
	return false;
}
	
static boolean checkDiaWin()
{
	if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
	{
		return true;
	}
	else
	{
		return false;
	}
}
static boolean checkDraw()
{
 for(int i=0;i<=2;i++)
 {
	 for(int j=0;j<=2;j++)
	 {
		 if(board[i][j]==' ')
		 {
			 return false;
		 }
	 }
 }
 return true;
}
}

abstract class Player
{
	String name;
	char mark;
	abstract void makemove();
boolean checkValidMove(int row,int col)
		{
			if(row>=0 && row<=2 && col>=0 && col<=2)
			{
				if(tic_tac_toe.board[row][col]==' ')
				{
					return true;
				}
			}
			return false;
		}	
}
class HumanPlayer extends Player
{
	HumanPlayer(String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	 void makemove()
	{
		Scanner sc=new Scanner(System.in);
		int row,col;
		do {
		System.out.println("Enter rows and columns");
		row=sc.nextInt();
		col=sc.nextInt();
		}
		while(!checkValidMove(row,col));
		tic_tac_toe.placemark(row, col,mark);	
	}
}
class AIplayer extends Player
{
	AIplayer(String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	 void makemove()
	{
		int row,col;
		do {
		Random r=new Random();// random class
		row=r.nextInt(3);
		col=r.nextInt(3);
		}
		while(!checkValidMove(row,col));
		tic_tac_toe.placemark(row,col,mark);	
	}
}
public class launchGame {
	public static void main(String[] args) {
		tic_tac_toe t=new tic_tac_toe();
		HumanPlayer cp1=new HumanPlayer("venky",'x');
		AIplayer cp2=new AIplayer("TAI",'0');

		Player cp;
		cp=cp1;
		
		while(true)
		{
			System.out.println(cp.name+" turn ");
			cp.makemove();
			tic_tac_toe.displayBoard();
			if(tic_tac_toe.checkColWin() || tic_tac_toe.checkRowWin() || tic_tac_toe.checkDiaWin())
			{
				System.out.println(cp.name+" has won");
				break;
			}
			else if(tic_tac_toe.checkDraw())
			{
				System.out.println("game is draw");
				break;	
			}
			else
			{
			  if(cp==cp1)
			    {
				cp=cp2;
			    }
			  else
			    {
				cp=cp1;
			    }
			}
			  
		}
	}
}
		
		
		// TODO Auto-generated method stub



