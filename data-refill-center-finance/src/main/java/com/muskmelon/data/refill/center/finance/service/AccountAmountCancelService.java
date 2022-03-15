package com.muskmelon.data.refill.center.finance.service;

import com.muskmelon.data.refill.center.finance.api.AccountAmountApi;
import com.muskmelon.data.refill.center.finance.mapper.AccountAmountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@Slf4j
@Service("accountAmountCancelService")
@RequestMapping("/finance/cancel")
public class AccountAmountCancelService implements AccountAmountApi {

    @Resource
    private AccountAmountMapper accountAmountMapper;

    @Override
    public void transfer(Long fromUserAccountId, Long toUserAccountId, Long accountAmount) {
        accountAmountMapper.cancelTransferOut(fromUserAccountId, accountAmount);
        accountAmountMapper.cancelTransferIn(toUserAccountId, accountAmount);
        log.info("cancel 资金转账接口，fromUser={}, toUser={}, accountAmount={}",
                fromUserAccountId, toUserAccountId, accountAmount);
    }

}
