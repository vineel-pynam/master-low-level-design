package bookmyshow;
import java.util.*;

class Screen {
    private Integer id;
    private String name;
    private Movie movie;
    List<Show> shows;
    Screen(Integer screenNo, Integer numberOfShows, Movie movie){
        this.id = screenNo;
        this.name = "SCREEN-" + screenNo;
        this.shows = new ArrayList<>();
        this.movie = movie;
        initialize(numberOfShows, movie);
    }    

    private void initialize(Integer numberOfShows, Movie movie){
        for(int i=1; i<=numberOfShows; i++){
            this.shows.add(new Show(movie, i));
        }
    }

    public Movie getMovie(){
        return this.movie;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void display(){
        System.out.println("[NAME]: " + this.name);
        for( Show show: shows){
            show.display();
        }
    }
}
