package com.xmu.oomall.vo;

import com.xmu.oomall.domain.GoodsPo;
import com.xmu.oomall.domain.PresaleRule;

/**
 * @author Liuwenhan
 */
public class PresaleRuleVo {
    private PresaleRule presaleRule;
    private GoodsPo goodsPo;

    public PresaleRule getPresaleRule() {
        return presaleRule;
    }

    public void setPresaleRule(PresaleRule presaleRule) {
        this.presaleRule = presaleRule;
    }

    public GoodsPo getGoodsPo() {
        return goodsPo;
    }

    public void setGoodsPo(GoodsPo goodsPo) {
        this.goodsPo = goodsPo;
    }

    @Override
    public String toString() {
        return "PresaleRuleVo{" +
                "presaleRule=" + presaleRule +
                ", goodsPo=" + goodsPo +
                '}';
    }
}