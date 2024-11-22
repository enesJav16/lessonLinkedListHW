import database.Database;
import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Actor actor1=new Actor("RoleMC","Actor1FullName");
        Actor actor2=new Actor("RoleMC","Actor2FullName");
        Actor actor3=new Actor("RoleMC","Actor3FullName");
        Actor actor4=new Actor("RoleSC","Actor4FullName");
        Actor actor5=new Actor("RoleSC","Actor5FullName");
        Actor actor6=new Actor("RoleSC","Actor6FullName");
        Database.actors.add(actor1);
        Database.actors.add(actor2);
        Database.actors.add(actor3);
        Database.actors.add(actor4);
        Database.actors.add(actor5);
        Database.actors.add(actor6);

        Producer producer1=new Producer("Producer1Name","Producer1LastName");
        Producer producer2=new Producer("Producer2Name","Producer2LastName");
        Producer producer3=new Producer("Producer3Name","Producer3LastName");
        Database.producers.add(producer1);
        Database.producers.add(producer2);
        Database.producers.add(producer3);

        Movie movie1=new Movie("Movie 111 Name", Genre.DETECTIVE,  LocalDate.of(2015,5,15),producer1,new LinkedList<Actor>(List.of(actor1,actor2,actor3,actor4)));
        Movie movie2=new Movie("Movie 222 Name", Genre.ROMANCE,    LocalDate.of(2014,4,14),producer2,new LinkedList<Actor>(List.of(actor5,actor6,actor3,actor4)));
        Movie movie3=new Movie("Movie 333 Name", Genre.ROMANCE,  LocalDate.of(2013,3,13),producer2,new LinkedList<Actor>(List.of(actor1,actor3,actor5,actor4)));
        Movie movie4=new Movie("Movie 444 Name", Genre.DRAMA,     LocalDate.of(2012,2,12),producer3,new LinkedList<Actor>(List.of(actor1,actor2,actor6,actor6)));
        Movie movie5=new Movie("Movie 555 Name", Genre.DETECTIVE, LocalDate.of(2011,1,11),producer3,new LinkedList<Actor>(List.of(actor6,actor5,actor3,actor4)));
        Database.movies.add(movie1);
        Database.movies.add(movie2);
        Database.movies.add(movie3);
        Database.movies.add(movie4);
        Database.movies.add(movie5);


        Start.start();
    }
}