 class knight extends piece{
     
    knight (String c) {
        points = 3;
        if(c.equals("w")){
            color = "w";
            not = "N";
            spwan = new int[][] {{7,1}, {7,6}};
        }else if(c.equals("b")){
            color = "b";
            not = "n";
            spwan = new int[][] {{0,1}, {0,6}};
        }
    }

    @Override 
    boolean isValidMove (String[][] grid, int[] from, int[] to, String color){
       if ((Math.abs(from[0] - to[0]) == 2 && Math.abs(from[1] - to[1]) == 1)  ||  (Math.abs(from[0] - to[0]) == 1 && Math.abs(from[1] - to[1]) == 2)) return true;
        return false;
    }
}
