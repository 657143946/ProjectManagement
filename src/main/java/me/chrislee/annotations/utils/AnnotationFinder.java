package me.chrislee.annotations.utils;

import java.lang.reflect.Method;

/**
 * Created by ChrisLee on 15-4-23.
 *  注解帮助类
 */
public class AnnotationFinder {
    public static Object[] findClassAndMethodAnnotation(Method method, Class annotationClass){
        Object methodAnnotation = method.getAnnotation(annotationClass);
        Object classAnnotation = method.getDeclaringClass().getAnnotation(annotationClass);
        Object[] result = {classAnnotation, methodAnnotation};
        return result;
    }
}
