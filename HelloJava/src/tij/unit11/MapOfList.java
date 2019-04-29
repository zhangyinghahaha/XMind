package tij.unit11;

import tij.unit14.pets.*;

import java.util.*;

/**
 * MapOfList class
 *
 * @author ying.zhang01
 * @date 2019/4/29
 */
public class MapOfList {
    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<>();
    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"), new Dog("Margrett")));
        petPeople.put(new Person("Isaac"), Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {
        System.out.println("People: " + petPeople.keySet());
        System.out.println("Pets: " + petPeople.values());
        for(Person person : petPeople.keySet()) {
            System.out.println(person + "has: ");
            for(Pet pet : petPeople.get(person)) {
                System.out.println("    " + pet);
            }
        }

        petPeople.entrySet();
    }
}
