package aop;

public class DefaultEncoreable implements Encoreable{
    @Override
    public void performEncore() {
        System.out.println("Default Encoreable!");
    }
}
