package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spitter;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository{
    @Override
    public Spitter findByUsername(String username) {
        return new Spitter(username, "1", "1", "1", "1");
    }
}
