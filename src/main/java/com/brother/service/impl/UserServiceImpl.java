package com.brother.service.impl;

import com.brother.entity.po.Consumer;
import com.brother.mapper.UserMapper;
import com.brother.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public boolean confirmUsername(String username) {
        logger.info("检查是否数据库是否存在相同用户名 --- {username 用户名}");
        return StringUtils.isEmpty(userMapper.confirmUsername(username)) ? true : false;
    }

    @Override
    public boolean confirmTelephone(String telephone) {
        logger.info("检查是否数据库是否存在相同手机号 --- {telephone 手机号码}");
        return StringUtils.isEmpty(userMapper.confirmTelephone(telephone)) ? true : false;
    }

    @Override
    public void registeConsumer(Consumer consumer) {
        logger.info("注册用户 --- {consumer 用户实体对象}");
        userMapper.registeConsumer(consumer);
    }
}
