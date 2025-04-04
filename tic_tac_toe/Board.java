package tic_tac_toe;
import java.util.*;

public class Board {
    private Piece[][] board;
    private Integer rows = 0;
    private Integer cols = 0;

    Board(Integer rows, Integer cols){
        this.rows = rows;
        this.cols = cols;
        initialize();
    }

    private void initialize(){
        board = new Piece[rows][cols];
    }

    public Boolean setPiece(Integer position, Piece piece){
        Integer row = position/cols;
        Integer col = position%cols;
        if( board[row][col] != null ) return false;
        board[row][col] = piece;
        return true;
    }

    public Boolean checkWinner(Integer position){
        Integer row = position/cols;
        Integer col = position%cols;
        Piece piece = board[row][col];

        if( piece == null  ) return false;

        Boolean rowWin = true;
        for( int i=0; i<cols; i++ ) {
            if( board[row][i] == null || !(board[row][i].equals(piece)) ) {
                rowWin = false;
                break;
            }
        }
        
        Boolean colWin = true;
        for( int i=0; i<rows; i++ ) {
            if( board[i][col] == null || !(board[i][col].equals(piece)) )  {
                colWin = false;
                break;
            }
        }

        Boolean diagWin = true;
        for( int i=0; i<rows; i++ ) {
            if( board[i][i] == null || !(board[i][i].equals(piece)) ) {
                diagWin = false;
                break;
            }
        }

        Boolean antiDiagWin = true;
        for( int i=0; i<rows; i++ ) {
            if(board[i][cols-i-1] == null || !(board[i][cols-i-1].equals(piece)) )  {
                antiDiagWin = false;
                break;
            }
        }


        return rowWin || colWin || diagWin || antiDiagWin;
    }

    public List<Integer> getFreeCells(){
        List<Integer> freeCells = new ArrayList<>();

        for(  int i=0; i<this.rows; i++ ){
            for( int j=0; j<this.cols; j++ ){
                if( this.board[i][j] == null  ){
                    freeCells.add(i*cols + j);
                }
            }
        }

        return freeCells;
    }

    public void display(){
        for(  int i=0; i<rows; i++ ){
            for( int j=0; j<cols; j++ ){
                if( board[i][j] == null  ){
                    System.out.print((i*cols + j) + " ");
                }else{
                    System.out.print(board[i][j].getPieceType().toString() + " ");
                }
            }
            System.out.println();
        }
    }

    public Integer getRows(){
        return this.rows;
    }

    public Integer getCols(){
        return this.cols;
    }
}
