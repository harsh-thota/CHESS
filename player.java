import java.util.HashMap;
public class player {
    int TotalPoints; 
    String color;
    String playerName;
    HashMap<String, Integer> capturedPieces  = new HashMap<String, Integer>();


    player(String c){
        color = c;
        TotalPoints = 0;   
    }
    
    void capturePeice (piece p){
        TotalPoints += p.points;
        if(capturedPieces.containsKey(p.not)){
            int currentVal = capturedPieces.get(p.not);
            capturedPieces.replace(p.not, currentVal, currentVal + 1);
        }else{
            capturedPieces.put(p.not, 1);
        }
    }
}
