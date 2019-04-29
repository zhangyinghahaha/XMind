package tij.unit11;

import tij.unit14.pets.Cat;
import tij.unit14.pets.Dog;
import tij.unit14.pets.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * PetMap class
 *
 * @author ying.zhang01
 * @date 2019/4/29
 */
public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        System.out.println(petMap);
        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
    }
}
