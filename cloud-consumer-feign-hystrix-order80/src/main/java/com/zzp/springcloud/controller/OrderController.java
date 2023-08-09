package com.zzp.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zzp.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/consumer/info/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String s = orderService.paymentInfo(id);
        log.info("result  " + s);
        return s;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler"
            ,commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
                    ,value="1500")})
    @GetMapping("/consumer/timeOut/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id) {
        String s = orderService.paymentTimeOut(id);
        log.info("result  " + s);
        return s;
    }

    public String paymentInfo_TimeOutHandler(Integer id)
    {
        return "线程池:  "+Thread.currentThread().getName()+"  8000系统繁忙或者运行报错，请稍后再试,id:  "+id+"\t"+"o(╥﹏╥)o";
    }

    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
