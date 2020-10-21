package test;

import java.util.Map;

public class Event {
    private String eventCode;
    private Map<Object, Object> attributes = null;

    public Event(String eventCode) {
        this.eventCode = eventCode;
    }

    public Event(String eventCode, Map<Object, Object> attributes) {
        this.eventCode = eventCode;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return eventCode;
    }
}
