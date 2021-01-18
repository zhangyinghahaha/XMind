package tacos.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    private String id;
    private String name;
    private Type type;

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Ingredient() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public static enum Type {
        /**
         * WARP
         */
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
