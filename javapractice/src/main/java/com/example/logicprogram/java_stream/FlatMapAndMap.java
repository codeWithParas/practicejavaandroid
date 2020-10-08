package com.example.logicprogram.java_stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// refer : https://www.youtube.com/watch?v=tJ-7k2WBj24
public class FlatMapAndMap {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("FlatMapExample", "JavaFlatMap");

        List<String[]> collect = list.stream().map(s -> s.split(""))
                .distinct()
                .collect(Collectors.toList());

        Stream<String[]> stream = list.stream().map(s -> s.split(""));

        List<String> collect1 = list.stream().map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect1);

        /*for (int i = 0; i < collect.size(); i++) {
            //System.out.println(collect.get(i));
            System.out.println(collect1.get(i));
        }*/

    }
}
