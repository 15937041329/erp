package com.zsy.wbqshop.service.impl;

import java.util.List;
import com.zsy.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.wbqshop.mapper.ShopMapper;
import com.zsy.wbqshop.domain.Shop;
import com.zsy.wbqshop.service.IShopService;
import com.zsy.common.core.text.Convert;

/**
 * wbqshopService业务层处理
 * 
 * @author wbq
 * @date 2020-07-10
 */
@Service
public class ShopServiceImpl implements IShopService 
{
    @Autowired
    private ShopMapper shopMapper;

    /**
     * 查询wbqshop
     * 
     * @param id wbqshopID
     * @return wbqshop
     */
    @Override
    public Shop selectShopById(Long id)
    {
        return shopMapper.selectShopById(id);
    }

    /**
     * 查询wbqshop列表
     * 
     * @param shop wbqshop
     * @return wbqshop
     */
    @Override
    public List<Shop> selectShopList(Shop shop)
    {
        return shopMapper.selectShopList(shop);
    }

    /**
     * 新增wbqshop
     * 
     * @param shop wbqshop
     * @return 结果
     */
    @Override
    public int insertShop(Shop shop)
    {
        shop.setCreateTime(DateUtils.getNowDate());
        return shopMapper.insertShop(shop);
    }

    /**
     * 修改wbqshop
     * 
     * @param shop wbqshop
     * @return 结果
     */
    @Override
    public int updateShop(Shop shop)
    {
        return shopMapper.updateShop(shop);
    }

    /**
     * 删除wbqshop对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShopByIds(String ids)
    {
        return shopMapper.deleteShopByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除wbqshop信息
     * 
     * @param id wbqshopID
     * @return 结果
     */
    @Override
    public int deleteShopById(Long id)
    {
        return shopMapper.deleteShopById(id);
    }
}
