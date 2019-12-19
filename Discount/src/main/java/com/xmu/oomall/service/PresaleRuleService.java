package com.xmu.oomall.service;

import com.xmu.oomall.domain.PresaleRule;
import com.xmu.oomall.vo.PresaleRuleVo;

import java.util.List;

/**
 * @author Liuwenhan
 */
public interface PresaleRuleService {

    public List<PresaleRuleVo> adminGetPresaleRule(Integer page, Integer limit);

    public List<PresaleRuleVo> customerGetPresaleRule(Integer page, Integer limit);

    public boolean deletePresaleRule(Integer id);

    public PresaleRuleVo getPresaleRuleById(Integer id);

    /**
     * 数据库中增加一个PresaleRule
     *
     * @param presaleRule
     * @return
     */
    public PresaleRule addPresaleRule(PresaleRule presaleRule);

    /**
     * 通过goodsId获取presaleRules
     *
     * @param goodsId
     * @param page
     * @param limit
     * @return
     */
    public List<PresaleRuleVo> findPresaleRuleVosByGoodsId(Integer goodsId, Integer page, Integer limit);

    /**
     * 修改预售信息
     *
     * @param id
     * @param presaleRule
     * @return
     */
    public PresaleRule updatePresaleRuleById(Integer id, PresaleRule presaleRule);

    /**
     * 通过id获得PresaleRuleVo
     * @param id
     * @return
     */
    public PresaleRuleVo findPresaleRuleVoById(Integer id);
}
