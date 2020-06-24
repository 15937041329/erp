package com.zsy.beijing.mapper;

import java.util.List;
import com.zsy.beijing.domain.BeijingOrder;

/**
 * 北京订单Mapper接口
 * 
 * @author wangbingquan
 * @date 2020-06-03
 */
public interface BeijingOrderMapper 
{
    /**
     * 查询北京订单
     * 
     * @param id 北京订单ID
     * @return 北京订单
     */
    public BeijingOrder selectBeijingOrderById(Long id);

    /**
     * 查询北京订单列表
     * 
     * @param beijingOrder 北京订单
     * @return 北京订单集合
     */
    public List<BeijingOrder> selectBeijingOrderList(BeijingOrder beijingOrder);

    /**
     * 新增北京订单
     * 
     * @param beijingOrder 北京订单
     * @return 结果
     */
    public int insertBeijingOrder(BeijingOrder beijingOrder);

    /**
     * 修改北京订单
     * 
     * @param beijingOrder 北京订单
     * @return 结果
     */
    public int updateBeijingOrder(BeijingOrder beijingOrder);

    /**
     * 删除北京订单
     * 
     * @param id 北京订单ID
     * @return 结果
     */
    public int deleteBeijingOrderById(Long id);

    /**
     * 批量删除北京订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBeijingOrderByIds(String[] ids);
}
