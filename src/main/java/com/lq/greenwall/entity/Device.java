package com.lq.greenwall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Time;
import java.sql.Timestamp;

@Data
public class Device {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String ip;
    private Integer uid;
    private Integer port;
    private boolean switch1;
    private boolean switch2;
    private boolean switch3;
    private String num1;
    private String num2;
    private String num3;
    private Timestamp time;
}
