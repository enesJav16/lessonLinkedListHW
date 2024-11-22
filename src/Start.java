import com.sun.security.jgss.GSSUtil;
import database.Database;
import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;
import services.serviceImpl.MovieFindableServiceImpl;

import java.util.*;

public class Start {


    public static void start() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        MovieFindableServiceImpl movieFS = new MovieFindableServiceImpl();

        while (true) {

            System.out.println("Chose action:");
            System.out.println("""
                    1.Get all Movies
                    2.Find Movie By Full Name or Part Name
                    3.Find Movies by actor name
                    4.Find Movies by year
                    5.Find Movies by Producer name
                    6.Find Movies by Genre
                    """);
            int input = scanner1.nextInt();
            switch (input) {
                case 1 ->{
                        System.out.println(movieFS.getAllMovies());
                        sort(movieFS.getAllMovies());
                }

                case 2 -> {
                    System.out.println("Give movie name:");
                    String movieNameInput = scanner.nextLine();
                    if (movieFS.findMovieByFullNameOrPartName(movieNameInput) == null) {
                        System.out.println("There is no movie with that name.\nMovies:");
                        for (Movie m : Database.movies) {
                            System.out.println(m.getName());
                        }
                    } else {
                        System.out.println(movieFS.findMovieByFullNameOrPartName(movieNameInput));
                    }

                }
                case 3 -> {
                    System.out.println("Give actors name");
                    String actorNameInput = scanner.nextLine();
                    if (movieFS.findMoviesByActorName(actorNameInput).isEmpty()) {
                        System.out.println("We dont have this actors movies.\nActors we have:");
                        for (Actor a : Database.actors) {
                            System.out.println(a.getFullName());
                        }
                    } else {
                        sort(movieFS.findMoviesByActorName(actorNameInput));
                    }
                }
                case 4 -> {
                    while (true) {
                        try {
                            System.out.println("Give year:");
                            int yearInput = scanner1.nextInt();
                            if (movieFS.findMoviesByYear(yearInput).isEmpty()) {
                                System.out.println("No movie found.");
                            } else {
                                sort(movieFS.findMoviesByYear(yearInput));
                            }
                            break;
                        }catch (InputMismatchException e){
                            System.out.println("Give correct format.(number)");
                            scanner1.nextLine();
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Give producers full name ");
                    String producerNameInput = scanner.nextLine();
                    if (movieFS.findMoviesByProducer(producerNameInput).isEmpty()) {
                        System.out.println("We dont have this producers movies.\nProducers we have:");
                        for (Producer p : Database.producers) {
                            System.out.println(p.getFirstName() + " " + p.getLastName());
                        }
                    } else {
                        sort(movieFS.findMoviesByProducer(producerNameInput));
                    }
                }
                case 6 -> {
                    System.out.println("Which genre do you want to search:");
                    String genreInput = scanner.nextLine();
                    boolean check=false;
                    Genre genre=Genre.DETECTIVE;
                    for (Genre g : Genre.values()) {
                        if (g.name().equalsIgnoreCase(genreInput)) {
                            genre=g;
                            check=true;
                        }
                    }
                    if(check){
                        sort(movieFS.findMoviesByGenre(genre));
                    }else{
                        System.out.println("No data found.");
                    }
                }
            }

        }
    }
    static void sort(ArrayList<Movie>m) {
        boolean check = true;
        while (check) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do.");
            System.out.println("""
                    1.Sort from A to Z
                    2.Sort from Z to A
                    3.Sort by Year INCREASE
                    4.Sort by Year DECREASE
                    5.Sort by Producer name
                    0.go to main.
                    """);
            int input = scanner.nextInt();
            switch (input) {
                case 1-> {
                    Collections.sort(m,Movie.nameComparator);
                    System.out.println(m);
                }
                case 2-> {
                    Collections.sort(m,Movie.nameComparator);
                    System.out.println(m.reversed());
                }
                case 3->{
                    Collections.sort(m,Movie.yearComparator);
                    System.out.println(m);
                }
                case 4->{
                    Collections.sort(m,Movie.yearComparator);
                    System.out.println(m.reversed());
                }
                case 5->{
                    Collections.sort(m,Movie.producernameComparator);
                    System.out.println(m);
                }
                case 0-> check=false;

                default -> System.out.println("No such action.");
            }
        }
    }
}
