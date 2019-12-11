package com.xmu.oomall.controller;

import com.xmu.oomall.domain.GrouponRule;
import com.xmu.oomall.service.GrouponRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Liuwenhan
 */

@RestController
@RequestMapping("/discount")

public class GrouponRuleController {

    @Autowired
     private GrouponRuleService grouponRuleService;

    @GetMapping("/goods/{id}/grouponRules")
    public List<GrouponRule> getGrouponRuleByGoodsId(@PathVariable   Integer id){
        return grouponRuleService.getGrouponRuleByGoodsId(id);
    }

    @PostMapping("/grouponRules")
    public GrouponRule addGrouponRule(@RequestBody GrouponRule grouponRule){
        return grouponRuleService.addGrouponRule(grouponRule);
    }

    @GetMapping("/grouponRules/{id}")
    public GrouponRule getGrouponRuleById(@PathVariable Integer id){
        return grouponRuleService.getGrouponRuleById(id);
    }

    @PutMapping("/grouponRules")
    public GrouponRule updateGrouponRule(@RequestBody GrouponRule grouponRule){
        return grouponRuleService.updateGrouponRule(grouponRule);
    }

    @DeleteMapping("/grouponRules/{id}")
    public void deleteGrouponRuleById(@PathVariable Integer id){
        grouponRuleService.deleteGrouponRule(id);
    }

//    @GetMapping("/grouponRules/{id}/joinInformation")
//    public List<GrouponRule> my(@LoginUser Integer userId, @RequestParam(defaultValue = "0") Integer showType)
}
