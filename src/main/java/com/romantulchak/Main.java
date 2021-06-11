package com.romantulchak;

import com.romantulchak.linq.Manager;
import com.romantulchak.linq.manager.LinqManagerCollection;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.model.Person;

public class Main {

    public static void main(String[] args) {

        Manager<Person> linqManagerObject = new LinqManagerCollection<>();
//        Person persons = linqManagerObject
//                .linq()
//                .selectAll()
//                .from("test")
//                .execute();
//        System.out.println(persons);

        Person test = linqManagerObject.linq().selectAll().from("test").execute();
        System.out.println(test);


    }
}
