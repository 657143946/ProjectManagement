package me.chrislee.database.dao;


import me.chrislee.database.entity.LoginEntity;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * Created by ChrisLee on 15-4-25.
 * 针对Login 数据逻辑的DAO
 */
@Repository
public interface LoginDao {
    /**
     * 插入login记录
     * 返回插入条数
     */
    @Insert("insert into login(id, userName, email, password, sessionId, lastLoginIp, lastLoginTimestamp, level, isActive, activeCode, createTimestamp) " +
            "values(#{id}, #{userName}, #{email}, #{password}, #{sessionId}, #{lastLoginIp}, #{lastLoginTimestamp}, #{level}, #{isActive}, #{activeCode}, #{createTimestamp})")
    public int save(LoginEntity login);
}
