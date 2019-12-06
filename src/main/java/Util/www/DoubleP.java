package Util.www;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface DoubleP {
    int value() default 0;
    String name()default "pp";
}
