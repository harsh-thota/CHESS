 class knight extends piece{
     
    knight (String color) {

        if(color.equals("w")){
            color = "w";
            not = "N";
            spwan = new int[][] {{7,1}, {7,6}};
        }else if(color.equals("b")){
            color = "b";
            not = "n";
            spwan = new int[][] {{0,1}, {0,6}};
        }
    }
}
