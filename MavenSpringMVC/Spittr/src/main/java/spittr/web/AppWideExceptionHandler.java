package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(SpittleNotFoundException.class)
    public String duplicateSpittleHandler() {
        return "home";
    }
}
