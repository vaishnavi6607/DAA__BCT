package DAA_Practical;

import java.util.Scanner;

public class N_Queen {
	private static int totalSolutions=0;
	public static void solveNQueens(int n) {
		int [][]board = new int[n][n];
		backtrack(board,0,n);
		System.out.println("Total solution :"+totalSolutions);
	}
	private static void backtrack(int[][] board, int col, int n) {
	      if(col == n) {
	    	  totalSolutions++;
	    	  printBoard(board);
	    	  return;
	      }
	      
	      for(int row=0;row<n;row++) {
	    	  if(isSafe(board,row,col,n)) {
	    		  board[row][col]=1;
	    		  backtrack(board, col+1, n);
	    		  board[row][col]=0;
	    	  }
	      }
		
	}
	
	private static boolean isSafe(int[][] board, int row, int col, int n) {
		for(int i=0;i<n;i++) {
			if(board[row][i]==1) {
				return false;
			}
		}
		
		for(int i =row,j=col ;i>=0 && j>=0 ;i--,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		
		for(int i=row,j=col;i<n&& j>=0 ;i++,j--) {
			if(board[i][j]==1) {
				return false;
			}
		}
		return true;
	}
	private static void printBoard(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==1) {
					System.out.print(" Q ");
				}
				else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("enter no of queens");
        int n = sc.nextInt();

        solveNQueens(n);
}
}
