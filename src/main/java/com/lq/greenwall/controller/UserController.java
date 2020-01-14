package com.lq.greenwall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.lq.greenwall.entity.Device;
import com.lq.greenwall.entity.User;
import com.lq.greenwall.mapper.DeviceMapper;
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
    @Autowired
    DeviceMapper deviceMapper;

    /**
     * 获取所有用户
     * @return
     */
    @RequestMapping("getalluser")
    public List<User> getUsers(){
        return userMapper.selectList(null);
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
