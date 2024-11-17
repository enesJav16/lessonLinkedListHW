package services;

import enums.Genre;
import models.Movie;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface MovieFindableService {
    ArrayList<Movie> getAllMovies();
    Movie findMovieByFullNameOrPartName(String name);
    ArrayList<Movie> findMoviesByActorName(String actorName);
    ArrayList<Movie> findMoviesByYear(int year);
    ArrayList<Movie> findMoviesByProducer(String producerFullName);
    ArrayList<Movie> findMoviesByGenre(Genre genre);

}
