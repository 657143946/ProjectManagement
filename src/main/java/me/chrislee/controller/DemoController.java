package me.chrislee.controller;

import me.chrislee.database.entity.LoginEntity;
import me.chrislee.database.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ChrisLee on 15-4-24.
 * just a Main.java
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private LoginService loginService;

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
        mv.setViewName("demo/main.html");
        return mv;
    }

    @RequestMapping("/json.data")
    @ResponseBody
    @Transactional
    public DemoModel json() {
        DemoModel data = new DemoModel(true, "SUCCESS");
        LoginEntity login = loginService.getLoginDao().findByEmail("657143946@qq.com");
        List<LoginEntity> logins = loginService.getLoginDao().findAll();
        loginService.testTransaction();
        data.add("logins", logins);
        data.add("login", login);
        return data;
    }

    public static void main(String[] args) {

    }
}
