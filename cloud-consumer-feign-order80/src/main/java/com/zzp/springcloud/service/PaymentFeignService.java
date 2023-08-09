package com.zzp.springcloud.service;

import com.zzp.springcloud.entities.CommonResult;
import com.zzp.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @GetMapping("/payment/timeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id);
}
