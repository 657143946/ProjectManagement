package me.chrislee.database.service;

import me.chrislee.constant.user.UserLevel;
import me.chrislee.database.entity.LoginEntity;
import me.chrislee.utils.cipher.CipherUtils;
import me.chrislee.utils.id.IdUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by ChrisLee on 15-5-9.
 */
@Service
public class LoginService extends BaseService {

    /**
     * 注册逻辑
     *
     * @param userName 用户名
     * @param email    邮箱
     * @param password 原始密码（未加密）
     * @param level    用户级别
     * @param ip       IP
     * @return 登陆实体类
     */
    public LoginEntity register(String userName, String email, String password, UserLevel level, String ip) {
        LoginEntity login = new LoginEntity();

        login.setUserName(userName);
        login.setEmail(email);
        login.setPassword(CipherUtils.md5(password, 10));
        login.setSessionId(IdUtils.getId());
        login.setLastLoginIp(ip);
        login.setLastLoginTimestamp(new Timestamp(System.currentTimeMillis()));
        login.setLevel(level.getLevel());
        login.setActive(false);
        login.setActiveCode(IdUtils.getId());

        this.getLoginDao().save(login);

        return login;
    }

}
