package ioc;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers2 implements CompactDisc{
    private String title = "Sgt. Pepper's Lonely2";
    private String artist = "The Beatles2";

    @Override
    public void play() {
        System.out.println("Playing " + this.title + " by " + this.artist);
    }
}
