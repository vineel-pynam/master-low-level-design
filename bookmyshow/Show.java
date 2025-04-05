package bookmyshow;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Show {
    private Movie movie;
    private List<Seat> seats;
    private Integer time;

    Show(Movie movie, Integer time){
        this.movie = movie;
        this.time = time;
        this.seats = new ArrayList<>();

        initializeSeats();
    }

    public Integer getTime(){
        return this.time;
    }

    private void initializeSeats(){
        // Normal Seat
        for( int i=1; i<=5; i++ ){
            this.seats.add(new NormalSeat(i, SeatStatus.UN_BOOKED));
        }

        // Premium Seat
        for( int i=6; i<=10; i++ ){
            this.seats.add(new PremiumSeat(i, SeatStatus.UN_BOOKED));
        }
    }

    public void display(){
        System.out.println("\t\t[MOVIE]: " + movie.getName());
        System.out.println("\t\t[TIME]: " + this.time);
    }

    public List<Seat> availableSeats(){
        return this.seats.stream().filter(seat -> seat.getStatus().equals(SeatStatus.UN_BOOKED)).collect(Collectors.toList());
    }

    public synchronized List<Seat> BookSeats(List<Integer> seats){
        Map<Integer, Seat> seatMap = this.seats.stream().collect(Collectors.toMap(Seat::getNumber, seat -> seat));

        if( !seatMap.keySet().containsAll(seats) ) return Collections.emptyList();

        List<Seat> seatsToBook = seats.stream().map(seatMap::get).toList();

        if( seatsToBook.stream().anyMatch(seat -> seat.getStatus() == SeatStatus.BOOKED) ) return Collections.emptyList();

        for( Seat seat : seatsToBook ) seat.setStatus(SeatStatus.BOOKED);

        return seatsToBook;

    }
}
