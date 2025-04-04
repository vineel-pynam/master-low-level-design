package snakes_and_ladders;

class Player {
    private String name;
    private Integer currentPosition = 0;

    Player(String name){
        this.name = name;
    }

    public void setCurrentPosition(Integer position){
        this.currentPosition = position;
    }

    public Integer getCurrentPosition(){
        return this.currentPosition;
    }

    public String getName(){
        return this.name;
    }
}
