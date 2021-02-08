package typeinfo;

import java.util.Optional;
import java.util.function.Supplier;

public class Operation {
    public final Supplier<String> description;
    public final Runnable command;

    public Operation(Supplier<String> descr, Runnable cmd) {
        this.description = descr;
        this.command = cmd;
    }
}
