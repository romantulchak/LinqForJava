package com.romantulchak;

import com.romantulchak.db.DatabaseConnection;
import com.romantulchak.enums.ComparisonConstant;
import com.romantulchak.linq.LinqManager;
import com.romantulchak.model.Person;

import static com.romantulchak.enums.ComparisonConstant.*;
import static com.romantulchak.enums.ComparisonConstant.EQUAL;

public class Main {

    public static void main(String[] args) {

        LinqManager<Person> linqManager = new LinqManager<>();
        Person person = linqManager
                .linq()
                .select("name", "height")
                .from("test")
                .where("name", EQUAL, "roman")
                .execute(Person.class);
        System.out.println(person);


    }
}
