package com.zzp.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class Order80Controller {
    private String invokeUrl = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String zookeeperInfo() {
        String string =  restTemplate.getForObject(invokeUrl + "/payment/zk", String.class);
        return string;
    }


}
