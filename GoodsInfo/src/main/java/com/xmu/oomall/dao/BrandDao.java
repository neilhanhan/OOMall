package com.xmu.oomall.dao;

import com.xmu.oomall.domain.BrandPo;
import com.xmu.oomall.mapper.BrandMapper;
import com.xmu.oomall.util.Config;
import com.xmu.oomall.util.FileUtils;
import com.xmu.oomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class BrandDao{
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private Config config;


    public Object getAllBrand(Integer page, Integer limit) {

        List<BrandPo> brandList=brandMapper.getAllBrand();
        int pagecount=brandList.size()/limit;
        int remain=brandList.size()%limit;
        if(remain>0){
            pagecount++;
        }
        if(page>pagecount) {
            return ResponseUtil.fail(402,"page值超过界限");
        }
        List<BrandPo> subList=null;
        if(remain==0) {
            subList=brandList.subList((page-1)*limit,page*limit);
        }
        else{
            if (page==pagecount){
                subList=brandList.subList((page-1)*limit,brandList.size());
            }else{
                subList=brandList.subList((page-1)*limit,page*limit);
            }
        }
        return subList;
    }

    public Object addBrand(BrandPo brandPo) {
        LocalDateTime time=LocalDateTime.now();
        brandPo.setGmtCreate(time);
        brandPo.setGmtModified(time);
        brandPo.setBeDeleted(false);
        int success=brandMapper.addBrand(brandPo);
        if(success!=0)
        {
            return brandPo;
        }
        else {
            return ResponseUtil.fail(505,"新建数据项失败");
        }
    }

    public Object getBrandById(Integer id) {
        String key = "Brand_"+id;
        BrandPo brandPo = (BrandPo) redisTemplate.opsForValue().get(key);
        if (brandPo == null) {
//            logger.debug("Redis中无goods对象"+key);
            brandPo = brandMapper.getBrandById(id);
            if(brandPo==null)
            {
                return ResponseUtil.fail(402,"数据库中无此id或品牌已被删除");
            }
            redisTemplate.opsForValue().set(key, brandPo, config.getRedisExpireTime(), TimeUnit.MINUTES);
//            logger.debug("Redis中存入 goods = "+goods);
        }

        return brandPo;
    }

    public Object updateBrand(Integer id, BrandPo brandPo) {
        brandPo.setId(id);
        brandPo.setGmtModified(LocalDateTime.now());
        int success=brandMapper.updateBrand(brandPo);
        if(success==0)
        {
            return ResponseUtil.fail(402,"数据库中无此id或品牌已被删除");
        }
        return brandMapper.getBrandById(id);
    }

    public Object deleteBrand(Integer id) {
        int success=brandMapper.deleteBrand(id);
        if(success==0)
        {
            return ResponseUtil.fail(402,"数据库中无此id或品牌已被删除");
        }
        return null;
    }

    public Object uploadPic(MultipartFile pic) {
        String localPath="E:"+File.separator+"image";
        //2获得文件名字
        String picName=pic.getOriginalFilename();
        //2上传失败提示
        String warning="";
        String newFileName = FileUtils.upload(pic, localPath, picName);
        if(newFileName != null){
            //上传成功
            warning=localPath+ File.separator +newFileName;

        }else{
            return ResponseUtil.fail(505,"图片上传失败");
        }
        return warning;

    }
}