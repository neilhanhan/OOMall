package com.xmu.oomall.dao;

import com.github.pagehelper.PageHelper;
import com.xmu.oomall.domain.PresaleRule;
import com.xmu.oomall.mapper.PresaleRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Liuwenhan
 */
@Repository
public class PresaleRuleDao {

    @Autowired
    PresaleRuleMapper presaleRuleMapper;

    public boolean deletePresaleRule(Integer id) {
        return presaleRuleMapper.deletePresaleRule(id);
    }

    public List<PresaleRule> adminGetPresaleRule(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<PresaleRule> presaleRuleList = presaleRuleMapper.adminGetPresaleRule();
        return  presaleRuleList;
    }

    public List<PresaleRule> customerGetPresaleRule(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<PresaleRule> presaleRuleList = presaleRuleMapper.customerGetPresaleRule();
        return  presaleRuleList;
    }

    public PresaleRule getPresaleRuleById(Integer id) {
        return presaleRuleMapper.getPresaleRuleById(id);
    }
}
