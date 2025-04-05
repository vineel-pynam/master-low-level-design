package bookmyshow;
import java.util.*;

public class Theatre {
    private Integer id;
    private String name;
    private List<Screen> screens;

    Theatre(Integer theatreNumber){
        this.id = theatreNumber;
        this.name = "Theatre-" + theatreNumber;
        this.screens = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public Integer getId(){
        return this.id;
    }

    public List<Screen> getScreens(){
        return this.screens;
    }

    public void addMovie(Movie movie, Integer numberOfShows){
        Integer nextScreenNo = screens.size() + 1;
        this.screens.add(new Screen(nextScreenNo, numberOfShows, movie));
    }

    public void display(){
        System.out.println("[THEATRE]: " + this.name);
        for( Screen screen : this.screens ){
            System.out.print("\t");
            screen.display();
        }
    }

    public void display(Movie movie){
        System.out.println("[THEATRE]: " + this.name);
        for( Screen screen : this.screens ){
            if( screen.getMovie().equals(movie) ){
                System.out.print("\t");
                screen.display();
            }
        }
    }
}
