package typeinfo;

class Building {}
class House extends Building {
    public void say() {
        System.out.println("I am a house");
    }
}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
    }
}
