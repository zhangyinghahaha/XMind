package unit8;

class Actor {
    public void act() {

    }
}

class HappyActor extends Actor {
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {
    public void act() {
        System.out.println("SadActor");
    }
}

class DefaultActor extends Actor {
    public void act() {
        System.out.println("DefaultActor");
    }
}

class Stage {
    private Actor actor = new DefaultActor();
    public void change(int i) {
        switch (i) {
            case 1 : actor = new HappyActor();
                        break;
            case 2 : actor = new SadActor();
                        break;
            default: actor = new DefaultActor();
        }
    }

    public void performPlay() {
        actor.act();
    }
}

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change(1);
        stage.performPlay();
        stage.change(2);
        stage.performPlay();
        stage.change(3);
        stage.performPlay();
    }
}
