package com.xmu.oomall.service;

import com.github.pagehelper.Page;
import com.xmu.oomall.controller.GrouponRuleVo;
import com.xmu.oomall.dao.GrouponRuleDao;
import com.xmu.oomall.domain.GrouponRulePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Liuwenhan
 */

@Service
public class GrouponRuleService {
    @Autowired
    public GrouponRuleDao grouponRuleDao;

    public List<GrouponRuleVo> getGrouponRuleByGoodsId(Integer id, Integer page, Integer limit){
        List<GrouponRulePo> grouponRuleList = grouponRuleDao.getGrouponRuleByGoodsId(id,page,limit);
        Page<GrouponRuleVo> grouponList = new Page<GrouponRuleVo>();
        for (GrouponRulePo grouponRulePo : grouponRuleList) {
//            Integer goodsId = grouponRulePo.getGoodsId();
//            GoodsPo goods = goodsService.getGoodsById(goodsId);
//            if (goods == null)
//                continue;
            GrouponRuleVo grouponRuleVo = new GrouponRuleVo();
            grouponRuleVo.setGrouponRulePo(grouponRulePo);
//            grouponRuleVo.setGoodsPo(goods);
            grouponList.add(grouponRuleVo);
        }
        return grouponList;
    }

    public Boolean addGrouponRule(GrouponRulePo grouponRulePo){
        return grouponRuleDao.addGrouponRule(grouponRulePo);
    }

    public GrouponRuleVo getGrouponRuleById(Integer id){
        GrouponRulePo grouponRulePo = grouponRuleDao.getGrouponRuleById(id);
        GrouponRuleVo grouponRuleVo = new GrouponRuleVo();
//        Integer GoodsId = grouponRulePo.getGoodsId();
//        GoodsPo goods = goodsService.getGoodsById(goodsId);
//        grouponRuleVo.setGoodsPo(goods);
        grouponRuleVo.setGrouponRulePo(grouponRulePo);
        return grouponRuleVo;
    }

    public GrouponRuleVo adminGetGrouponRuleById(Integer id) {
        GrouponRulePo grouponRulePo = grouponRuleDao.adminGetGrouponRuleById(id);
        GrouponRuleVo grouponRuleVo = new GrouponRuleVo();
//        Integer GoodsId = grouponRulePo.getGoodsId();
//        GoodsPo goods = goodsService.getGoodsById(goodsId);
//        grouponRuleVo.setGoodsPo(goods);
        grouponRuleVo.setGrouponRulePo(grouponRulePo);
        return grouponRuleVo;
    }

    public Boolean updateGrouponRule(GrouponRulePo grouponRulePo){
        return grouponRuleDao.updateGrouponRule(grouponRulePo);
    };

    public Boolean deleteGrouponRule(Integer id){
        return grouponRuleDao.deleteGrouponRule(id);
    };

    public List<GrouponRuleVo> customerGetGrouponRule(Integer page, Integer limit) {
        List<GrouponRulePo> grouponRuleList = grouponRuleDao.customerGetGrouponRule(page,limit);
        Page<GrouponRuleVo> grouponList = new Page<GrouponRuleVo>();

        for (GrouponRulePo grouponRulePo : grouponRuleList) {
//            Integer goodsId = grouponRulePo.getGoodsId();
//            GoodsPo goods = goodsService.getGoodsById(goodsId);
//            if (goods == null)
//                continue;
            GrouponRuleVo grouponRuleVo = new GrouponRuleVo();
            grouponRuleVo.setGrouponRulePo(grouponRulePo);
//            grouponRuleVo.setGoodsPo(goods);
            grouponList.add(grouponRuleVo);
        }
        return grouponList;
    }

    public List<GrouponRuleVo> adminGetGrouponRule(Integer page, Integer limit) {
        List<GrouponRulePo> grouponRuleList = grouponRuleDao.adminGetGrouponRule(page,limit);
        Page<GrouponRuleVo> grouponList = new Page<GrouponRuleVo>();

        for (GrouponRulePo grouponRulePo : grouponRuleList) {
//            Integer goodsId = grouponRulePo.getGoodsId();
//            GoodsPo goods = goodsService.getGoodsById(goodsId);
//            if (goods == null)
//                continue;
            GrouponRuleVo grouponRuleVo = new GrouponRuleVo();
            grouponRuleVo.setGrouponRulePo(grouponRulePo);
//            grouponRuleVo.setGoodsPo(goods);
            grouponList.add(grouponRuleVo);
        }
        return grouponList;
    }

}
