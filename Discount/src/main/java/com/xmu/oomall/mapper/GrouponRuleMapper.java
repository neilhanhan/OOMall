package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.GrouponRule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Liuwenhan
 */
@Mapper
@Repository
public interface GrouponRuleMapper {

    /**
     * 获取团购规则列表
     * @param id
     * @return GrouponRule
     */
    List<GrouponRule> getGrouponRuleByGoodsId(Integer id);

    /**
     * 创建一个新的团购规则
     *
     * @param grouponRule
     * @return
     */
    GrouponRule insertGrouponRule(GrouponRule grouponRule);

    /**
     * 获取团购规则列表详细信息
     * @param id
     * @return GrouponRule
     */
    GrouponRule getGrouponRuleById(Integer id);

    /**
     * 修改团购规则信息
     * @param grouponRule
     * @return
     */
    GrouponRule updateGrouponRule(GrouponRule grouponRule);

    /**
     * 删除团购规则信息
     * @param id
     * @return
     */
    void deleteGrouponRule(Integer id);

}
