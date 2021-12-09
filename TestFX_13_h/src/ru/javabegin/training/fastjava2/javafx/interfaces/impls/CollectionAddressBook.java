package ru.javabegin.training.fastjava2.javafx.interfaces.impls;

import ru.javabegin.training.fastjava2.javafx.interfaces.AdressBook;
import ru.javabegin.training.fastjava2.javafx.objects.Person;

import java.util.ArrayList;
import java.util.List;

public class CollectionAddressBook implements AdressBook {
    private List<Person> personList  = new ArrayList<>();

    @Override
    public void add(Person person) {
        personList.add(person);

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }
    private List<Person> getPersonList(){
        return personList;
    }
    public  void  print(){
        int number = 0;
        System.out.println();
        for (Person person : personList) {
            number++;
            System.out.println(number + ") fio = " + person.getFio() + "; phone = " + person.getPhone());

        }
        ;
    }
    public void feedTestData(){
        personList.add(new Person("Ivan", "11111"));
        personList.add(new Person("Andrei", "222"));
        personList.add(new Person("Grigore", "3333"));
        personList.add(new Person("Mashka", "4444"));
    }
}
