package com.xmu.oomall.controller;

import com.xmu.oomall.domain.PresaleRule;
import com.xmu.oomall.util.ResponseUtil;
import com.xmu.oomall.vo.PresaleRuleVo;
import com.xmu.oomall.service.PresaleRuleService;
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

    /**
     * 管理员根据条件查询预售信息
     *
     * @param goodsId
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/presaleRules")
    public Object getPresaleRuleVoByInf(@RequestParam("goodsId") Integer goodsId,
                                        @RequestParam("page") Integer page,
                                        @RequestParam("limit") Integer limit) {
        List<PresaleRuleVo> presaleRuleVos = presaleRuleService.findPresaleRuleVosByGoodsId(goodsId, page, limit);
        return ResponseUtil.ok(presaleRuleVos);
    }

    /**
     * 发布预售信息
     *
     * @param presaleRule
     * @return
     */
    @PostMapping("/presaleRules")
    public PresaleRule addPresaleRule(@RequestBody PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleRuleService.addPresaleRule(presaleRule);
        if (presaleRule1.equals(null)) {
            ResponseUtil.presaleInsertFail();
        }
        return presaleRule1;
    }

    /**
     * 修改预售信息
     *
     * @param id
     * @param presaleRule
     * @return
     */
    @PutMapping("/presaleRules/{id}")
    public PresaleRule updatePresaleRuleById(@PathVariable Integer id, @RequestBody PresaleRule presaleRule) {
        PresaleRule presaleRule1 = presaleRuleService.updatePresaleRuleById(id, presaleRule);
        if (presaleRule1.equals(null)) {
            ResponseUtil.presaleUpdateFail();
        }
        return presaleRule1;
    }

    /**
     * 查看预售信息详情
     *
     * @param id
     * @return
     */
    @GetMapping("/presaleRules/{id}")
    public PresaleRuleVo getPresaleRuleVoById(@PathVariable Integer id) {
        PresaleRuleVo presaleRuleVoById = presaleRuleService.findPresaleRuleVoById(id);
        if (presaleRuleVoById.equals(null)) {
            ResponseUtil.presaleRuleUnknown();
        }
        return presaleRuleVoById;
    }
}
