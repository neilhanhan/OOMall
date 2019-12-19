package com.xmu.oomall.controller;

import com.xmu.oomall.domain.Order;
import com.xmu.oomall.service.GrouponRuleServiceImpl;
import com.xmu.oomall.service.PresaleRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discountService")
public class DiscountController {

    @Autowired
    GrouponRuleServiceImpl grouponRuleServiceImpl;
    @Autowired
    PresaleRuleService presaleRuleService;

    /**
     * 内部接口
     * @param order
     * @return order
     */
    @PostMapping("/orders")
    public Object calculateOrders(Order order){
        return order;
    }
}
