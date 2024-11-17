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

        Movie movie1=new Movie("Movie One Name", Genre.DETECTIVE,  LocalDate.of(2020,10,10),producer1,new LinkedList<Actor>(List.of(actor1,actor2,actor3,actor4)));
        Movie movie2=new Movie("Movie Two Name", Genre.ROMANCE,    LocalDate.of(2020,10,10),producer2,new LinkedList<Actor>(List.of(actor5,actor6,actor3,actor4)));
        Movie movie3=new Movie("Movie Three Name", Genre.ROMANCE,  LocalDate.of(2020,10,10),producer2,new LinkedList<Actor>(List.of(actor1,actor3,actor5,actor4)));
        Movie movie4=new Movie("Movie Four Name", Genre.DRAMA,     LocalDate.of(2020,10,10),producer3,new LinkedList<Actor>(List.of(actor1,actor2,actor6,actor6)));
        Movie movie5=new Movie("Movie Five Name", Genre.DETECTIVE, LocalDate.of(2020,10,10),producer3,new LinkedList<Actor>(List.of(actor6,actor5,actor3,actor4)));
        Database.movies.add(movie1);
        Database.movies.add(movie2);
        Database.movies.add(movie3);
        Database.movies.add(movie4);
        Database.movies.add(movie5);


        Start.start();
    }
}