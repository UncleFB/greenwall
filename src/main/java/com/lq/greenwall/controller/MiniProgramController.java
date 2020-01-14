package com.lq.greenwall.controller;

import com.lq.greenwall.entity.Device;
import com.lq.greenwall.entity.User;
import com.lq.greenwall.mapper.DeviceMapper;
import com.lq.greenwall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiniProgramController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    DeviceMapper deviceMapper;
    /**
     * 通过微信昵称获取用户信息
     * 无信息则加入数据库
     * @param username
     * @return
     */
    @RequestMapping("getUserByUsername")
    public User getUserByUsername(String username){
        User user = userMapper.selectUserByUsername(username);
        if(user==null){
            user = new User();
            user.setUsername(username);
            userMapper.insert(user);
        }
        return user;
    }

    /**
     * 添加设备
     * @param device
     * @return
     */
    @RequestMapping("addDevice")
    public int addDevice(Device device){
        if(device.getMac()!=null){
            return deviceMapper.insert(device);
        }else{
            return 0;
        }
    }

    /**
     * 删除设备
     * @param id
     * @return
     */
    @RequestMapping("delDevice")
    public int delDevice(int id){
        return deviceMapper.deleteById(id);
    }
}
