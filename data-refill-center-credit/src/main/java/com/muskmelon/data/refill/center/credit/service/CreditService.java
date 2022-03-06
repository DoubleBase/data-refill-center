package com.muskmelon.data.refill.center.credit.service;

import com.muskmelon.data.refill.center.credit.mapper.CreditMapper;
import com.muskmelon.data.refill.center.credit.api.CreditApi;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author muskmelon
 * @since 1.0
 */
@RestController
public class CreditService implements CreditApi {

    @Resource
    private CreditMapper creditMapper;

    @Override
    public void updateCreditPoint(@RequestParam Long userAccountId,
                                  @RequestParam Long point) {
        creditMapper.updateCreditPoint(userAccountId, point);
    }
}
