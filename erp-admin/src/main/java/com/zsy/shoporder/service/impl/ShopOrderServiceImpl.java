package com.zsy.shoporder.service.impl;

import java.util.List;
import com.zsy.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.shoporder.mapper.ShopOrderMapper;
import com.zsy.shoporder.domain.ShopOrder;
import com.zsy.shoporder.service.IShopOrderService;
import com.zsy.common.core.text.Convert;

/**
 * 七品馆订单信息表Service业务层处理
 * 
 * @author wbq
 * @date 2020-07-17
 */
@Service
public class ShopOrderServiceImpl implements IShopOrderService 
{
    @Autowired
    private ShopOrderMapper shopOrderMapper;

    /**
     * 查询七品馆订单信息表
     * 
     * @param id 七品馆订单信息表ID
     * @return 七品馆订单信息表
     */
    @Override
    public ShopOrder selectShopOrderById(Long id)
    {
        return shopOrderMapper.selectShopOrderById(id);
    }

    /**
     * 查询七品馆订单信息表列表
     * 
     * @param shopOrder 七品馆订单信息表
     * @return 七品馆订单信息表
     */
    @Override
    public List<ShopOrder> selectShopOrderList(ShopOrder shopOrder)
    {
        return shopOrderMapper.selectShopOrderList(shopOrder);
    }

    /**
     * 新增七品馆订单信息表
     * 
     * @param shopOrder 七品馆订单信息表
     * @return 结果
     */
    @Override
    public int insertShopOrder(ShopOrder shopOrder)
    {
        shopOrder.setCreateTime(DateUtils.getNowDate());
        return shopOrderMapper.insertShopOrder(shopOrder);
    }

    /**
     * 修改七品馆订单信息表
     * 
     * @param shopOrder 七品馆订单信息表
     * @return 结果
     */
    @Override
    public int updateShopOrder(ShopOrder shopOrder)
    {
        return shopOrderMapper.updateShopOrder(shopOrder);
    }

    /**
     * 删除七品馆订单信息表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShopOrderByIds(String ids)
    {
        return shopOrderMapper.deleteShopOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除七品馆订单信息表信息
     * 
     * @param id 七品馆订单信息表ID
     * @return 结果
     */
    @Override
    public int deleteShopOrderById(Long id)
    {
        return shopOrderMapper.deleteShopOrderById(id);
    }
}
