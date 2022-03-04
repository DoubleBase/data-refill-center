package com.muskmelon.data.refill.center.service.impl;

import com.muskmelon.data.refill.center.domain.Coupon;
import com.muskmelon.data.refill.center.domain.CouponActivity;
import com.muskmelon.data.refill.center.domain.RefillOrder;
import com.muskmelon.data.refill.center.domain.RefillRequest;
import com.muskmelon.data.refill.center.service.AccountAmountService;
import com.muskmelon.data.refill.center.service.CouponService;
import com.muskmelon.data.refill.center.service.CreditService;
import com.muskmelon.data.refill.center.service.LotteryDrawService;
import com.muskmelon.data.refill.center.service.RefillDataCenterService;
import com.muskmelon.data.refill.center.service.RefillOrderService;
import com.muskmelon.data.refill.center.service.ThirdPartyBossService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

/**
 * @author muskmelon
 * @since 1.0
 */
@Slf4j
@Service
@Transactional(transactionManager = "xata", rollbackFor = Exception.class)
public class RefillDataCenterServiceImpl implements RefillDataCenterService {

    @Resource
    private AccountAmountService accountAmountService;

    @Resource
    private RefillOrderService refillOrderService;

    @Resource
    private ThirdPartyBossService thirdPartyBossService;

    @Resource
    private LotteryDrawService lotteryDrawService;

    @Resource
    private CreditService creditService;
    @Resource
    private CouponService couponService;

    @Override
    public void finishRefillData(RefillRequest refillRequest) {
        try {
            // 完成支付转账
            accountAmountService.transfer(refillRequest.getUserAccountId(), refillRequest.getBusinessAccountId(),
                    refillRequest.getPayAmount());

            // 创建流量充值订单
            RefillOrder refillOrder = createRefillOrder(refillRequest);
            refillOrderService.insertOrder(refillOrder);

            // 增加用户抽奖机会
            lotteryDrawService.updateLotteryDrawCount(refillOrder.getUserAccountId());

            // 增加积分
            creditService.updateCreditPoint(refillRequest.getUserAccountId(), refillOrder.getCredit());

            // 修改流量券状态
            if (Objects.nonNull(refillRequest.getCoupon()) && Objects.nonNull(refillRequest.getCoupon().getId())) {
                couponService.markCouponUsed(refillRequest.getCoupon().getId());
            }

            // 赠送流量券
            CouponActivity couponActivity = refillRequest.getDataPackage().getCouponActivity();
            if (Objects.nonNull(couponActivity) && Objects.nonNull(couponActivity.getId())) {
                Coupon coupon = createCoupon(refillRequest, couponActivity);
                couponService.insertCoupon(coupon);
            }

            // 完成流量充值
            thirdPartyBossService.refillData(refillRequest.getPhoneNumber(), refillOrder.getRefillData());

        } catch (Exception e) {
            log.error("充值失败，手机号:{}", refillRequest.getPhoneNumber(), e);
        }
    }

    private RefillOrder createRefillOrder(RefillRequest refillRequest) {
        RefillOrder refillOrder = new RefillOrder();
        refillOrder.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
        refillOrder.setUserAccountId(refillRequest.getUserAccountId());
        refillOrder.setBusinessAccountId(refillRequest.getBusinessAccountId());
        refillOrder.setBusinessName(refillRequest.getBusinessName());
        refillOrder.setAmount(refillRequest.getPayAmount());
        refillOrder.setTitle("手机流量充值");
        refillOrder.setType("通信物流");
        refillOrder.setStatus(1);
        refillOrder.setPayType(refillOrder.getPayType());
        refillOrder.setRefillComment(String.format("给手机号码%s充值%s流量",
                refillRequest.getPhoneNumber(),
                refillRequest.getDataPackage().getData()));
        refillOrder.setRefillPhoneNumber(refillRequest.getPhoneNumber());
        refillOrder.setRefillData(refillRequest.getDataPackage().getData());
        refillOrder.setCredit(refillRequest.getPayAmount() * 2);
        return refillOrder;
    }

    private Coupon createCoupon(RefillRequest refillRequest, CouponActivity couponActivity) {
        Coupon coupon = new Coupon();
        coupon.setUserAccountId(refillRequest.getUserAccountId());
        coupon.setCouponAmount(couponActivity.getCouponAmount());
        coupon.setStartTime(couponActivity.getStartTime());
        coupon.setEndTime(couponActivity.getEndTime());
        coupon.setStatus(couponActivity.getStatus());
        return coupon;
    }
}
