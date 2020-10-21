package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author cosmoswong
 * @email sunlightcs@gmail.com
 * @date 2020-10-14 16:40:35
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
