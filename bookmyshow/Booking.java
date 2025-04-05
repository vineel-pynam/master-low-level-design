package bookmyshow;
import java.util.*;
class Booking {
    private User user;
    private Movie movie;
    private Screen screen;
    private Theatre theatre;
    private Show show;
    private Integer price;
    private List<Seat> seats;
    
    Booking(User user, Movie movie, Screen screen, Theatre theatre, Show show, Integer price, List<Seat> seats){
        this.user = user;
        this.movie = movie;
        this.screen = screen;
        this.theatre = theatre;
        this.show = show;
        this.seats = seats;
        this.price = price;
    }

    public void display(){
        System.out.println("----------- Booking Info ----------");
        System.out.println("[USER]: " + user.getName());
        System.out.println("[MOVIE]: " + movie.getName());
        System.out.println("[THEATRE]: " + theatre.getName());
        System.out.println("[SCREEN]: " + screen.getName());
        System.out.println("[SHOW TIME]: " + show.getTime());
        System.out.println("[PRICE]: " + this.price);
        System.out.print("[SEATS]: ");
        for( Seat seat : seats ){
            System.out.print(seat.getNumber() + ", ");
        }
        System.out.println();
        System.out.println("-------------------------------------");

    }
}
