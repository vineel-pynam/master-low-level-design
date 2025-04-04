package snakes_and_ladders;
import java.util.*;

class Game {
    private Board board;
    private Dice dice;
    Deque<Player> players;
    Player winner = null;

    Game(){
        this.board = new Board(10, 10, 7, 5);
        this.dice = new Dice(6, 1);
        players = new LinkedList<>();
        players.add(new Player("Vineel"));
        players.add(new Player("Suneel"));
    }

    public void start(){
        while( winner == null ){
            Player currentPlayer = players.getFirst();
            Integer diceThrow = dice.throwDice();

            updatePositionAndChangePlayer(currentPlayer, diceThrow);
            if( hasPlayerWon(currentPlayer) ){
                winner = currentPlayer;
                continue;
            }
        }

        System.out.println("Winner: " + winner.getName());
    }

    private void updatePositionAndChangePlayer(Player currentPlayer, Integer diceThrow){
        Integer position = currentPlayer.getCurrentPosition();
        if( position + diceThrow > board.getTotalCells()-1 ) return;
        Integer nextPosition = position + diceThrow;
        String comment = "";
        if( board.getCell(nextPosition).getDestination() != null ){
            nextPosition = board.getCell(nextPosition).getDestination().getNumber();
            if( position > nextPosition ) comment = "bited by snake";
            else comment = "climbed ladder";
        }

        System.out.println(currentPlayer.getName() + " is moving from " + position + " to " + nextPosition + " " + comment);

        currentPlayer.setCurrentPosition(nextPosition);
        rotatePlayer();
    }

    private void rotatePlayer(){
        Player player = players.removeFirst();
        players.add(player);
    }

    public Boolean hasPlayerWon(Player currentPlayer){
        return currentPlayer.getCurrentPosition() == board.getTotalCells()-1;
    }
}
