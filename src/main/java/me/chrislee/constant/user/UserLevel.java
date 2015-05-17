package me.chrislee.constant.user;

/**
 * Created by ChrisLee on 15-5-16.
 * 用户级别，用来控制用户权限使用的
 */
public enum UserLevel {
    ADMIN(0),
    COMMON(1);


    private int level;
    UserLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
}
