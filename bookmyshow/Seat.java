package bookmyshow;

class Seat {
    private Integer number;
    private SeatStatus status;
    private Integer price;

    Seat(Integer number, SeatStatus status, Integer price){
        this.number = number;
        this.status = status;
        this.price = price;
    }

    public Integer getPrice(){
        return this.price;
    }

    public void setStatus(SeatStatus seatStatus){
        this.status = seatStatus;
    }

    public SeatStatus getStatus(){
        return this.status;
    }

    public Integer getNumber(){
        return this.number;
    }
}

class NormalSeat extends Seat{
    NormalSeat(Integer number, SeatStatus status){
        super(number, status, 100);
    }
}

class PremiumSeat extends Seat{
    PremiumSeat(Integer number, SeatStatus status){
        super(number, status, 200);
    }
}
