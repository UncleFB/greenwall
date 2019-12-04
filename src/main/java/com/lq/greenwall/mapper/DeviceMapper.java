package com.lq.greenwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lq.greenwall.entity.Device;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DeviceMapper extends BaseMapper<Device> {
    @Select("select * from device where uid=#{uid}")
    public List<Device> findDevicesByUid(int uid);
    @Select("select * from (select * from device where mac=#{mac} order by time desc limit 5) t order by time")
    public List<Device> findLast5(String mac);
}