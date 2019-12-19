package com.xmu.oomall.vo;

import com.xmu.oomall.domain.GoodsPo;
import com.xmu.oomall.domain.GrouponRulePo;

/**
 * @author Liuwenhan
 */
public class GrouponRuleVo {
    private GrouponRulePo grouponRulePo;
    private GoodsPo goodsPo;

    public GrouponRulePo getGrouponRulePo() {
        return grouponRulePo;
    }

    public void setGrouponRulePo(GrouponRulePo grouponRulePo) {
        this.grouponRulePo = grouponRulePo;
    }

    public GoodsPo getGoodsPo() {
        return goodsPo;
    }

    public void setGoodsPo(GoodsPo goodsPo) {
        this.goodsPo = goodsPo;
    }

    @Override
    public String toString() {
        return "GrouponRuleVO{" +
                "grouponRulePo=" + grouponRulePo +
                ", goodsPo=" + goodsPo +
                '}';
    }
}