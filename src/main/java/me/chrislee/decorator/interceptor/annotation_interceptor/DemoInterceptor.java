package me.chrislee.decorator.interceptor.annotation_interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by ChrisLee on 15-4-30.
 */
public class DemoInterceptor implements Interceptor{
    @Override
    public boolean intercept(HttpServletRequest request, HttpServletResponse response, Method method) {
        System.out.println("调用拦截器");
        return true;
    }
}
