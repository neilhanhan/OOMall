package com.xmu.oomall.mapper;

import com.xmu.oomall.domain.GrouponRulePo;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Liuwenhan
 */
@Mapper
@Repository
public interface GrouponRuleMapper {

    /**
     * 获取团购规则列表
     *
     * @param id
     * @return List<GrouponRulePo>
     */
    List<GrouponRulePo> getGrouponRuleByGoodsId(Integer id);

    /**
     * 创建一个新的团购规则
     *
     * @param grouponRulePo
     * @return Boolean
     */
    Boolean insertGrouponRule(GrouponRulePo grouponRulePo);

    /**
     * 用户获取团购规则详细信息
     * @param id
     * @return GrouponRulePo
     */
    GrouponRulePo getGrouponRuleById(Integer id);

    /**
     * 用户获取团购规则详细信息
     * @param id
     * @return GrouponRulePo
     */
    GrouponRulePo adminGetGrouponRuleById(Integer id);

    /**
     * 修改团购规则信息
     * @param grouponRulePo
     * @return Boolean
     */
    Boolean updateGrouponRule(GrouponRulePo grouponRulePo);

    /**
     * 删除团购规则信息
     * @param id 团购规则ID
     * @param time 更改时间
     * @return Boolean
     */
    Boolean deleteGrouponRule(Integer id, LocalDateTime time);

    /**
     * 用户获取团购活动列表
     * @return List<GrouponRulePo>
     */
    List<GrouponRulePo> customerGetGrouponRule();

    /**
     * 管理员获取团购活动列表
     * @return List<GrouponRulePo>
     */
    List<GrouponRulePo> adminGetGrouponRule();


}
