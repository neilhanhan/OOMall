package com.xmu.oomall.dao;

import com.xmu.oomall.domain.GrouponRule;
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

    public List<GrouponRule> getGrouponRuleByGoodsId(Integer id){
        return  grouponRuleMapper.getGrouponRuleByGoodsId(id);
    }

    public GrouponRule addGrouponRule(GrouponRule grouponRule){
        return grouponRuleMapper.insertGrouponRule(grouponRule);
    }

    public GrouponRule getGrouponRuleById(Integer id){
        return grouponRuleMapper.getGrouponRuleById(id);
    }

    public GrouponRule updateGrouponRule(GrouponRule grouponRule){
        return grouponRuleMapper.updateGrouponRule(grouponRule);
    };

    public void deleteGrouponRule(Integer id){
        grouponRuleMapper.deleteGrouponRule(id);
    };
}
