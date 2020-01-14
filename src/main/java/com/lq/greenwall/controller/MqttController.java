package com.lq.greenwall.controller;

import com.lq.greenwall.config.MqttConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController {
    @Autowired
    private MqttConfig.MqttGateway mqttGateway;
    @RequestMapping("/send/{topic}/{message}")
    public String send(@PathVariable String topic, @PathVariable String message) {
        topic = "/" + topic;
        mqttGateway.sendToMqtt(topic, message);
        return "send message : " + message;
    }
}
