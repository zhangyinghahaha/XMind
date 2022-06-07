package enums;

import java.util.stream.Stream;

/**
 * @author ying.zhang01
 */
public enum OzWitch {
    /**
     *
     */
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private String description;
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        String id = this.name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for(OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
        System.out.println();

        Stream.of(values())
                .forEach(value -> {
                    System.out.println(value.name());
                    System.out.println(value);
                });
    }
}
