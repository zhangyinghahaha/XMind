package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CDPlayer {
    private CompactDisc cd;
    private int count = 0;

//    public CDPlayer(CompactDisc cd) {
//        this.cd = cd;
//    }

    public void play() {
        this.cd.play();
        this.count++;
    }

    @Autowired
    public void setCd(CompactDisc cd){
        this.cd = cd;
    }

    public int getCount() {
        return this.count;
    }
}
