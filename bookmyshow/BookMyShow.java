package bookmyshow;

import java.util.Arrays;

public class BookMyShow {
    public static void main(String[] args) {
        MovieManager movieManager = MovieManager.getInstance();
        
        User vineel = new User("Vineel");
        Movie movie = new Movie(1, "KGF-2");

        movieManager.addMovie(movie, 1, 2);

        movieManager.displayMovies();
        movieManager.getShows(movie);

        movieManager.bookSeats(vineel, movie, 1, 1, 1, Arrays.asList(1, 2));

        movieManager.displayBooking();
    }
}
