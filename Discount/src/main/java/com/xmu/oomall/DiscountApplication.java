package com.xmu.oomall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@author Liuwenhan
 */

@SpringBootApplication
@MapperScan("com.xmu.oomall.mapper")
public class DiscountApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(DiscountApplication.class, args);
    }
}
