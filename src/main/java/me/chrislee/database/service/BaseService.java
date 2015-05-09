package me.chrislee.database.service;

import me.chrislee.database.dao.LoginDao;

import javax.annotation.Resource;

/**
 * Created by ChrisLee on 15-5-9.
 * 基本的Service，里面注入所有的dao
 */
public class BaseService {
    @Resource
    private LoginDao loginDao;

    public LoginDao getLoginDao() {
        return loginDao;
    }
}
