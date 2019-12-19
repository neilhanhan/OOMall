package com.xmu.oomall.service.impl;

import com.github.pagehelper.Page;
import com.xmu.oomall.dao.PresaleRuleDao;
import com.xmu.oomall.domain.GoodsPo;
import com.xmu.oomall.domain.PresaleRule;
import com.xmu.oomall.service.PresaleRuleService;
import com.xmu.oomall.vo.PresaleRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    /**
     * 数据库中增加一个PresaleRule
     *
     * @param presaleRule 预售规则
     * @return PresaleRule 预售规则
     */
    @Override
    public PresaleRule addPresaleRule(PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleRuleDao.addPresaleRule(presaleRule);
        return presaleRule1;
    }

    /**
     * 通过goodsId获取presaleRules
     *
     * @param goodsId 商品ID
     * @param page 页数
     * @param limit 分页大小
     * @return List<PresaleRuleVo>
     */
    @Override
    public List<PresaleRuleVo> findPresaleRuleVosByGoodsId(Integer goodsId, Integer page, Integer limit) {
        /**
         * 获得List<PresaleRule>和GoodsPo对象
         */
        List<PresaleRule> presaleRules = presaleRuleDao.findPresaleRulesByGoodsId(goodsId, page, limit);
//        GoodsPo goodsPo = goodsDao.findGoodsPoById(goodsId);

        List<PresaleRuleVo> presaleRuleVos = new ArrayList<>(presaleRules.size());

        for (PresaleRule presaleRule : presaleRules) {
            PresaleRuleVo presaleRuleVo = new PresaleRuleVo();
            presaleRuleVo.setPresaleRule(presaleRule);
//            presaleRuleVo.setGoodsPo(goodsPo);
            presaleRuleVos.add(presaleRuleVo);
        }
        return presaleRuleVos;
    }

    /**
     * 修改预售信息
     *
     * @param id 预售规则ID
     * @param presaleRule
     * @return
     */
    @Override
    public PresaleRule updatePresaleRuleById(Integer id, PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleRuleDao.updatePresaleRuleById(id, presaleRule);
        return presaleRule1;
    }

    /**
     * 通过id获得PresaleRuleVo
     * @param id 预售规则ID
     * @return PresaleVo
     */
    @Override
    public PresaleRuleVo findPresaleRuleVoById(Integer id) {
        PresaleRuleVo presaleRuleVo = new PresaleRuleVo();
        PresaleRule presaleRuleById = presaleRuleDao.findPresaleRuleById(id);
//        GoodsPo goodsPoById = goodsDao.findGoodsPoById(presaleRuleById.getGoodsId());
        if (presaleRuleById.equals(null)/*||goodsPoById.equals(null)*/) {
            return null;
        }
//        presaleRuleVo.setGoodsPo(goodsPoById);
        presaleRuleVo.setPresaleRule(presaleRuleById);
        return presaleRuleVo;
    }

}
