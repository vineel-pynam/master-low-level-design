package snakes_and_ladders;
import java.util.concurrent.*;

class Board {
    private Cell[][] board;
    private Integer rows = 0;
    private Integer cols = 0;
    private Integer totalCells = 0;

    Board(Integer rows, Integer cols, Integer snakes, Integer ladders){
        this.rows = rows;
        this.cols = cols;
        this.totalCells = rows*cols;
        initialize(rows, cols);
        addSnakesAndLadders(snakes, ladders);
    }

    private void initialize(Integer rows, Integer cols){
        this.board = new Cell[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++ ){
                board[i][j] = new Cell(i, j, (i*cols + j), null);
            }
        }
    }

    private void addSnakesAndLadders(Integer snakes, Integer ladders){
        // Adding snakes
        while( snakes > 0 ){
            Integer snakeHead = ThreadLocalRandom.current().nextInt(1, totalCells-1);
            Integer snakeTail = ThreadLocalRandom.current().nextInt(1, totalCells-1);
            if( snakeHead <= snakeTail ) continue;

            Cell desitnation = board[snakeTail/this.cols][snakeTail%this.cols];
            Cell cell = board[snakeHead/this.cols][snakeHead%this.cols];
            if( cell.getDestination() == null ){
                cell.setDesitnation(desitnation);
                snakes--;
            }
        } 

        while( ladders > 0 ){
            Integer ladderDown = ThreadLocalRandom.current().nextInt(this.cols, totalCells-1);
            Integer ladderTop = ThreadLocalRandom.current().nextInt(this.cols, totalCells-1);
            if( ladderDown >= ladderTop ) continue;

            Cell desitnation = board[ladderTop/this.cols][ladderTop%this.cols];
            Cell cell = board[ladderDown/this.cols][ladderDown%this.cols];
            if( cell.getDestination() == null ){
                cell.setDesitnation(desitnation);
                ladders--;
            }
        } 

    }

    public Integer getTotalCells(){
        return this.totalCells;
    }

    public Cell getCell(Integer position){
        return board[position/cols][position%cols];
    }
}
