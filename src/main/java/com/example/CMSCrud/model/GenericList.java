package com.example.CMSCrud.model;

import java.util.*;
import java.util.stream.Collectors;

public class GenericList<T> {

public static void main(String[] args) {


        List<Movie> movies= List.of(new Movie("a", 10),
                                    new Movie("z", 10),
                                    new Movie("b", 15),
                                    new Movie("c", 20));

      // movies.stream().map(m -> m.getLikes()).distinct().forEach(System.out::println);
         movies.stream().filter(movie -> movie.getLikes() > 10).collect(Collectors.toList()).forEach(System.out::println);
         //System.out.println(lst);
}
}