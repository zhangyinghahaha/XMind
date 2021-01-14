package typeinfo;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<?> genericIntClass = int.class;
        genericIntClass = double.class;
        intClass = double.class;
    }
}
