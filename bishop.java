class bishop extends piece {

	bishop(String c) {	
		points = 3;
		if (c.equals("w")) {
			color = "w";
			not = "B";
			spwan = new int[][] { { 7, 2 }, { 7, 5 } };
		} else if (c.equals("b")) {
			color = "b";
			not = "b";
			spwan = new int[][] { { 0, 2 }, { 0, 5 } };
		}
	}

	boolean isAllBoxesInFrontClear(String [][] grid, int[] from, int[] to){

		boolean isUp = to[0] < from[0];
		boolean isLeft = from[1] > to[1];
		//up left
		if(isUp && isLeft){
			int x = from[0] - 1;
			int y = from[1] - 1;
			while( x > to[0] && y > to[1] ){

				if(!grid[x][y].equals(" ")) return false;
				x--;
				y--;
			}
		}
		// down left
		if(!isUp && isLeft){
			int x = from[0] + 1;
			int y = from[1] - 1;
			while( x < to[0] && y > to[1] ){

				if(!grid[x][y].equals(" ")) return false;
				x++;
				y--;
			}
		}
		// up right
		if(isUp && !isLeft){
			int x = from[0] - 1;
			int y = from[1] + 1;
			while( x > to[0] && y < to[1] ){

				if(!grid[x][y].equals(" ")) return false;
				x--;
				y++;
			}
		}
		// down right
		if(!isUp && !isLeft){
			int x = from[0] + 1;
			int y = from[1] + 1;
			while( x  <to[0] && y < to[1] ){

				if(!grid[x][y].equals(" ")) return false;
				x++;
				y++;
			}
		}
		return true;
	}
	@Override
	boolean isValidMove(String[][] grid, int[] from, int[] to, String color) {
		boolean isDiagonal = Math.abs(from[0] - to[0]) == Math.abs(from[1] - to[1]);
		if(isDiagonal && isAllBoxesInFrontClear(grid, from, to)) return true;
		return false;
	}
}
