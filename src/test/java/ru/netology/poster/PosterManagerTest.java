package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();
    PosterManager managerWithArgs = new PosterManager(4);
    PosterManager mockitoManager = mock(PosterManager.class);

    String movie1 = "Film 1";
    String movie2 = "Film 2";
    String movie3 = "Film 3";
    String movie4 = "Film 4";
    String movie5 = "Film 5";
    String movie6 = "Film 6";
    String movie7 = "Film 7";
    String movie8 = "Film 8";


    @Test
    public void shouldAddMovie() {
        manager.addMovie(movie1);
        manager.addMovie(movie2);

        String[] expected = {movie1, movie2};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCorrectReverseArrayWithoutCount() {
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);

        String[] expected = {movie5, movie4, movie3, movie2, movie1};
        String[] actual = manager.getLastMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCorrectReverseArrayWithCount() {
        managerWithArgs.addMovie(movie1);
        managerWithArgs.addMovie(movie2);
        managerWithArgs.addMovie(movie3);
        managerWithArgs.addMovie(movie4);
        managerWithArgs.addMovie(movie5);
        managerWithArgs.addMovie(movie6);
        managerWithArgs.addMovie(movie7);
        managerWithArgs.addMovie(movie8);

        String[] expected = {movie8, movie7, movie6, movie5};
        String[] actual = managerWithArgs.getLastMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    // Тест на mockito
    @Test
    public void mockitoGetLastMoviesCount() {
        when(mockitoManager.getLastMoviesCount()).thenReturn(5);

        int expected = 5;
        int actual = mockitoManager.getLastMoviesCount();

        Assertions.assertEquals(expected, actual);
    }

}
