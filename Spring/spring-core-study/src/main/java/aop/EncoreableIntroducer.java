package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EncoreableIntroducer {
    @DeclareParents(value = "aop.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
