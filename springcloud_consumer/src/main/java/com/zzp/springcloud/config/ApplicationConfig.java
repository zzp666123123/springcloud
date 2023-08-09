package com.zzp.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class ApplicationConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getTemplate() {
        return  new RestTemplate();
    }
}
