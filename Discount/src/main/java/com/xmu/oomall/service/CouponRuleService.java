package com.xmu.oomall.service;

import com.xmu.oomall.domain.CouponRulePo;

import java.util.List;

/**
 * @Author Zhang BingYuan
 * @Date 2019/12/8 12:03
 */
public interface CouponRuleService {
    /**
     * 增加一个CouponRule
     * @param couponRulePo
     * @return
     */
    public CouponRulePo addCouponRulePo(CouponRulePo couponRulePo);

    /**
     * 根据id查找CouponRule
     * @param id
     * @return
     */
    public Integer deleteCouponRulePoById(Integer id);

    /**
     * 通过id更新CouponRule
     * @param id
     * @param couponRulePo
     * @return
     */
    public CouponRulePo updateCouponRulePo(Integer id, CouponRulePo couponRulePo);

    /**
     * 通过id查找CouponRule
     * @param id
     * @return
     * @throws Exception
     */
    public CouponRulePo findCouponRulePoById(Integer id) throws Exception;


    /**
     * 管理员分页获取部分的优惠券规则
     * @param page
     * @param limit
     * @return
     */
    public List<CouponRulePo> adminGetAllCouponRulePos(Integer page, Integer limit);

    /**
     * 用户分页获取部分的优惠券规则
     * @param page
     * @param limit
     * @return
     */
    public List<CouponRulePo> userGetAllCouponRulePos(Integer page, Integer limit);
}
