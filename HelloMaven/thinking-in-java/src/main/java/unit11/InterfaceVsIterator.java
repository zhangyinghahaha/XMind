package unit11;

import unit14.pets.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * InterfaceVsIterator class
 *
 * @author ying.zhang01
 * @date 2019/5/5
 */
public class InterfaceVsIterator {
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void display(Collection<Pet> pets) {
        for(Pet p : pets) {
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> petList = Pets.arrayList(8);
    }
}
