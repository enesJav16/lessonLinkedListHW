package services.serviceImpl;

import database.Database;
import enums.Genre;
import models.Actor;
import models.Movie;
import services.MovieFindableService;

import java.time.LocalDate;
import java.util.ArrayList;

public class MovieFindableServiceImpl implements MovieFindableService {
    @Override
    public ArrayList<Movie> getAllMovies() {
        return Database.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie m : Database.movies) {
            String movieName = m.getName().toLowerCase();
            String searchName = name.toLowerCase();
            if (movieName.equals(searchName) || movieName.contains(searchName)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Movie> findMoviesByActorName(String actorName) {
        ArrayList<Movie> retMovies = new ArrayList<>();
        for (Movie m : Database.movies) {
            for (Actor a : m.getActors()) {
                if (a.getFullName().equalsIgnoreCase(actorName)) {
                    retMovies.add(m);
                }
            }
        }
        return retMovies;
    }

    @Override
    public ArrayList<Movie> findMoviesByYear(int year) {
        ArrayList<Movie> retMovies = new ArrayList<>();
        for (Movie m : Database.movies) {
            if (m.getYear().getYear() == year) {
                retMovies.add(m);
            }
        }
        return retMovies;
    }

    @Override
    public ArrayList<Movie> findMoviesByProducer(String producerFullName) {
        ArrayList<Movie> retMovies = new ArrayList<>();
        for (Movie m : Database.movies) {
            String fullName = m.getProducer().getFirstName() + " " + m.getProducer().getLastName();
            if (fullName.equalsIgnoreCase(producerFullName)) {
                retMovies.add(m);
            }
        }
        return retMovies;
    }

    @Override
    public ArrayList<Movie> findMoviesByGenre(Genre genre) {
        ArrayList<Movie> retMovies = new ArrayList<>();
        for (Movie m : Database.movies) {
            if (m.getGenre() == genre) {
                retMovies.add(m);
            }
        }
        return retMovies;
    }
}
