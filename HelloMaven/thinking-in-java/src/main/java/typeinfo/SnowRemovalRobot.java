package typeinfo;

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot{
    private String name;
    private List<Operation> operations = Arrays.asList(
            new Operation(
                    () -> name + " can shovel snow",
                    () -> System.out.println(name + " shoveling sonw")
            ),
            new Operation(
                    () -> name + " can clear the roof",
                    () -> System.out.println(name + " clearing roof")
            )
    );

    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operations() {
        return operations;
    }

    public static void main(String[] args) {
        Robot.test(new SnowRemovalRobot("Slusher"));
    }
}
