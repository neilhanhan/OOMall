package com.xmu.oomall.service;

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
}
