package com.brother.mapper;

import com.brother.entity.po.Consumer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper{

    @Select(value = "SELECT user_name FROM ecs_users where user_name = #{username}")
    public String confirmUsername(String username);

    @Select(value = "SELECT mobile_phone FROM ecs_users where mobile_phone = #{telephone}")
    public String confirmTelephone(String telephone);

    @Insert(value = "INSERT INTO ecs_users(user_name,password,mobile_phone) values (#{user_name},#{password},#{mobile_phone})")
    public void registeConsumer(Consumer consumer);
}
