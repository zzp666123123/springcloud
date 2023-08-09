package com.zzp.springcloud.controller;

import com.netflix.discovery.DiscoveryClient;
import com.zzp.springcloud.entities.CommonResult;
import com.zzp.springcloud.entities.Payment;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    public String url = "http://CLOUD-PAYMENT-SERVICE";

    @PostMapping("/consumer/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(url + "/payment/create"
                , payment, CommonResult.class);
    }

    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> get(@PathVariable long id) {
        return restTemplate.getForObject(url + "/payment/get/" + id,CommonResult.class);
    }

}
