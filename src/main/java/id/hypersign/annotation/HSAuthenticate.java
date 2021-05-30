package id.hypersign.annotation;

import java.lang.annotation.*;

/**
 * Procedure declaration of REST API.
 * @author Dev Gurung
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface HSAuthenticate {
    String description= "";
}
