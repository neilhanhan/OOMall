package com.xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import com.xmu.oomall.domain.Coupon;
import com.xmu.oomall.domain.CouponPo;
import com.xmu.oomall.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 15:19
 */
@Repository
public class CouponDao {
    @Autowired
    CouponMapper couponMapper;

    /**
     * 用id找到优惠券
     *
     * @param id
     * @return
     */
    public Coupon findCouponById(Integer id) {
        Coupon coupon = couponMapper.findCouponById(id);
        return coupon;
    }

    /**
     * 增加优惠券
     *
     * @param couponPo
     * @return
     */
    public CouponPo addCouponPo(CouponPo couponPo) {
        LocalDateTime localDateTime = LocalDateTime.now();
        couponPo.setGmtCreate(localDateTime);
        couponPo.setGmtModified(localDateTime);
        Integer integer = couponMapper.addCouponPo(couponPo);
        if (integer>0) {
            return couponPo;
        }
        return null;
    }

    /**
     * 用id更新优惠券
     *
     * @param id
     * @param coupon
     * @return
     */
    public boolean updateCouponById(Integer id, Coupon coupon) {
        coupon.setId(id);
        boolean bool = couponMapper.updateCoupon(coupon);
        return bool;
    }

    /**
     * 用id删除优惠券
     *
     * @param id
     * @return
     */
    public boolean deleteCouponById(Integer id) {
        boolean bool = couponMapper.deleteCouponById(id);
        return bool;
    }

    /**
     * 获取所有优惠券
     *
     * @return
     */
    public List<CouponPo> getAllStatusCouponPos(Integer page, Integer limit, Integer showType) {
        PageHelper.startPage(page, limit);
        List<CouponPo> CouponPos = couponMapper.getAllStatusCouponPos(showType);
        return CouponPos;
    }

    public List<CouponPo> getCouponPoByCouponRuleId(String couponRuleIdString) {
        List<CouponPo> couponPoByCouponRuleId = couponMapper.getCouponPoByCouponRuleId(couponRuleIdString);
        return couponPoByCouponRuleId;
    }

}
