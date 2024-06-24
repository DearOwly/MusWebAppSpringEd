package so.sonya.muswebapp2.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public final class LoggingAspect {
    private static final String DEFAULT_PATTERN = "Method '{}' returned '{}'";

    private static final String EXCEPTION_PATTERN = "Method '{}' failed with exception '{}'. Message: '{}'";

    @Pointcut(value = "within(so.sonya.muswebapp2..*)")
    public void everythingPointcut() {}

    @Around(value = "everythingPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        try {
            Object result = joinPoint.proceed(args);
            log.info(DEFAULT_PATTERN, joinPoint.getSignature(), result);
            return result;
        } catch (Throwable e) {
            log.error(EXCEPTION_PATTERN, joinPoint.getSignature(), e.getClass(), e.getMessage());
            throw e;
        }
    }
}
