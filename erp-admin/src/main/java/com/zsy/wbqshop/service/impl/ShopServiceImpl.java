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
 * 商城Service业务层处理
 * 
 * @author wbq
 * @date 2020-07-17
 */
@Service
public class ShopServiceImpl implements IShopService 
{
    @Autowired
    private ShopMapper shopMapper;

    /**
     * 查询商城
     * 
     * @param id 商城ID
     * @return 商城
     */
    @Override
    public Shop selectShopById(Long id)
    {
        return shopMapper.selectShopById(id);
    }

    /**
     * 查询商城列表
     * 
     * @param shop 商城
     * @return 商城
     */
    @Override
    public List<Shop> selectShopList(Shop shop)
    {
        return shopMapper.selectShopList(shop);
    }

    /**
     * 新增商城
     * 
     * @param shop 商城
     * @return 结果
     */
    @Override
    public int insertShop(Shop shop)
    {
        shop.setCreateTime(DateUtils.getNowDate());
        return shopMapper.insertShop(shop);
    }

    /**
     * 修改商城
     * 
     * @param shop 商城
     * @return 结果
     */
    @Override
    public int updateShop(Shop shop)
    {
        return shopMapper.updateShop(shop);
    }

    /**
     * 删除商城对象
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
     * 删除商城信息
     * 
     * @param id 商城ID
     * @return 结果
     */
    @Override
    public int deleteShopById(Long id)
    {
        return shopMapper.deleteShopById(id);
    }
}
