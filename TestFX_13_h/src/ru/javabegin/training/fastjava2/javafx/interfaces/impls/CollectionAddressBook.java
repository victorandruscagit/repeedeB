package ru.javabegin.training.fastjava2.javafx.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.javabegin.training.fastjava2.javafx.interfaces.AdressBook;
import ru.javabegin.training.fastjava2.javafx.objects.Person;

import java.util.ArrayList;
import java.util.List;

public class CollectionAddressBook implements AdressBook {

    private ObservableList<Person> personlist = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonlist() {
        return personlist;
    }

    @Override
    public void add(Person person) {
        personlist.add(person);

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personlist.remove(person);
    }

    private ObservableList<Person> getPersonList() {
        return personlist;
    }

    public void print() {
        int number = 0;
        System.out.println();
        for (Person person : personlist) {
            number++;
            System.out.println(number + ") fio = " + person.getFio() + "; phone = " + person.getPhone());

        }
        ;
    }

    public void feedTestData() {
        personlist.add(new Person("Ivan", "11111"));
        personlist.add(new Person("Andrei", "222"));
        personlist.add(new Person("Grigore", "3333"));
        personlist.add(new Person("Mashka", "4444"));
        personlist.add(new Person("Zidane", "5555"));
        personlist.add(new Person("Ronaldo", "7777"));
    }
}
