package unit8;

import unit8.Note;

public interface Instrument {
    int VALUE = 5;
    void play(Note n);
    void adjust();
}
