import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class board {
	String[] initList = { "wR", "bR", "wN", "bN", "wB", "bB", "wQ", "bQ", "wK", "bK", "wP", "bP" };
	String[][] grid;
	Map<String, piece> pieceMap;
	player wPlayer;
	player bPlayer;
	rook wR;
	rook bR;
	pawn wP;  	
	pawn bP;
	knight wN;
	knight bN;
	bishop wB;
	bishop bB;
	king wK;
	king bK;
	queen wQ;
	queen bQ;

	board() {
		grid = new String[8][8];
		pieceMap = new HashMap<String, piece>();
		bPlayer = new player("b");
		wPlayer = new player("w");
		wR = new rook("w");
		bR = new rook("b");
		wP = new pawn("w");
		bP = new pawn("b");
		wN = new knight("w");
		bN = new knight("b");
		wB = new bishop("w");
		bB = new bishop("b");
		wK = new king("w");
		bK = new king("b");
		wQ = new queen("w");
		bQ = new queen("b");

	}

	void init() {
		pieceMap.put("wR", wR);
		pieceMap.put("bR", bR);
		pieceMap.put("wN", wN);
		pieceMap.put("bN", bN);
		pieceMap.put("wB", wB);
		pieceMap.put("bB", bB);
		pieceMap.put("wQ", wQ);
		pieceMap.put("bQ", bQ);
		pieceMap.put("wK", wK);
		pieceMap.put("bK", bK);
		pieceMap.put("wP", wP);
		pieceMap.put("bP", bP);

		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				grid[j][i] = " ";
			}
		}

		for (String id : initList) {
			for (int[] j : pieceMap.get(id).spwan) {
				grid[j[0]][j[1]] = pieceMap.get(id).not;
			}
		}
	}

	void print() {
		for (int j = 0; j < 8; j++) {
			System.out.println();
			System.out.print("|");

			for (int i = 0; i < 8; i++) {
				System.out.print(grid[j][i] + "|");

			}

		}

		System.out.println();

	}

	void printCor() {
		for (int j = 0; j < 8; j++) {
			System.out.println();
			System.out.print("|");

			for (int i = 0; i < 8; i++) {
				System.out.print(String.valueOf(j) + " " + String.valueOf(i) + "|");

			}
			System.out.println();

		}
		System.out.println();
	}

	piece getPiece(int[] cordinates) {

		piece p;
		piece d = new piece();
		d.setColor("e");
		for (String id : initList) {
			if (grid[cordinates[0]][cordinates[1]].equals(pieceMap.get(id).not)) {
				p = pieceMap.get(id);
				return p;   
			
				
			}

		}

		return d;
		
	}

	boolean isGameover(){
		if(true) return true; // delete later 
		return false;
	}

	boolean capture(int[] from, int to[]) {
		
		if (grid[from[0]][from[1]].equals(" ") || getPiece(to).color.equals(getPiece(from).color)) {
			return false;
		} else {
			piece fromPeiceType = getPiece(from);
			piece toPeiceType;
			boolean isToNotEmpty = !grid[to[0]][to[1]].equals(" ");

			

			
			if (fromPeiceType.isValidMove(grid, from, to, fromPeiceType.color)) {

				if (isToNotEmpty) {
					toPeiceType = getPiece(to);

					if (fromPeiceType.color.equals("w")) {
						wPlayer.capturePeice(toPeiceType);
					} else {
						bPlayer.capturePeice(toPeiceType);
					}
				
				}

				grid[from[0]][from[1]] = " ";
				grid[to[0]][to[1]] = fromPeiceType.not;
				return true;
			} else {
				return false;
			}
		}

	}

	void startGame(){
		Scanner in = new Scanner(System.in);
		System.out.print("Black player's name: ");
		bPlayer.playerName = in.nextLine();
		System.out.print("White player's name: ");
		wPlayer.playerName = in.nextLine();
		System.out.println();
		player lastPlayed = bPlayer;
		

		while(isGameover()){
			if(lastPlayed == bPlayer){ // white playing
				lastPlayed = wPlayer;
				System.out.println(wPlayer.playerName + "'s Turn");
			}else{                    // black playing
				lastPlayed = bPlayer;
				System.out.println(bPlayer.playerName + "'s Turn");
			}

			System.out.println("Enter X value of the piece you want to move");
				int fromX = in.nextInt();
				System.out.println("Enter Y value of the piece you want to move");
				int fromY = in.nextInt();
				System.out.println("Enter X value of the box you want to move to");
				int toX = in.nextInt();
				System.out.println("Enter Y value of the Box you want to move to");
				int toY = in.nextInt();
				
			 	capture(new int[]{fromX,fromY}, new int[]{toX,toY});
				print();
				printCor();

		}

	}

}