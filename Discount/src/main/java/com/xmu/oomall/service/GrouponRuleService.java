package com.xmu.oomall.service;

import com.xmu.oomall.vo.GrouponRuleVo;
import com.xmu.oomall.domain.GrouponRulePo;

import java.util.List;


/**
 * @author Liuwenhan
 */
public interface GrouponRuleService {

    public List<GrouponRuleVo> getGrouponRuleByGoodsId(Integer id, Integer page, Integer limit);

    /**
     * @param grouponRulePo 
     * @return
     */
    public Boolean addGrouponRule(GrouponRulePo grouponRulePo);

    public GrouponRuleVo getGrouponRuleById(Integer id);

    public GrouponRuleVo adminGetGrouponRuleById(Integer id);

    public Boolean updateGrouponRule(GrouponRulePo grouponRulePo);

    public Boolean deleteGrouponRule(Integer id);

    public List<GrouponRuleVo> customerGetGrouponRule(Integer page, Integer limit);

    public List<GrouponRuleVo> adminGetGrouponRule(Integer page, Integer limit);

}
