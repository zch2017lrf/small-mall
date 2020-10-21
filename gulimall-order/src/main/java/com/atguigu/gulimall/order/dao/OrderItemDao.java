package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author cosmoswong
 * @email sunlightcs@gmail.com
 * @date 2020-10-14 17:51:59
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
