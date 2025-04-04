package tic_tac_toe;
import java.util.*;
import java.util.concurrent.*;

class Game {
    Board board;
    Deque<Player> players;
    Player winner = null;
    Game(){
        this.board = new Board(3, 3);
        players = new LinkedList<>();
        players.add(new Player("Vineel", new PieceX()));
        players.add(new Player("Suneel", new PieceO()));
    }

    public void start(){
        while ( winner == null ) {
            Player currPlayer = players.getFirst();

            List<Integer> freeCells = board.getFreeCells();
            if( freeCells.size() == 0 ) {
                System.out.println("Match Drawn");
                return;
            }

            Integer randomIndex = ThreadLocalRandom.current().nextInt(0, freeCells.size());
            Integer position = freeCells.get(randomIndex);

            printMessage(currPlayer, position);
            
            Boolean isPieceSet = board.setPiece(position, currPlayer.getPlayingPiece());

            if( isPieceSet ){
                rotatePlayer();
                board.display();
                System.out.println();
                
                Boolean isWinner = board.checkWinner(position);
                if( isWinner ){
                    System.out.println("Winner: " + currPlayer.getName());
                    return;
                }
            }
        }
    }

    public void rotatePlayer(){
        Player player = players.removeFirst();
        players.add(player);
    }

    private void printMessage(Player player, Integer position){
        System.out.println(player.getName() + " setting " + player.getPlayingPiece().getPieceType().toString() + " at " + (position/board.getCols()) + "," + (position%board.getCols()) );
    }
}
