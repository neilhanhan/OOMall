package com.xmu.oomall.mapper;


import com.xmu.oomall.domain.Coupon;
import com.xmu.oomall.domain.CouponPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**Mapper接口，用于和数据库交互
 * @Author Zhang BingYuan
 * @Date 2019/12/8 15:25
 */
@Mapper
@Repository
public interface CouponMapper {
    /**
     *增加优惠券
     * @param couponPo
     * @return
     */
    public Integer addCouponPo(CouponPo couponPo);
    /**
     * 用id删除优惠券
     * @param id
     * @return
     */
    public boolean deleteCouponById(Integer id);
    /**
     * 用id更新优惠券
     * @param coupon
     * @return
     */
    public boolean updateCoupon(Coupon coupon);
    /**
     * 用id找到优惠券
     * @param id
     * @return
     */
    public Coupon findCouponById(Integer id);

    /**
     * 获取所有特定类型的优惠券
     */
    public List<CouponPo> getAllStatusCouponPos(Integer showType);

    /**
     * 查找couponRuleId在给出的list(已经转为String)中的couponPo
     * @param couponRuleIdString
     * @return
     */
    public List<CouponPo> getCouponPoByCouponRuleId(String couponRuleIdString);
}
