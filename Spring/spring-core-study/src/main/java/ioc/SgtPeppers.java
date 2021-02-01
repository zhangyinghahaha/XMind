package ioc;

import org.springframework.stereotype.Component;

@Component("myCD")
public class SgtPeppers implements CompactDisc{
    private String title = "Sgt. Pepper's Lonely";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + this.title + " by " + this.artist);
    }
}
