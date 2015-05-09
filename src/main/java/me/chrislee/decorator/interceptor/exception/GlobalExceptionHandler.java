package me.chrislee.decorator.interceptor.exception;

import me.chrislee.controller.DemoModel;
import me.chrislee.utils.json.JsonConvert;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ChrisLee on 15-5-9.
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    private static final ModelAndView NONE = new ModelAndView();

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (request.getServletPath().endsWith(".data")){
            /**
             * 返回数据
             */
            DemoModel data = new DemoModel(false, "服务器出错啦！");
            String json = JsonConvert.entityToJson(data);
            response.setCharacterEncoding("UTF-8");//设置Response的编码方式为UTF-8
            response.setHeader("Content-type","application/json;charset=UTF-8");
            try {
                response.getWriter().write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (request.getServletPath().endsWith(".page")){
            /**
             * 重定向到错误页面
             */
            try {
                response.sendRedirect(request.getContextPath()+"/html/about.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return NONE;
    }
}
