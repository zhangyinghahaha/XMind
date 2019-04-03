package unit9;

interface CanFight {
    void fight();
}

class ActionCharacter {
    public void fight() {

    }
}

class Hero extends ActionCharacter implements CanFight {

}

public class Adventure {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.fight();
    }
}
