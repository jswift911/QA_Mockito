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
        int fixedLength = this.getLastMoviesCount();

        String[] tmp = new String[movies.length + 1];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        if (tmp.length > fixedLength) {
            String[] fixedLengthTmp = new String[fixedLength];
            for (int i = 0; i < 3; i++) {
                fixedLengthTmp[i] = movies[i];
            }
        } else {
            tmp[tmp.length - 1] = movie;
            movies = tmp;
        }
    }

    public String[] findAll() {
        return movies;
    }

    public String[] getLastMovies() {
        String[] all = this.findAll();
        String[] reversed = new String[all.length];

        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }

        String[] reversedWithCount = new String[reversed.length];

        for (int i = 0; i < reversedWithCount.length; i++) {
            reversedWithCount[i] = reversed[i];
        }
        return reversedWithCount;
    }

}
