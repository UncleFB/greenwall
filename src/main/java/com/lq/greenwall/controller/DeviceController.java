package com.lq.greenwall.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.lq.greenwall.entity.Device;
import com.lq.greenwall.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    DeviceMapper deviceMapper;

    @RequestMapping("getdevices")
    public List<Device> getDevices(){
        return deviceMapper.selectList(null);
    }
    @RequestMapping("getdevice")
    public Device getDevice(int id){
        return deviceMapper.selectById(id);
    }
    @RequestMapping("adddevice")
    public int addDevice(Device device){
        return deviceMapper.insert(device);
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
