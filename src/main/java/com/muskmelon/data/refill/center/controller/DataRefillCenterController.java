package com.muskmelon.data.refill.center.controller;

import com.muskmelon.data.refill.center.domain.Coupon;
import com.muskmelon.data.refill.center.domain.CouponActivity;
import com.muskmelon.data.refill.center.domain.DataPackage;
import com.muskmelon.data.refill.center.domain.PromotionActivity;
import com.muskmelon.data.refill.center.domain.RefillOrder;
import com.muskmelon.data.refill.center.domain.RefillRequest;
import com.muskmelon.data.refill.center.domain.RefillResponse;
import com.muskmelon.data.refill.center.service.CouponActivityService;
import com.muskmelon.data.refill.center.service.CouponService;
import com.muskmelon.data.refill.center.service.DataPackageService;
import com.muskmelon.data.refill.center.service.MessageService;
import com.muskmelon.data.refill.center.service.PromotionActivityService;
import com.muskmelon.data.refill.center.service.RefillDataCenterService;
import com.muskmelon.data.refill.center.service.RefillOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author muskmelon
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/data_refill_center")
public class DataRefillCenterController {

    @Resource
    private DataPackageService dataPackageService;

    @Resource
    private PromotionActivityService promotionActivityService;

    @Resource
    private CouponActivityService couponActivityService;

    @Resource
    private RefillOrderService refillOrderService;

    @Resource
    private CouponService couponService;

    @Resource
    private RefillDataCenterService refillDataCenterService;

    @Resource
    private MessageService messageService;

    @RequestMapping("/listDataPackage")
    public List<DataPackage> listDataPackage() {

        List<DataPackage> dataPackages = dataPackageService.selectList();

        if (CollectionUtils.isEmpty(dataPackages)) {
            return null;
        }

        for (DataPackage dataPackage : dataPackages) {

            PromotionActivity promotionActivity = promotionActivityService.queryByDataPackageId(dataPackage.getId());
            dataPackage.setPromotionActivity(promotionActivity);

            CouponActivity couponActivity = couponActivityService.queryByDataPackageId(dataPackage.getId());
            dataPackage.setCouponActivity(couponActivity);
        }
        return dataPackages;
    }

    @GetMapping("/getCouponByUserAccountId/{userAccountId}")
    public Coupon queryCouponByUserAccountId(@PathVariable("userAccountId") Long userAccountId) {
        try {
            return couponService.queryByUserAccountId(userAccountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/payForDataRefill")
    public RefillResponse payForDataRefill(@RequestBody RefillRequest refillRequest) {

        RefillResponse response = new RefillResponse(0, "充值成功");

        try {
            refillDataCenterService.finishRefillData(refillRequest);

            // 向用户发送短信
            messageService.sendMessage(refillRequest.getPhoneNumber(), "您的流量充值成功");

            return response;
        } catch (Exception e) {
            log.error("充值失败，手机号:{}", refillRequest.getPhoneNumber(), e);
        }

        return new RefillResponse(-1, "充值失败");
    }

    @GetMapping("/queryAllRefillOrder/{userAccountId}")
    public List<RefillOrder> queryAllRefillOrder(@PathVariable("userAccountId") Long userAccountId) {
        return refillOrderService.queryAllOrder(userAccountId);
    }

    @GetMapping("/queryById/{id}")
    public RefillOrder queryById(@PathVariable("id") Long id) {
        return refillOrderService.queryById(id);
    }




}
