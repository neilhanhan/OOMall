package com.xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import com.xmu.oomall.domain.GrouponRulePo;
import com.xmu.oomall.mapper.GrouponRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Liuwenhan
 */
@Repository
public class GrouponRuleDao {
    @Autowired
    private GrouponRuleMapper grouponRuleMapper;

    public List<GrouponRulePo> getGrouponRuleByGoodsId(Integer id,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<GrouponRulePo> grouponRulePoList = grouponRuleMapper.getGrouponRuleByGoodsId(id);
        return grouponRulePoList;
    }

    public Boolean addGrouponRule(GrouponRulePo grouponRulePo){
        return grouponRuleMapper.insertGrouponRule(grouponRulePo);
    }

    public GrouponRulePo getGrouponRuleById(Integer id){
        return grouponRuleMapper.getGrouponRuleById(id);
    }

    public GrouponRulePo adminGetGrouponRuleById(Integer id) {
        return grouponRuleMapper.adminGetGrouponRuleById(id);
    }

    public Boolean updateGrouponRule(GrouponRulePo grouponRulePo){
        return grouponRuleMapper.updateGrouponRule(grouponRulePo);
    };

    public Boolean deleteGrouponRule(Integer id){
        return grouponRuleMapper.deleteGrouponRule(id);
    };

    public List<GrouponRulePo> customerGetGrouponRule(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<GrouponRulePo> grouponRulePoList = grouponRuleMapper.customerGetGrouponRule();
        return grouponRulePoList;
    }

    public List<GrouponRulePo> adminGetGrouponRule(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<GrouponRulePo> grouponRulePoList = grouponRuleMapper.adminGetGrouponRule();
        return  grouponRulePoList;
    }

}
