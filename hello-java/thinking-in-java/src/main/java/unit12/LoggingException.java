package unit12;

import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * LoggingException class
 *
 * @author ying.zhang01
 * @date 2019/5/17
 */
public class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException() {
        StringWriter trace = new StringWriter();
    }
}
