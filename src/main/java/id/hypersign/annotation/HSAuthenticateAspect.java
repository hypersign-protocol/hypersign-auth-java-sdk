package id.hypersign.annotation;

import id.hypersign.api.HSMiddlewareService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Aspect
public class HSAuthenticateAspect {

    @Pointcut("execution(* id.hypersign.annotation(..)) ")
    public void targetMethods() {
    }

    @AfterReturning(
            pointcut = "@annotation(id.hypersign.annotation.HSAuthenticate)",
            returning = "retVal")
    public void postHandle(Object retVal) {
        System.out.println("Aspect :: postHandle, retVal={}");
    }

    @Around("@annotation(id.hypersign.annotation.HSAuthenticate) && args(.., @RequestBody body)")
    public Object handle(ProceedingJoinPoint pjp ,Object body) throws Throwable {
        HSMiddlewareService hsMiddlewareService = new HSMiddlewareService();
        System.out.println("Aspect :: around - start");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        System.out.println("body" + body.toString());
        if(hsMiddlewareService.authenticate("sdsad" ,body.toString()))
           response.setStatus(200);

            return pjp.proceed();


    }

}