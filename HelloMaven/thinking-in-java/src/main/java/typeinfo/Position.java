package typeinfo;

import java.util.Optional;

class EmptyTitleException extends RuntimeException {}

public class Position {
    private String title;
    private Person person;

    Position(String jobTitle, Person employee) {
        this.setTitle(jobTitle);
        this.setPerson(employee);
    }

    Position(String jobTitle) {
        this(jobTitle, null);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newTitle) {
        title = Optional.ofNullable(newTitle).orElseThrow(EmptyTitleException::new);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        // Uses empty Person if newPerson is null:
        person = Optional.ofNullable(newPerson).orElse(new Person());
    }

    @Override
    public String toString() {
        return "Position: " + title + ", Employee: " + person;
    }

    public static void main(String[] args) {
        System.out.println(new Position("CEO"));
        System.out.println(new Position("Programmer", new Person("Arthur", "Fonzarlli")));

    }
}
