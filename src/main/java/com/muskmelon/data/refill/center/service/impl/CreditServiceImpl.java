package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.mapper.credit.CreditMapper;
import com.muskmelon.data.refill.center.service.CreditService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@Service
public class CreditServiceImpl implements CreditService {

    @Resource
    private CreditMapper creditMapper;

    @Override
    public void updateCreditPoint(Long userAccountId, Long point) {
        creditMapper.updateCreditPoint(userAccountId, point);
    }
}
