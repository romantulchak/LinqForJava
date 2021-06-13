package com.romantulchak;

import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.Manager;
import com.romantulchak.linq.manager.LinqManagerCollection;
import com.romantulchak.linq.manager.LinqManagerObject;
import com.romantulchak.model.Person;

public class Main {

    public static void main(String[] args) {

        LinqManagerObject<Person> linqManagerObject = new LinqManagerObject<>();
//        Person persons = linqManagerObject
//                .linq()
//                .selectAll()
//                .from("test")
//                .execute();
//        System.out.println(persons);

        Person execute = linqManagerObject
                .linq()
                .selectAll()
                .distinct()
                .from("test")
                .where("name", ComparisonConstant.EQUAL, "roman")
                .execute();


//        linqManagerObject.linq().selectAll().from("test").execute();
        System.out.println(execute);


    }
}
