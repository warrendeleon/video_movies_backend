package videomovies.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by DAM on 4/5/15.
 */

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String director;

    @Column
    @NotNull
    private int year;

    @Column
    @NotNull
    private String country;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Genre genre;


    public Movie() {
    }

    public Movie(String name, String director, int year, String country, Genre genre) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.country = country;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public Movie setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public Movie setDirector(String director) {
        this.director = director;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Movie setYear(int year) {
        this.year = year;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Movie setCountry(String country) {
        this.country = country;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Movie setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", genre=" + genre +
                '}';
    }
}
