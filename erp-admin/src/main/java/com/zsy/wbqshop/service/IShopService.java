package com.zsy.wbqshop.service;

import java.util.List;
import com.zsy.wbqshop.domain.Shop;

/**
 * wbqshopService接口
 * 
 * @author wbq
 * @date 2020-07-10
 */
public interface IShopService 
{
    /**
     * 查询wbqshop
     * 
     * @param id wbqshopID
     * @return wbqshop
     */
    public Shop selectShopById(Long id);

    /**
     * 查询wbqshop列表
     * 
     * @param shop wbqshop
     * @return wbqshop集合
     */
    public List<Shop> selectShopList(Shop shop);

    /**
     * 新增wbqshop
     * 
     * @param shop wbqshop
     * @return 结果
     */
    public int insertShop(Shop shop);

    /**
     * 修改wbqshop
     * 
     * @param shop wbqshop
     * @return 结果
     */
    public int updateShop(Shop shop);

    /**
     * 批量删除wbqshop
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShopByIds(String ids);

    /**
     * 删除wbqshop信息
     * 
     * @param id wbqshopID
     * @return 结果
     */
    public int deleteShopById(Long id);
}
