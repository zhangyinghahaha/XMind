package unit11;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.Iterator;
import java.util.List;

/**
 * SimpleIteration class
 *
 * @author ying.zhang01
 * @date 2019/4/28
 */
public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
        for(Pet p : pets){
            System.out.println(p.id() + ":" + p + " ");
        }
    }
}
