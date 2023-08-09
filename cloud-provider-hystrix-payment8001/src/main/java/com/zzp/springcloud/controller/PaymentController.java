package com.zzp.springcloud.controller;

import com.zzp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/info/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
       String result =  paymentService.paymentInfo(id);
       log.info("result: " + result);
       return  result;
    }

    @GetMapping("/payment/timeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentTimeOut(id);
        log.info("result: " + result);
        return  result;
    }

    @GetMapping("/payment/circuitBreaker/{id}")
    public String paymentCircuit(@PathVariable("id") Integer id) {
      String result = paymentService.paymentCircuitBreaker(id);
      log.info("result " + result);
      return result;
    }
}
