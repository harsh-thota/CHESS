class bishop extends piece {

	bishop(String c) {

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
}
