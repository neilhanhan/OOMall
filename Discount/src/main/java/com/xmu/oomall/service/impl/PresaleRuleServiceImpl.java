package com.xmu.oomall.service.impl;

import com.github.pagehelper.Page;
import com.xmu.oomall.dao.PresaleRuleDao;
import com.xmu.oomall.domain.PresaleRule;
import com.xmu.oomall.service.PresaleRuleService;
import com.xmu.oomall.vo.PresaleRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresaleRuleServiceImpl implements PresaleRuleService {
    @Autowired
    PresaleRuleDao presaleRuleDao;

    @Override
    public List<PresaleRuleVo> adminGetPresaleRule(Integer page, Integer limit) {
        List<PresaleRule> presaleRuleList = presaleRuleDao.adminGetPresaleRule(page, limit);
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

    @Override
    public List<PresaleRuleVo> customerGetPresaleRule(Integer page, Integer limit) {
        List<PresaleRule> presaleRuleList = presaleRuleDao.customerGetPresaleRule(page, limit);
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

    @Override
    public boolean deletePresaleRule(Integer id) {
        return presaleRuleDao.deletePresaleRule(id);
    }

    @Override
    public PresaleRuleVo getPresaleRuleById(Integer id) {
        PresaleRule presaleRule = presaleRuleDao.getPresaleRuleById(id);
        PresaleRuleVo presaleRuleVo = new PresaleRuleVo();
//        Integer GoodsId = presaleRulePo.getGoodsId();
//        GoodsPo goods = goodsService.getGoodsById(goodsId);
//        presaleRuleVo.setGoodsPo(goods);
        presaleRuleVo.setPresaleRule(presaleRule);
        return presaleRuleVo;
    }
}
