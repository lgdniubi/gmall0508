package com.atguigu.gmall.gmallusermanage.service.impl;

import com.atguigu.gmall.gmallusermanage.bean.UserInfo;
import com.atguigu.gmall.gmallusermanage.mapper.UserInfoMapper;
import com.atguigu.gmall.gmallusermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public List<UserInfo> getUserInfoListAll() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        return userInfos;
    }

    @Override
    public UserInfo selectUserById(String id) {
        //UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName", "%y%");
        UserInfo userInfo = userInfoMapper.selectOneByExample(example);
        return userInfo;
    }

    @Override
    public void updateUser(UserInfo userInfo) {

        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
