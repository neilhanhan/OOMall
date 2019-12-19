package com.xmu.oomall.controller;

import com.xmu.oomall.vo.PresaleRuleVo;
import com.xmu.oomall.service.PresaleRuleService;
import com.xmu.oomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Liuwenhan
 */
@RestController
@RequestMapping("/discountService")

public class PresaleRuleController {

    @Autowired
    PresaleRuleService presaleRuleService;

    /**
     * 管理员查看预售商品列表
     * @param page 页数
     * @param limit 分页大小
     * @return List<PresaleRuleVo>
     */
    @GetMapping("/admin/presaleGoods")
    public Object adminGetPresaleGoods(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "10") Integer limit){
        List<PresaleRuleVo> presaleRuleVoList = presaleRuleService.adminGetPresaleRule(page, limit);
        return ResponseUtil.okList(presaleRuleVoList);
    }

    /**
     * 管理员删除预售信息
     * @param id 预售规则ID
     * @return 无
     */
    @DeleteMapping("/presaleRules/{id}")
    public Object deletePresaleRule(@PathVariable Integer id){
        if(id==null){
            return ResponseUtil.badArgument();
        }
        else if(presaleRuleService.deletePresaleRule(id)){
            return ResponseUtil.ok();
        }
        else{
            return ResponseUtil.fail();
        }
    }

    /**
     * 用户查看预售信息详情
     * @param id 预售规则ID
     * @return PresaleRuleVo
     */
    @GetMapping("/presaleRules/{id}")
    public Object getPresaleRuleById(@PathVariable Integer id){
        if(id==null){
            return ResponseUtil.badArgument();
        }
        PresaleRuleVo presaleRuleVo = presaleRuleService.getPresaleRuleById(id);
        return ResponseUtil.ok(presaleRuleVo);
    }

    /**
     * 用户查看预售商品列表（已上架）
     * @param page 页数
     * @param limit 分页大小
     * @return List<PresaleRuleVo>
     */
    @GetMapping("/presaleGoods")
    public Object customerGetPresaleGoods(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer limit){
        List<PresaleRuleVo> presaleRuleVoList = presaleRuleService.customerGetPresaleRule(page, limit);
        return ResponseUtil.okList(presaleRuleVoList);
    }
}
