package com.muskmelon.data.refill.center.finance.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author muskmelon
 * @since 1.0
 */
@RequestMapping("/finance")
public interface AccountAmountApi {

    @PostMapping("/transfer")
    void transfer(@RequestParam Long fromUserAccountId,
                  @RequestParam Long toUserAccountId,
                  @RequestParam Long accountAmount);
}
