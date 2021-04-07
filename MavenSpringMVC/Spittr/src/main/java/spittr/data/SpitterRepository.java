package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {
    Spitter findByUsername(String username);
}
