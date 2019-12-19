package com.xmu.oomall.dao;

import com.xmu.oomall.domain.BrandPo;
import com.xmu.oomall.domain.GoodsCategoryPo;
import com.xmu.oomall.mapper.GoodsCategoryMapper;
import com.xmu.oomall.util.Config;
import com.xmu.oomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class GoodsCategoryDao{
    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    Config config;

    public Object getAllCategories(Integer page,Integer limit){
        List<GoodsCategoryPo> categoryPoList=goodsCategoryMapper.getAllCategories();
        int pagecount=categoryPoList.size()/limit;
        int remain=categoryPoList.size()%limit;
        if(remain>0){
            pagecount++;
        }
        if(page>pagecount) {
            return ResponseUtil.fail(402,"page值超过界限");
        }
        List<GoodsCategoryPo> subList=null;
        if(remain==0) {
            subList=categoryPoList.subList((page-1)*limit,page*limit);
        }
        else{
            if (page==pagecount){
                subList=categoryPoList.subList((page-1)*limit,categoryPoList.size());
            }else{
                subList=categoryPoList.subList((page-1)*limit,page*limit);
            }
        }
        return ResponseUtil.ok(subList);
    }

    public Object addCategory(GoodsCategoryPo goodsCategoryPo)
    {
        LocalDateTime time=LocalDateTime.now();
        goodsCategoryPo.setGmtCreate(time);
        goodsCategoryPo.setGmtModified(time);
        goodsCategoryPo.setBeDeleted(false);
        int success=goodsCategoryMapper.addCategory(goodsCategoryPo);
        if(success!=0)
        {
            return ResponseUtil.ok(goodsCategoryPo);
        }
        else {
            return ResponseUtil.fail(505,"新建数据项失败");
        }
    }

    public Object getCategoryById(Integer id)
    {
        String key = "Category_"+id;
        GoodsCategoryPo goodsCategoryPo = (GoodsCategoryPo) redisTemplate.opsForValue().get(key);
        if (goodsCategoryPo == null) {
//            logger.debug("Redis中无goods对象"+key);
            goodsCategoryPo = goodsCategoryMapper.getCategoryById(id);
            if (goodsCategoryPo == null) {
                return ResponseUtil.fail(402, "数据库中无此id或品牌已被删除");
            }
            redisTemplate.opsForValue().set(key, goodsCategoryPo, config.getRedisExpireTime(), TimeUnit.MINUTES);
//            logger.debug("Redis中存入 goods = "+goods);
        }
        return ResponseUtil.ok(goodsCategoryPo);
    }

    public Object updateCategory(Integer id,GoodsCategoryPo goodsCategoryPo)
    {
        goodsCategoryPo.setId(id);
        goodsCategoryPo.setGmtModified(LocalDateTime.now());
        int success=goodsCategoryMapper.updateCategory(goodsCategoryPo);
        if(success==0){
            return ResponseUtil.fail(402,"数据库中无此id或分类已被删除");
        }
        return ResponseUtil.ok(goodsCategoryMapper.getCategoryById(id));
    }

    public Object deleteCategory(Integer id)
    {
        int success=goodsCategoryMapper.deleteCategory(id);
        if(success==0)
        {
            return ResponseUtil.fail(402,"数据库中无此id或分类已被删除");
        }
        return ResponseUtil.ok();
    }

    public Object getLevelOneCategories()
    {
        return ResponseUtil.ok(goodsCategoryMapper.getLevelOneCategories());
    }

    public Object getLevelTwoCategories(Integer id)
    {
        return ResponseUtil.ok(goodsCategoryMapper.getLevelTwoCategories(id));
    }
}