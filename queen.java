 class queen extends piece {

    queen (String c) {

        if(c.equals("w")){
            color = "w";
            not = "Q";
            spwan = new int[][] {{7,3}};
                    
        }else if(c.equals("b")){
            color = "b";
            not = "q";
            spwan = new int[][] {{0,3}};
        }
    }
}
