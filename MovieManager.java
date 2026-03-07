package Baiseasion15;

import java.util.ArrayList;

public class MovieManager<T extends Movie>
{
    ArrayList<T> movies = new ArrayList<T>();

   public void addMovie(T movie)
   {
       movies.add(movie);
   }

    public void removeMovie(String id) {
        movies.removeIf(m -> m.getId().equals(id));
    }

    public void updateMovie(String id, String newTitle) {
        for (T m : movies) {
            if (m.getId().equals(id)) {
                m.setTitle(newTitle);
            }
        }
    }

    public void displayMovies() {
        for (T m : movies) {
            System.out.println(m);
        }
    }

    public void searchByTitle(String title) {
        for (T m : movies) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(m);
            }
        }
    }

    public void filterByRating(double rating) {
        for (T m : movies) {
            if (m.getRating() >= rating) {
                System.out.println(m);
            }
        }
    }
}
