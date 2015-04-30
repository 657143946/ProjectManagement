package me.chrislee.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ChrisLee on 15-4-30.
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pre {
    Class<? extends me.chrislee.decorator.interceptor.Interceptor>[] on() default {};
    Class<? extends me.chrislee.decorator.interceptor.Interceptor>[] off() default {};
}
