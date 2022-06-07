package typeinfo;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = Integer.class;
        Class<?> genericIntClass = int.class;
        genericIntClass = double.class;
        //intClass = double.class;
        System.out.println(intClass.isInstance(Integer.valueOf(1)));
    }
}
