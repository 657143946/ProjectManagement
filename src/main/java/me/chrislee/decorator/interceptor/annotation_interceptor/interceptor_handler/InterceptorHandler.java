package me.chrislee.decorator.interceptor.annotation_interceptor.interceptor_handler;

import me.chrislee.annotations.Pre;
import me.chrislee.annotations.utils.AnnotationFinder;
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
public class InterceptorHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * step1. 获取Method;
         * step2. 获取指定注解;
         * step3. 获取拦截器;
         * strp4. 实例化拦截器，调用拦截;
         *      if false: return false;
         * return true
         */
        Method method = (Method) PropertyUtils.getProperty(handler, "method");
        Object[] annotations = AnnotationFinder.findClassAndMethodAnnotation(method, Pre.class);
        List<Interceptor> interceptors = findInterceptors((Pre) annotations[0], (Pre) annotations[1]);
        for (Interceptor interceptor : interceptors) {
            if (!interceptor.intercept(request, response, method)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    /**
     * 通过注解找到需要执行拦截器
     */
    public static List<Interceptor> findInterceptors(Pre... annotations) {
        List<Class<? extends Interceptor>> result = new LinkedList<>();
        List<Interceptor> ret = new LinkedList<>();
        if (annotations != null) {
            for (Pre annotation : annotations) {
                if (annotation != null) {
                    result.addAll(Arrays.asList(annotation.on()));
                    result.removeAll(Arrays.asList(annotation.off()));
                }
            }
        }
        for (Class<? extends Interceptor> clazz : result) {
            try {
                ret.add(clazz.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

}
