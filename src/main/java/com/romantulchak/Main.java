package com.romantulchak;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.manager.LinqManagerCollection;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.model.Person;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.romantulchak.enums.ComparisonConstant.EQUAL;

public class Main {

    public static void main(String[] args) {

        LinqManagerObject<Person> linqManagerObject = new LinqManagerObject<>();
//        Person persons = linqManagerObject
//                .linq()
//                .selectAll()
//                .from("test")
//                .execute();
//        System.out.println(persons);
//
//        Person execute = linqManagerObject
//                .linq()
//                .select("age")
//                .distinct()
//                .from("test")
//                .where("name", EQUAL, "roman")
//                .or("age", EQUAL, 21)
//                .execute();
//
//        System.out.println(execute);


        LinqManagerCollection<Person> collection = new LinqManagerCollection<>();
        Set<Person> test = new HashSet<>(collection.linq().selectAll().from("test").execute());
        System.out.println(test);

//        linqManagerObject.

//        linqManagerObject.linq().selectAll().from("test").execute();
//        System.out.println(execute);


    }
}
