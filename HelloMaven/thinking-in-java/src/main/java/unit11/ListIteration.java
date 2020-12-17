package unit11;

import unit14.pets.*;

import java.util.List;
import java.util.ListIterator;

/**
 * ListIteration class
 *
 * @author ying.zhang01
 * @date 2019/4/28
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + ": ");
        }

        while(it.hasPrevious()) {
            System.out.println(it.previous().id() + " ");
        }
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);
        while(it.hasNext()) {
            it.next();
            it.set(Pets.randomPet());
        }
        System.out.println(pets);
    }
}
