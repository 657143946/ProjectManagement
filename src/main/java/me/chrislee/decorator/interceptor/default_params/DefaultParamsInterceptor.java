package me.chrislee.decorator.interceptor.default_params;

import me.chrislee.annotations.Pre;
import me.chrislee.annotations.utils.AnnotationFinder;
import me.chrislee.database.entity.LoginEntity;
import me.chrislee.decorator.interceptor.annotation_interceptor.Interceptor;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by ChrisLee on 15-4-28.
 * 拦截器
 */
public class DefaultParamsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null){
            LoginEntity login = (LoginEntity)request.getSession().getAttribute("login");
            if (login != null){
                modelAndView.addObject("userName", login.getUserName());
                modelAndView.addObject("email", login.getEmail());
            }
            modelAndView.addObject("root", request.getContextPath());
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
