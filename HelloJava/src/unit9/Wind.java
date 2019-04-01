package unit9;

import unit8.Note;
import unit8.Instrument;

public class Wind implements Instrument {
    public void play(Note n) {

        System.out.println(this + ".play()" + n);
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }

    public String toString() {
        return "Wind";
    }

    public static void main(String[] args) {
        Instrument wind = new Wind();
        wind.adjust();
    }
}
