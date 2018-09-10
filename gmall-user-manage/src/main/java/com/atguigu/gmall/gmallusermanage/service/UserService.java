package com.atguigu.gmall.gmallusermanage.service;

import com.atguigu.gmall.gmallusermanage.bean.UserInfo;

import java.util.List;

public interface UserService {
    public void addUser(UserInfo userInfo);

    List<UserInfo> getUserInfoListAll();

    UserInfo selectUserById(String id);

    void updateUser(UserInfo userInfo);
}
