package snakes_and_ladders;
import java.util.concurrent.*;
class Dice {
    private Integer faces;
    private Integer diceCount;
    Dice(Integer faces, Integer diceCount){
        this.faces = faces;
        this.diceCount = diceCount;
    }    

    public Integer throwDice(){
        Integer number = 0;
        for( int i=0; i<this.diceCount; i++ ){
            number += ThreadLocalRandom.current().nextInt(1, faces+1);
        }
        return number;
    }
}
