package com.romantulchak;

import com.romantulchak.db.DatabaseConnection;
import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqManager;
import com.romantulchak.model.Person;

import static com.romantulchak.enums.ComparisonConstant.*;
import static com.romantulchak.enums.ComparisonConstant.EQUAL;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Roman");


        LinqManager<Person> linqManager = new LinqManager<>();
        linqManager.linq().selectAll().from("Test").where("name", EQUAL, "roman").ok().execute();

        DatabaseConnection.getInstance("/home/romantulchak/IdeaProjects/JavaLINQ/src/main/resources/config.properties");
    }
}
