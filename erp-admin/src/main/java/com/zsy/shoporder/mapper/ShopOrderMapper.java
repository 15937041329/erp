package com.zsy.shoporder.mapper;

import java.util.List;
import com.zsy.shoporder.domain.ShopOrder;

/**
 * 七品馆订单信息表Mapper接口
 * 
 * @author wbq
 * @date 2020-07-17
 */
public interface ShopOrderMapper 
{
    /**
     * 查询七品馆订单信息表
     * 
     * @param id 七品馆订单信息表ID
     * @return 七品馆订单信息表
     */
    public ShopOrder selectShopOrderById(Long id);

    /**
     * 查询七品馆订单信息表列表
     * 
     * @param shopOrder 七品馆订单信息表
     * @return 七品馆订单信息表集合
     */
    public List<ShopOrder> selectShopOrderList(ShopOrder shopOrder);

    /**
     * 新增七品馆订单信息表
     * 
     * @param shopOrder 七品馆订单信息表
     * @return 结果
     */
    public int insertShopOrder(ShopOrder shopOrder);

    /**
     * 修改七品馆订单信息表
     * 
     * @param shopOrder 七品馆订单信息表
     * @return 结果
     */
    public int updateShopOrder(ShopOrder shopOrder);

    /**
     * 删除七品馆订单信息表
     * 
     * @param id 七品馆订单信息表ID
     * @return 结果
     */
    public int deleteShopOrderById(Long id);

    /**
     * 批量删除七品馆订单信息表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShopOrderByIds(String[] ids);
}
