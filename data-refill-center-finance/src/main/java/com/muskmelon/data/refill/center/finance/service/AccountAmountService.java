package com.muskmelon.data.refill.center.finance.service;

import com.muskmelon.data.refill.center.finance.mapper.AccountAmountMapper;
import com.muskmelon.data.refill.center.finance.api.AccountAmountApi;
import org.bytesoft.compensable.Compensable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 账号金额service
 *
 * @author muskmelon
 * @since 1.0
 */
@Compensable(interfaceClass = AccountAmountApi.class,
        confirmableKey = "accountAmountConfirmService",
        cancellableKey = "accountAmountCancelService")
@RestController
public class AccountAmountService implements AccountAmountApi {

    @Resource
    private AccountAmountMapper accountAmountMapper;

    @Override
    public void transfer(@RequestParam Long fromUserAccountId,
                         @RequestParam Long toUserAccountId,
                         @RequestParam Long accountAmount) {
        accountAmountMapper.tryTransferOut(fromUserAccountId, accountAmount);
        accountAmountMapper.tryTransferIn(toUserAccountId, accountAmount);
    }

}
