package me.chrislee.controller.login;

import me.chrislee.constant.user.UserLevel;
import me.chrislee.controller.DemoModel;
import me.chrislee.database.entity.LoginEntity;
import me.chrislee.database.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ChrisLee on 15-5-12.
 * 注册登录当账号操作的控制器
 */
@Controller
@RequestMapping("/login")
public class Login {
    @Resource
    private LoginService loginService;

    /**
     * 首页页面，根据用户是否登陆决定是否跳转首页
     */
    @RequestMapping("/index.page")
    public ModelAndView index(HttpServletRequest request) {
        LoginEntity login = (LoginEntity) request.getSession().getAttribute("login");
        if (login == null) {
            /**
             * 未登录情况下，显示登录首页
             */
            ModelAndView mv = new ModelAndView();
            mv.setViewName("login/login.html");
            return mv;
        } else {
            /**
             * 已经登录情况，根据逻辑需求跳转
             */
            ModelAndView mv = new ModelAndView();
            mv.setViewName("login/login.html");
            return mv;
        }
    }

    @RequestMapping("/login.data")
    public DemoModel login() {
        DemoModel ret = new DemoModel(true, "SUCCESS");
        return ret;
    }

    @RequestMapping("/register.data")
    @ResponseBody
    public DemoModel register(

    ) {
        /**
         * TODO 参数验证
         */
        String userName = "userName";
        String email = "email";
        String password = "password";
        String ip = "127.0.0.1";
        UserLevel level = UserLevel.COMMON;
        /**
         * service调用 TODO
         */
        LoginEntity login = loginService.register(userName, email, password, level, ip);

        DemoModel ret = new DemoModel(true, "SUCCESS");
        ret.add("login", login);
        return ret;
    }


}
