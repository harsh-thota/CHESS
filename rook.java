 class rook extends piece{
    
    rook(String c) {

        if(c.equals("w")){
            color = "w";
            not = "R";
            spwan = new int[][] {{7,0}, {7,7}};
        }else if(c.equals("b")){
            color = "b";
            not = "r";
            spwan = new int[][] {{0,0}, {0,7}};
        }
    }

    
    boolean isAllBoxesInFrontClear(String[][] grid, int[] from, int[] to) {
        boolean isHorizontal = from[0] == to[0] ? true : false;

        if(isHorizontal){
          
            boolean isLeft = (to[1] < from[1]) ? true : false;
    
            if(isLeft){
                
                 for(int i = from[1]-1; i > to[1]; i--){
                    if(!grid[from[0]][i].equals(" ")) return false;  
                 }
            }else{
               
                for(int i = from[1] + 1; i < to[1]; i ++){
                    if(!grid[from[0]][i].equals(" ")) return false;
                
                }
            }
            
            
            return true;

        }else{
           
            boolean isUp = from[0] > to[0] ? true : false;

            if(isUp){
              
                for(int i = from[0] - 1; i > to[0]; i-- ){

                   
                    if(!grid[i][from[1]].equals(" ")){

                        return false;
                    } else{
                      
                    }
                }

            }else{
               
                for(int i = from[0] + 1; i < to[0]; i++ ){
                    if(!grid[i][from[1]].equals(" ")) return false;
                }
            }
            
             
            


        }

        return true;
    }

    @Override
    boolean isValidMove(String[][] grid, int[] from, int[] to, String color) {
        
      boolean isNotDiagonal = from[1] == to[1] || from[0] == to[0];

      if(isNotDiagonal && isAllBoxesInFrontClear(grid, from, to))  return true;
    
        return false;
    }
}
