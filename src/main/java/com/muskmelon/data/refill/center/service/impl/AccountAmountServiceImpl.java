package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.mapper.finance.AccountAmountMapper;
import com.muskmelon.data.refill.center.service.AccountAmountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 账号金额service
 * @author muskmelon
 * @since 1.0
 */
@Service
public class AccountAmountServiceImpl implements AccountAmountService {

    @Resource
    private AccountAmountMapper accountAmountMapper;

    @Override
    public void transfer(Long fromUserAccountId, Long toUserAccountId, Long accountAmount) {
        accountAmountMapper.updateAmount(fromUserAccountId, -accountAmount);
        accountAmountMapper.updateAmount(toUserAccountId, accountAmount);
    }
}
