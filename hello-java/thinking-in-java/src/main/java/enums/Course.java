package enums;

public enum Course {
    /**
     *
     */
    APPETIZER(Food.Appetiezer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;
    Course(Class<? extends Food> kind) {
        this.values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}
