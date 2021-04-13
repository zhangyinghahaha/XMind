package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository{
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle((long)i, "Spittle " + i, new Date(), (double)i, (double)i));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long spittleId) {
        Spittle spittle = null;
        if (spittleId != 0) {
            spittle = new Spittle(spittleId, "Spittle " + spittleId, new Date(), 100d, 100d);
        }
        return spittle;
    }
}
