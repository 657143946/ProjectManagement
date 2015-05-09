package me.chrislee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ChrisLee on 15-4-24.
 * just a Main.java
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/page.page")
    public ModelAndView page(@RequestParam(defaultValue = "unknown") String name) {
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

    @RequestMapping("/json.data")
    @ResponseBody
    public DemoModel json() {
        DemoModel data = new DemoModel(true, "SUCCESS", null);
        return data;
    }

    public static void main(String[] args) {

    }
}
