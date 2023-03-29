package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    PosterManager managerWithoutArgs = new PosterManager();
    PosterManager managerWithArgs = new PosterManager(4);

    String movie1 = "Movie 1";
    String movie2 = "Movie 2";
    String movie3 = "Movie 3";
    String movie4 = "Movie 4";
    String movie5 = "Movie 5";
    String movie6 = "Movie 6";

    // Тест на успешное добавление фильмов
    @Test
    public void shouldAddMovie() {
        managerWithoutArgs.addMovie(movie1);
        managerWithoutArgs.addMovie(movie2);
        managerWithoutArgs.addMovie(movie3);
        managerWithoutArgs.addMovie(movie4);
        managerWithoutArgs.addMovie(movie5);
        String[] expected = {movie1, movie2, movie3, movie4, movie5};
        String[] actual = managerWithoutArgs.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Тест, когда количество фильмов равно лимиту по умолчанию (без параметров)
    @Test
    public void shouldCorrectReverseArrayWithoutArgs() {
        managerWithoutArgs.addMovie(movie1);
        managerWithoutArgs.addMovie(movie2);
        managerWithoutArgs.addMovie(movie3);
        managerWithoutArgs.addMovie(movie4);
        managerWithoutArgs.addMovie(movie5);
        String[] expected = {movie5, movie4, movie3, movie2, movie1};
        String[] actual = managerWithoutArgs.getLastMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    // Тест, когда фильмов меньше чем лимит
    @Test
    public void shouldCorrectReverseArrayWithArgsLowerLimit() {
        managerWithArgs.addMovie(movie1);
        managerWithArgs.addMovie(movie2);

        String[] expected = {movie2, movie1};
        String[] actual = managerWithArgs.getLastMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    // Тест, когда фильмов больше чем лимит
    @Test
    public void shouldCorrectReverseArrayWithArgsHigherLimit() {
        managerWithArgs.addMovie(movie1);
        managerWithArgs.addMovie(movie2);
        managerWithArgs.addMovie(movie3);
        managerWithArgs.addMovie(movie4);
        managerWithArgs.addMovie(movie5);
        managerWithArgs.addMovie(movie6);

        String[] expected = {movie6, movie5, movie4, movie3};
        String[] actual = managerWithArgs.getLastMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    // Тест, когда количество фильмов равно лимиту
    @Test
    public void shouldCorrectReverseArrayWithArgsEqualsLimit() {
        managerWithArgs.addMovie(movie1);
        managerWithArgs.addMovie(movie2);
        managerWithArgs.addMovie(movie3);
        managerWithArgs.addMovie(movie4);

        String[] expected = {movie4, movie3, movie2, movie1};
        String[] actual = managerWithArgs.getLastMovies();

        Assertions.assertArrayEquals(expected, actual);
    }


}
