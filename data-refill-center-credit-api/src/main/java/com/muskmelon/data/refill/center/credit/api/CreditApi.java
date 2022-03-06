package com.muskmelon.data.refill.center.credit.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muskmelon
 * @since 1.0
 */
@RequestMapping("/credit")
public interface CreditApi {

    @GetMapping("/updateCreditPoint/")
    void updateCreditPoint(@RequestParam Long userAccountId,
                           @RequestParam Long point);
}
