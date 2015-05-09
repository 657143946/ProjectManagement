package me.chrislee.database.service;

import me.chrislee.database.entity.LoginEntity;
import org.springframework.stereotype.Service;

/**
 * Created by ChrisLee on 15-5-9.
 *
 */
@Service
public class LoginService extends BaseService{
    public void testTransaction(){
        for (int id=1; id<10; id++){
            LoginEntity login = new LoginEntity();
            login.setId(id);
            login.setEmail("email_"+id);
            login.setPassword("password_"+id);
            getLoginDao().save(login);
        }
    }

}
