package me.chrislee.decorator.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by ChrisLee on 15-4-30.
 *
 */
public interface Interceptor {
    public boolean intercept(HttpServletRequest request, HttpServletResponse response, Method method);
}
