package snakes_and_ladders;

class Cell{
    private Integer row;
    private Integer col;
    private Integer number;
    private Cell destination;

    Cell(Integer row, Integer col, Integer number, Cell desination){
        this.row = row;
        this.col = col;
        this.destination = desination;
        this.number = number;
    }

    public Integer getRow() {
        return this.row;
    }

    public Integer getCol() {
        return this.col;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Cell getDestination() {
        return this.destination;
    }

    public void setDesitnation(Cell destination) {
        this.destination = destination;
    }
}