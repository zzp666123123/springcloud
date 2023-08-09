package com.zzp.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallback implements OrderService{
    @Override
    public String paymentInfo(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
