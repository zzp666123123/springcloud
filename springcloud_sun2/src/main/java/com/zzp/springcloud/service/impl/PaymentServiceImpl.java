package com.zzp.springcloud.service.impl;

import com.zzp.springcloud.dao.PaymentDao;
import com.zzp.springcloud.entities.Payment;
import com.zzp.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 */
@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}

