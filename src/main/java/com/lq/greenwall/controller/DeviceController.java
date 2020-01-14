package com.lq.greenwall.controller;

import com.lq.greenwall.entity.Device;
import com.lq.greenwall.entity.User;
import com.lq.greenwall.mapper.DeviceMapper;
import com.lq.greenwall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("getdevices")
    public List<Device> getDevices(){
        return deviceMapper.selectList(null);
    }
    @RequestMapping("getdevice")
    public Device getDevice(int id){
        return deviceMapper.selectById(id);
    }

    @RequestMapping("upddevice")
    public int updDevice(Device device){
        return deviceMapper.updateById(device);
    }
    @RequestMapping("deldevice")
    public int delDevice(int id){
        return deviceMapper.deleteById(id);
    }
    @RequestMapping("chart")
    public List<Device> device(String mac){
        return deviceMapper.findLast5(mac);
    }
}
