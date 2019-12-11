package com.xmu.oomall.service;

import com.xmu.oomall.dao.GrouponRuleDao;
import com.xmu.oomall.domain.GrouponRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Liuwenhan
 */
@Service
public class GrouponRuleService {
    @Autowired
    public GrouponRuleDao grouponRuleDao;

    public List<GrouponRule> getGrouponRuleByGoodsId(Integer id){
        return  grouponRuleDao.getGrouponRuleByGoodsId(id);
    }

    public GrouponRule addGrouponRule(GrouponRule grouponRule){
        return grouponRuleDao.addGrouponRule(grouponRule);
    }

    public GrouponRule getGrouponRuleById(Integer id){
        return grouponRuleDao.getGrouponRuleById(id);
    }

    public GrouponRule updateGrouponRule(GrouponRule grouponRule){
        return grouponRuleDao.updateGrouponRule(grouponRule);
    };

    public void deleteGrouponRule(Integer id){
        grouponRuleDao.deleteGrouponRule(id);
    };
}
