package com.game;
import java.util.*;

public class PlayGame{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("--------Let's Play the Tic Tac Toe Game--------");
		
		//Ask user to input name
		System.out.println("Player 1, enter your name: ");
		String p1 = in.nextLine();
		System.out.println("Player 2, enter your name: ");
		String p2 = in.nextLine();
		char[][] board = new char[3][3];
		
		printBoard(board);
		
		int row = 0;
		int col = 0;
		char symbol = 0;
		boolean player1 = true;
		boolean won = false;
		while(!won) {
			if(player1 == true) {
				symbol = 'x';
				System.out.println(p1 + "'s turn (Symbol - 'x')");
			}
			else {
				symbol = 'o';
				System.out.println(p2 + "'s turn (Symbol - 'o')");
			}
						
			while(true) {
				System.out.println("Enter a row number (0, 1, 2): ");
				row = in.nextInt();
				System.out.println("Enter a column number (0, 1, 2): ");
				col = in.nextInt();
				if(row<0 || row>2 || col<0 || col>2) {
					System.out.println("Invalid row or column number");
				}
				else {
					break;
				}
			}
			if(board[row][col] != '-') {
				System.out.println("Place is already filled, choose a different place");
			}
			else {
				board[row][col] = symbol;
				player1 = !player1;
				won = checkWin(board);
			}
		}
		
		if(won == true) {
			if(symbol == 'x') {
				System.out.println("Winner is " + p1);
			}
			else {
				System.out.println("Winner is " + p2);
			}
		}
		else {
			System.out.println("There has been a Tie, Good Luck Next Time");
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		in.close();
	}
	
	public static void printBoard(char[][] board) {
		//Create empty 3x3 board
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j] = '-';
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean checkWin(char[][] board) {
		for(int i=0; i<3; i++) {
			if((board[i][0] == board[i][1] && board[i][1] == board[i][2]) && board[i][0] != '-') {
				return true;
			}
		}
		for(int j=0; j<3; j++) {
			if((board[0][j] == board[1][j] &&  board[1][j] == board[2][j]) && board[0][j] != '-') {
				return true;
			}
		}
		if((board[0][0] == board[1][1] &&  board[1][1] == board[2][2]) && board[0][0] != '-') {
			return true;
		}
		else if((board[0][2] == board[1][1] &&  board[1][1] == board[2][0]) && board[0][2] != '-') {
			return true;
		}
		
		return false;
	}
}