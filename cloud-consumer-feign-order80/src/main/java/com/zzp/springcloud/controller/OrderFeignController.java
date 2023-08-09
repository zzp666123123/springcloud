package com.zzp.springcloud.controller;

import com.zzp.springcloud.entities.CommonResult;
import com.zzp.springcloud.entities.Payment;
import com.zzp.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/consumer/timeOut/{id}")
    public String paymentFeignTimeOut(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentTimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(Integer id)
    {
        return "线程池:  "+Thread.currentThread().getName()+"  8001系统繁忙或者运行报错，请稍后再试,id:  "+id+"\t"+"o(╥﹏╥)o";
    }
}
