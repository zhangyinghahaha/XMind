package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
    private CompactDisc cd;
    private int count = 0;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        this.cd.play();
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
}
