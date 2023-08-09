package com.zzp.springcloud.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",
        fallback = PaymentFallback.class)
public interface OrderService {
    @GetMapping("/payment/info/{id}")
    public String paymentInfo(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id);
}
