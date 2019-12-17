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

    boolean deletePresaleRule(Integer id);

    List<PresaleRule> adminGetGrouponRule();

    List<PresaleRule> customerGetGrouponRule();
}
