package work.fourier.chapter1.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("log()")
    public void before() {
        logger.info("11111");
    }

    @After("log()")
    public void after(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info("Method = {}", request.getMethod());
        logger.info("IP = {}", request.getRemoteAddr());
        logger.info("URL = {}", request.getRequestURL());
        logger.info("ClassMethod = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("Args = {}", joinPoint.getArgs());
    }

    @Pointcut("execution(public * work.fourier.chapter1.Controller.GirlController.add(..))")
    public void log() {
    }
}
