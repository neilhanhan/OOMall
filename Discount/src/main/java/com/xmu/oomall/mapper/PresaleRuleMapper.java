package com.xmu.oomall.mapper;


import com.xmu.oomall.domain.PresaleRule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Liuwenhan
 */
@Mapper
@Repository
public interface PresaleRuleMapper {

    /**
     * 删除预售规则
     * @param id 预售规则ID
     * @return Boolean
     */
    boolean deletePresaleRule(Integer id);


    /**
     * 管理员获取预售规则列表（全部）
     * @return List<PresaleRule>
     */
    List<PresaleRule> adminGetPresaleRule();

    /**
     * 普通用户获取预售规则列表（已上架）
     * @return List<PresaleRule>
     */
    List<PresaleRule> customerGetPresaleRule();

    /**
     * 通过ID获取预售规则
     * @param id 预售规则ID
     * @return PresaleRule
     */
    PresaleRule getPresaleRuleById(Integer id);
}
