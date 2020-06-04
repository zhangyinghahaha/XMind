package tij.typeinfo;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        // genericIntClass = double.class;
        intClass = double.class;
    }
}
