package com.brother.service;

import com.brother.entity.po.Consumer;

public interface UserService {

    public boolean confirmUsername(String username);

    public boolean confirmTelephone(String telephone);

    public void registeConsumer(Consumer consumer);

}
