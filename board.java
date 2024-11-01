import java.util.HashMap;
import java.util.Map;

class board {
	String[] initList = { "wR", "bR", "wN", "bN", "wB", "bB", "wQ", "bQ", "wK", "bK", "wP", "bP" };
	String[][] grid;
	Map<String, piece> pieceMap;
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

	boolean capture(int[] from, int to[]) {
		
		if (grid[from[0]][from[1]].equals(" ") || getPiece(to).color.equals(getPiece(from).color)) {
			return false;
		} else {

			piece fromPeiceType = getPiece(from);
			if (fromPeiceType.isValidMove(grid, from, to, fromPeiceType.color)) {
				grid[from[0]][from[1]] = " ";
				grid[to[0]][to[1]] = fromPeiceType.not;
			} else {
				return false;
			}

			return false;
		}

	}

}