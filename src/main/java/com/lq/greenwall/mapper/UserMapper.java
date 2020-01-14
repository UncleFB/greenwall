package com.lq.greenwall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lq.greenwall.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username=#{username}")
    @Results({
            @Result(property = "devices",column = "id",
                    many = @Many(select = "com.lq.greenwall.mapper.DeviceMapper.findDevicesByUid"))
    })
    public User selectUserByUsername(String username);
}
