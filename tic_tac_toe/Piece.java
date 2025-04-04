package tic_tac_toe;

import java.util.Objects;

class Piece {
    private PieceType pieceType;
    Piece(PieceType pieceType){
        this.pieceType = pieceType;
    }
    public PieceType getPieceType(){
        return pieceType;
    }

    @Override
    public boolean equals(Object obj){
        if( this == obj ) return true;
        if( obj == null || getClass() != obj.getClass() ) return false;
        Piece p = (Piece) obj;
        return this.getPieceType() == p.getPieceType();
    }

    @Override
    public int hashCode(){
        return Objects.hash(pieceType);
    }
}

class PieceX extends Piece{
    PieceX(){
        super(PieceType.X);
    }
}

class PieceO extends Piece{
    PieceO(){
        super(PieceType.O);
    }
}
