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
public class HSAuthorizeAspect {

    @Pointcut("execution(* id.hypersign.annotation(..)) ")
    public void targetMethods() {
    }

    @AfterReturning(
            pointcut = "@annotation(id.hypersign.annotation.HSAuthorize)",
            returning = "retVal")
    public void postHandle(Object retVal) {
        System.out.println("Aspect :: postHandle, retVal={}");
    }

    @Around("@annotation(id.hypersign.annotation.HSAuthorize)")
    public Object handle(ProceedingJoinPoint pjp) throws Throwable {
        HSMiddlewareService hsMiddlewareService = new HSMiddlewareService();
        System.out.println("Aspect :: around - start");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        if (request.getHeader("Authorization") != null) {
            String authtoken = request.getHeader("Authorization").replaceAll("Bearer ", "");
            if (!hsMiddlewareService.authorize(authtoken))
                response.sendError(401, "Unauthorized call");

        }

        return pjp.proceed();

    }

}