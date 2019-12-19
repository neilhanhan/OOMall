package com.xmu.oomall.controller;

import com.xmu.oomall.service.GrouponRuleService;
import com.xmu.oomall.vo.GrouponRuleVo;
import com.xmu.oomall.domain.GrouponRulePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Liuwenhan
 */

@RestController
@RequestMapping("/discountService")

public class GrouponRuleController {

    @Autowired
     private GrouponRuleService grouponRuleService;

    /**
     * 测试成功
     * 通过商品ID获取团购规则列表
     * @param goodsId 商品ID
     * @param page 页数
     * @param limit 分页大小
     * @return 团购规则列表
     */
    @GetMapping("/grouponRules")
    public Object getGrouponRuleByGoodsId(@RequestParam Integer goodsId,
                                          @RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer limit)
    {
        if(goodsId==null||goodsId<0){
            return ResponseUtil.badArgumentValue();
        }
        List<GrouponRuleVo> grouponRuleVoList = grouponRuleService.getGrouponRuleByGoodsId(goodsId,page,limit);
        return ResponseUtil.okList(grouponRuleVoList);
    }

    /**
     * 测试成功
     * 添加团购规则
     * @param grouponRulePo 团购规则ID
     * @return 团购规则Po
     */
    @PostMapping("/grouponRules")
    public Object addGrouponRule(@RequestBody GrouponRulePo grouponRulePo){
        grouponRulePo.setGmtCreate(LocalDateTime.now());
        grouponRulePo.setGmtModified(LocalDateTime.now());
        grouponRulePo.setBeDeleted(false);
        grouponRulePo.setStatusCode(true);
        if(grouponRuleService.addGrouponRule(grouponRulePo)){
            return ResponseUtil.ok(grouponRulePo);
        }
        else{
            return ResponseUtil.fail();
        }
    }

    /**
     * 测试成功
     * 用户通过团购规则ID获取团购活动
     * @param id 团购规则ID
     * @return GrouponRuleVo
     */
    @GetMapping("/grouponRules/{id}")
    public Object getGrouponRuleById(@PathVariable Integer id){
        if (id == null) {
            return ResponseUtil.badArgument();
        }
        GrouponRuleVo grouponRuleVo = grouponRuleService.getGrouponRuleById(id);
        return ResponseUtil.ok(grouponRuleVo);
    }

    /**
     * 测试成功
     * 管理员通过团购规则ID获取团购规则详情
     * @param id
     * @return
     */
    @GetMapping("/admin/grouponRules/{id}")
    public Object adminGetGrouponRuleById(@PathVariable Integer id){
        if (id == null) {
            return ResponseUtil.badArgument();
        }
        GrouponRuleVo grouponRuleVo = grouponRuleService.adminGetGrouponRuleById(id);
        return ResponseUtil.ok(grouponRuleVo);
    }

    /**
     * 测试成功
     * 更新团购规则
     * @param id 团购规则ID
     * @param grouponRulePo GrouponRulePo
     * @return GrouponRulePo
     */
    @PutMapping("/grouponRules/{id}")
    public Object updateGrouponRule(@PathVariable Integer id,
                                    @RequestBody GrouponRulePo grouponRulePo){
        if(id==null){
            return ResponseUtil.badArgument();
        }
        grouponRulePo.setGmtModified(LocalDateTime.now());
        grouponRulePo.setId(id);
        if(grouponRuleService.updateGrouponRule(grouponRulePo)){
            return ResponseUtil.ok(grouponRulePo);
        }
        else{
            return ResponseUtil.fail();
        }
    }

    /**
     * 测试成功
     * 删除团购规则
     * @param id 团购规则ID
     */
    @DeleteMapping("/grouponRules/{id}")
    public Object deleteGrouponRuleById(@PathVariable Integer id){
        if(id == null){
            return ResponseUtil.badArgument();
        }
        else if(grouponRuleService.deleteGrouponRule(id)) {
            return ResponseUtil.ok();
        }
        else {
            return ResponseUtil.fail();
        }
    }

    /**
     * 测试成功
     * 普通用户获取团购规则列表（未删除且上架中）
     * @param page 页数
     * @param limit 分页大小
     * @return List<GrouponRuleVo>
     */
    @GetMapping("/grouponGoods")
    public Object customerGetGrouponRules(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer limit){
        List<GrouponRuleVo> grouponRuleVoList = grouponRuleService.customerGetGrouponRule(page, limit);
        return ResponseUtil.okList(grouponRuleVoList);
    }

    /**
     * 测试成功
     * 管理员获取团购规则列表（全部）
     * @param page 页数
     * @param limit 分页大小
     * @return List<GrouponRuleVo>
     */
    @GetMapping("/admin/grouponGoods")
    public Object adminGetGrouponRules(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer limit){
        List<GrouponRuleVo> grouponRuleVoList = grouponRuleService.adminGetGrouponRule(page,limit);
        return ResponseUtil.okList(grouponRuleVoList);
    }
}