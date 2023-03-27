package ru.netology.poster;

public class PosterManager {
    private String[] movies = new String[0];
    private int lastMoviesCount;


    public PosterManager() {
        this.lastMoviesCount = 5;
    }

    public PosterManager(int lastMoviesCount) {
        this.lastMoviesCount = lastMoviesCount;
    }

    public int getLastMoviesCount() {
        return lastMoviesCount;
    }

    public void addMovie(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] getLastMovies() {
        String[] all = this.movies;
        int lengthLast = this.getLastMoviesCount();
        String[] reversed = new String[all.length];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        String[] reversedWithCount = new String[lengthLast];
        for (int i = 0; i < lengthLast; i++) {
            reversedWithCount[i] = reversed[i];
        }
        return reversedWithCount;
    }

}
