package me.chrislee.controller.error;

import me.chrislee.database.entity.LoginEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ChrisLee on 15-5-12.
 * 错误页面
 */
@Controller
@RequestMapping("/error")
public class Error {
    @RequestMapping("/404.page")
    public ModelAndView error404() {
        /**
         * 未登录情况下，显示登录首页
         */
        ModelAndView mv = new ModelAndView();
        mv.setViewName("404.html");
        return mv;
    }
}
