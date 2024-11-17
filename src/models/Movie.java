package models;

import enums.Genre;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;

public class Movie {
    private String name;
    private Genre genre;
    private LocalDate year;
    private Producer producer;
    private LinkedList<Actor>actors;


    public Movie(){}
    public Movie(String name, Genre genre, LocalDate year, Producer producer, LinkedList<Actor> actors) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.producer = producer;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public LinkedList<Actor> getActors() {
        return actors;
    }

    public void setActors(LinkedList<Actor> actors) {
        this.actors = actors;
    }


    public static Comparator<Movie>nameComparator =(m1,m2)->m1.getName().compareTo(m2.getName());
    public static Comparator<Movie>yearComparator =(m1,m2)->m1.getYear().compareTo(m2.getYear());
    public static Comparator<Movie>producernameComparator =(m1,m2)->m1.getProducer().getFirstName().compareTo(m2.getProducer().getFirstName());


    @Override
    public String toString() {
        return "======================="+
                "\nname    : " + name +
                "\ngenre   : " + genre +
                "\nyear    : " + year +
                "\nproducer: " + producer +
                "\nactors  : " + actors +
                "\n=======================";
    }
}
