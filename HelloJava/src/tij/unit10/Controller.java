package tij.unit10;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class
 *
 * @author ying.zhang01
 * @date 2019/4/20
 */
public class Controller {
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event c) {
        eventList.add(c);
    }
    public void run() {
        while (eventList.size() > 0) {
            for(Event e : new ArrayList<Event>(eventList)) {
                if(e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
