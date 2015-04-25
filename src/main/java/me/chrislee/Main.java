package me.chrislee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ChrisLee on 15-4-24.
 * just a Main.java
 */
@Controller
@RequestMapping("/main")
public class Main {

    @RequestMapping("/index")
    public ModelAndView getHtml(@RequestParam String name){
        ModelAndView mv = new ModelAndView();
        /**
         * 配置同步渲染使用的参数
         */
        mv.addObject("name", name);
        /**
         * 设置页面
         */
        mv.setViewName("/main.html");
        return mv;

    }

    public static void main(String[] args){
        System.out.println("Project Management !");
    }
}
