package com.xmu.oomall.controller;

import com.xmu.oomall.domain.Goods;
import com.xmu.oomall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("/goods/{id}")
    public Goods findGoodsById(@PathVariable("id")Integer id){return goodsService.findGoodsById(id);}

}
