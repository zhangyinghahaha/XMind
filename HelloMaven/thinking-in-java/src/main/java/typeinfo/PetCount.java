package typeinfo;

import typeinfo.pets.Pet;

import java.util.HashMap;

public class PetCount {
    static class Counter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator petCreator) {
        Counter counter = new Counter();
        for (Pet pet : Pets.list(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) {
                counter.count("Pet");
            }
        }
    }

    public static void main(String[] args) {

    }
}
