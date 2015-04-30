package me.chrislee.database.dao;


import me.chrislee.database.entity.LoginEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ChrisLee on 15-4-25.
 *
 */
public interface LoginDao {
    /**
     * 通过 id 查询
     * 返回一条记录
     */
    @Select("select * from login where id=#{id}")
    public LoginEntity findById(int id);

    /**
     * 通过 email 查询
     * 返回一条记录
     */
    @Select("select * from login where email=#{email}")
    public LoginEntity findByEmail(String email);

    /**
     * 插入login记录
     * 返回插入条数
     */
    @Insert("insert into login(id, email, password) values(#{id}, #{email}, #{password})")
    public int add(LoginEntity login);

    @Delete("delete login where id=#{id}")
    public int deleteById(int id);
}
