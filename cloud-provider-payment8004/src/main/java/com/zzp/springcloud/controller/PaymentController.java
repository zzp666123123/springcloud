package com.zzp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Priority;
import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String server;

    @RequestMapping("/payment/zk")
    public String paymentZooker() {
        return "springcloudZooker" + server + UUID.randomUUID().toString();
    }
}
