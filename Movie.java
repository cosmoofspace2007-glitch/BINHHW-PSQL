package Baiseasion15;

import java.time.LocalDate;

public class Movie
{
    protected String id;
    protected String title;
    protected String director;
    protected LocalDate releaseDate;
    protected double rating;

    public Movie(String director, String id, String rating, LocalDate releaseDate, String title) {
        this.director = director;
        this.id = id;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "ID: " + id +
                " | Title: " + title +
                " | Director: " + director +
                " | Date: " + releaseDate +
                " | Rating: " + rating;
    }
}
