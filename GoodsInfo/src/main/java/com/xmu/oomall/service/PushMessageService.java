package com.xmu.oomall.service;

import com.xmu.oomall.dao.GoodsDao;
import com.xmu.oomall.dao.ProductDao;
import com.xmu.oomall.domain.GoodsPo;
import com.xmu.oomall.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PushMessageService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private Config config;

    public void setRedis(){
        List<GoodsPo> goodsPoList=goodsDao.getGoods();
        for (GoodsPo goodsPo:goodsPoList) {
            String key = "P_" + goodsPo.getId();
            redisTemplate.opsForValue().set(key, goodsPo, config.getRedisExpireTime(), TimeUnit.MINUTES);
        }

    }
}
