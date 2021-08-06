package typeinfo;

import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Pets {
    public static final PetCreator CREATOR = new LiteralPetCreator();

    public static Pet get() {
        return CREATOR.get();
    }

    public static Pet[] array(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = CREATOR.get();
        }
        return result;
    }

    public static List<Pet> list(int size) {
        List<Pet> result = new ArrayList<>();
        Collections.addAll(result, array(size));
        return result;
    }

    public static Stream<Pet> stream() {
        return Stream.generate(CREATOR);
    }
}
