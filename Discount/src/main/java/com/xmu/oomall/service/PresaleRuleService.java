package com.xmu.oomall.service;

import com.github.pagehelper.Page;
import com.xmu.oomall.controller.PresaleRuleVo;
import com.xmu.oomall.dao.PresaleRuleDao;
import com.xmu.oomall.domain.PresaleRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Liuwenhan
 */
@Service
public class PresaleRuleService {
    @Autowired
    PresaleRuleDao presaleRuleDao;

    public boolean deletePresaleRule(Integer id) {
        return presaleRuleDao.deletePresaleRule(id);
    }

    public List<PresaleRuleVo> adminGetPresaleRule(Integer page,Integer limit){
        List<PresaleRule> presaleRuleList = presaleRuleDao.adminGetPresaleRule(page,limit);
        Page<PresaleRuleVo> presaleRuleVoList = new Page<PresaleRuleVo>();

        for (PresaleRule presaleRule : presaleRuleList) {
//            Integer goodsId = presaleRule.getGoodsId();
//            GoodsPo goods = goodsService.getGoodsById(goodsId);
//            if (goods == null)
//                continue;
            PresaleRuleVo presaleRuleVo = new PresaleRuleVo();
            presaleRuleVo.setPresaleRule(presaleRule);
//            presaleRuleVo.setGoodsPo(goods);
            presaleRuleVoList.add(presaleRuleVo);
        }
        return presaleRuleVoList;
    }

    public List<PresaleRule> customerGetPresaleRule(Integer page, Integer limit) {
        List<PresaleRule> presaleRuleList = presaleRuleDao.customerGetPresaleRule(page,limit);
        Page<PresaleRuleVo> presaleRuleVoPage = new Page<PresaleRuleVo>();

        for(PresaleRule presaleRule : presaleRuleList){
//            Integer goodsId = presaleRule.getGoodsId();
//            GoodsPo goods = goodsService.getGoodsById(goodsId);
//            if (goods == null)
//                continue;
            PresaleRuleVo presaleRuleVo = new PresaleRuleVo();
            presaleRuleVo.setPresaleRule(presaleRule);
//            presaleRuleVo.setGoodsPo(goods);
            presaleRuleVoList.add(presaleRuleVo);
        }
        return presaleRuleVoPage;
    }
}
