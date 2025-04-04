package tic_tac_toe;

class Player {
    private String name;
    private Piece playingPiece;
    Player(String name, Piece playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public Piece getPlayingPiece(){
        return this.playingPiece;
    }

    public String getName(){
        return this.name;
    }

}
