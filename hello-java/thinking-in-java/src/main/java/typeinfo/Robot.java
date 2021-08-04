package typeinfo;

import java.util.List;

public interface Robot {
    String name();
    String model();
    List<Operation> operations();

    static void test(Robot r) {
        if (r instanceof Null) {
            System.out.println("[Null Robot]");
        }
        System.out.println("Robot name: " + r.name());
        System.out.println("Robot model: " + r.model());
        for (Operation operation : r.operations()) {
            System.out.println(operation.description.get());
            operation.command.run();
        }
    }
}
