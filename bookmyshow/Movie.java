package bookmyshow;

import java.util.Objects;

class Movie {
    private Integer id;
    private String name;

    Movie(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object obj){
        if( this == obj ) return true;
        if( obj == null || getClass() != obj.getClass() ) return false;
        Movie m = (Movie) obj;
        return this.id.equals(m.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
