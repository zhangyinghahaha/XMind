package unit8;

class Characteristic {
    private String s;

    Characteristic(String s) {
        this.s = s;
        System.out.println("Create Characteristic " + s);
    }

    protected void dispose() {
        System.out.println("disposing Characteristic" + s);
    }
}

class Description {
    private String s;

    Description(String s) {
        this.s = s;
        System.out.println("Description " + s);
    }

    protected void dispose() {
        System.out.println("disposing Description" + s);
    }
}

class LivingCreature {
    private Characteristic p = new Characteristic("is alive");
    private Description t = new Description("Basic Living Creature");

    LivingCreature() {
        System.out.println("LivingCreature");
    }

    protected void dispose() {
        System.out.println("LivingCreature dispose");
        t.dispose();
        p.dispose();
    }
}

public class Frog {
}
