package com.zzp.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderConsulController {
    private String invokeUrl = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/consumer/consul")
    public String paymentInfo() {
        return  restTemplate.getForObject(invokeUrl + "/payment/consul"
                ,String.class);
    }
}
