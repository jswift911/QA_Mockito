package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PosterManagerTest {

    PosterManager managerWithoutArgs = new PosterManager();
    PosterManager managerWithArgs = new PosterManager(4);
    PosterManager mockitoManager = mock(PosterManager.class);

    String movie1 = "Movie 1";
    String movie2 = "Movie 2";
    String movie3 = "Movie 3";
    String movie4 = "Movie 4";
    String movie5 = "Movie 5";
    String movie6 = "Movie 6";
    String movie7 = "Movie 7";
    String movie8 = "Movie 8";


    @BeforeEach
    public void setup() {
        //Менеджер с аргументами по умолчанию (5 штук)
        managerWithoutArgs.addMovie(movie1);
        managerWithoutArgs.addMovie(movie2);
        managerWithoutArgs.addMovie(movie3);
        managerWithoutArgs.addMovie(movie4);
        managerWithoutArgs.addMovie(movie5);

        //Менеджер с выставляемыми аргументами
        managerWithArgs.addMovie(movie1);
        managerWithArgs.addMovie(movie2);
        managerWithArgs.addMovie(movie3);
        managerWithArgs.addMovie(movie4);
        managerWithArgs.addMovie(movie5);
        managerWithArgs.addMovie(movie6);
        managerWithArgs.addMovie(movie7);
        managerWithArgs.addMovie(movie8);
    }

    @Test
    public void shouldAddMovie() {
        String[] expected = {movie1, movie2, movie3, movie4, movie5};
        String[] actual = managerWithoutArgs.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCorrectReverseArrayWithoutArgs() {
        String[] expected = {movie5, movie4, movie3, movie2, movie1};
        String[] actual = managerWithoutArgs.getLastMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCorrectReverseArrayWithArgs() {
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
