package com.atguigu.gmall.gmallusermanage.controller;

import com.atguigu.gmall.gmallusermanage.bean.UserInfo;
import com.atguigu.gmall.gmallusermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user")
    public ResponseEntity<Void> addUser(UserInfo userInfo){
        userService.addUser(userInfo);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/userList")
    public ResponseEntity<List<UserInfo>> userList(){
        List<UserInfo> userInfoListAll = userService.getUserInfoListAll();
        return  ResponseEntity.ok(userInfoListAll);
    }
    @GetMapping("/user")
    public UserInfo selectUserById(String id){
        UserInfo userInfo = userService.selectUserById(id);
        return userInfo;
    }
    @GetMapping("/userbyid")
    public ResponseEntity<UserInfo> selectUserById2(String id){
        UserInfo userInfo = userService.selectUserById(id);
        return  ResponseEntity.ok(userInfo);
    }
    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(UserInfo userInfo){
        userService.updateUser(userInfo);
        return ResponseEntity.ok().build();
    }
}
