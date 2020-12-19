package command;

/**
 * Command interface
 *
 * @author ying.zhang01
 * @date 2020/3/10
 */
public interface Command {

    /**
     * 执行命令
     */
    void execute();

    /**
     * 撤销命令
     */
    void undo();
}
