package bookmyshow;

import java.util.*;
import java.util.concurrent.*;

class MovieManager {
    List<Theatre> theatres;
    List<Movie> movies;
    Map<Movie, List<Theatre>> theatreToMovieMap;
    List<Booking> bookings;

    private MovieManager(){
        this.movies = new CopyOnWriteArrayList<>();
        this.theatres = new CopyOnWriteArrayList<>();
        this.theatreToMovieMap = new ConcurrentHashMap<>();
        this.bookings = new CopyOnWriteArrayList<>();
       
        for(int number=1; number<=5; number++){
            this.theatres.add(new Theatre(number));
        }

    }
    public static class SingletonHelper{
        public static MovieManager INSTANCE = new MovieManager();
    }    

    public static MovieManager getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public void addMovie(Movie movie, Integer theatreNumber, Integer numberOfShows){
        this.movies.add(movie);
        Theatre theatre = theatres.get(theatreNumber-1);
        theatre.addMovie(movie, numberOfShows);

        this.theatreToMovieMap.computeIfAbsent(movie, e -> new ArrayList<>()).add(theatre);
    }

    public synchronized void bookSeats(User user, Movie movie, Integer theatreId, Integer screenId, Integer showTime, List<Integer> seatIds){
        List<Theatre> theatres = theatreToMovieMap.get(movie);
        if( theatres.isEmpty() ) {
            System.out.println("Movie is not playing in the theatre");
            return;
        }
        Theatre theatre = theatres.stream().filter(th -> th.getId().equals(theatreId)).findFirst().orElse(null);
        if( theatre == null ) {
            System.out.println("Theatre Not Found");
            return;
        }

        Screen selectedScreen = null;
        Show selectedShow = null;

        for( Screen screen : theatre.getScreens() ){
            if( screen.getId().equals(screenId) ){
                
                for( Show show : screen.shows ){
                    if( show.getTime().equals(showTime) ){
                        selectedScreen = screen;
                        selectedShow = show;
                        break;
                    }
                }
            }
        }

        if( selectedScreen == null || selectedShow == null ){
            System.out.println("Show Not Found");
            return;
        }

        List<Seat> seatsBooked = selectedShow.BookSeats(seatIds);
        
        if( seatsBooked.isEmpty() ){
            System.out.println("Unable to selected Seats");
            return;
        }

        Integer price = seatsBooked.stream().mapToInt(Seat::getPrice).sum();

        Booking booking = new Booking(user, movie, selectedScreen, theatre, selectedShow, price, seatsBooked);
        this.bookings.add(booking);
    }

    public void displayBooking(){
        for(Booking booking: this.bookings){
            booking.display();
        }
    }

    public void displayMovies(){
        for( Movie movie: this.movies ){
            System.out.println("[MOVIE]: " + movie.getName());
        }
    }

    public void getShows(Movie movie){
        List<Theatre> theatres = this.theatreToMovieMap.get(movie);
        if( theatres.size() == 0 ){
            System.out.println("No Shows Available");
            return;
        }

        for( Theatre theatre: theatres ){
            theatre.display(movie);
        }
    }
    
}
