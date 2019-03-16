package unit8;

class Shared {
    private int refcount = 2;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }

    protected void dispose() {
        if(--refcount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    protected void finalize() {
        System.out.println("finalize");
        if(refcount > 0) {
            System.out.println("Error: not 0!");
        }
    }

    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    public String toString() {
        return "Compoing " + id;
    }
}

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared), new Composing(shared)};
        for(Composing c : composings) {
            c.dispose();
        }
    }
}
