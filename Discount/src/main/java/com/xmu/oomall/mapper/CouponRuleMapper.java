package com.xmu.oomall.mapper;

import com.xmu.oomall.discountDo.CouponRuleDo;
import com.xmu.oomall.domain.CouponRulePo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**Mapper接口，用于和数据库交互
 * @Author Zhang BingYuan
 * @Date 2019/12/8 15:25
 */
@Mapper
@Repository
public interface CouponRuleMapper {
    /**
     * 增加一个CouponRule
     * @param couponRulePo
     * @return
     */
    public Boolean addCouponRulePo(CouponRulePo couponRulePo);
    /**
     * 根据id删除CouponRule
     * @param id
     * @return
     */
    public Integer deleteCouponRulePoById(Integer id);

    /**
     * 更新CouponRule
     * @param couponRulePo
     * @return
     */
    public Integer updateCouponRulePo(CouponRulePo couponRulePo);
    /**
     * 通过id查找CouponRule
     * @param id
     * @return
     */
    public CouponRulePo findCouponRulePoById(Integer id);

    /**
     *  查看部分规则列表
     * @return
     */
    public List<CouponRulePo> adminGetAllCouponRulePos();

    /**
     * 获得CouponRule的id和goodsListn
     * @return
     */
    public List<CouponRuleDo> getAllCouponRuleVos();

    /**
     * 通过多个id获取多个couponRule
     * @param couponRuleIdString
     * @return
     */
    public List<CouponRulePo> getCouponRulePosByIds(String couponRuleIdString);

    /**
     * 用户分页查找优惠券规则
     * @return
     */
    public List<CouponRulePo> userGetAllCouponRulePos();
}
