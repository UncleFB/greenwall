package com.lq.greenwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.lq.greenwall.entity.User;
import com.lq.greenwall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    /**
     * 获取所有用户
     * @return
     */
    @RequestMapping("getalluser")
    public List<User> getUsers(){
        return userMapper.selectList(null);
    }

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    @RequestMapping("getuser")
    public User getUserById(int id){
        return userMapper.findUserById(id);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @RequestMapping("register")
    public int addUser(User user){
        User one = userMapper.findUserByUsername(user.getUsername());
        if(one!=null){
            return 0;
        }else{
            return userMapper.insert(user);
        }
    }

    /**
     * 登陆
     * @param user
     * @return
     */
    @RequestMapping("login")
    public User login(User user){
        User one = userMapper.findUserByUsername(user.getUsername());
        if(one.getPassword().equals(user.getPassword())){
            return one;
        }else{
            return null;
        }
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping("upduser")
    public int updUser(User user){
        return userMapper.updateById(user);
    }

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    @RequestMapping("deluser")
    public int delUser(int id){
        return userMapper.deleteById(id);
    }
}
