package com.zsy.beijing.service.impl;

import java.util.List;
import com.zsy.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.beijing.mapper.BeijingOrderMapper;
import com.zsy.beijing.domain.BeijingOrder;
import com.zsy.beijing.service.IBeijingOrderService;
import com.zsy.common.core.text.Convert;

/**
 * 北京订单Service业务层处理
 * 
 * @author wangbingquan
 * @date 2020-06-03
 */
@Service
public class BeijingOrderServiceImpl implements IBeijingOrderService 
{
    @Autowired
    private BeijingOrderMapper beijingOrderMapper;

    /**
     * 查询北京订单
     * 
     * @param id 北京订单ID
     * @return 北京订单
     */
    @Override
    public BeijingOrder selectBeijingOrderById(Long id)
    {
        return beijingOrderMapper.selectBeijingOrderById(id);
    }

    /**
     * 查询北京订单列表
     * 
     * @param beijingOrder 北京订单
     * @return 北京订单
     */
    @Override
    public List<BeijingOrder> selectBeijingOrderList(BeijingOrder beijingOrder)
    {
        return beijingOrderMapper.selectBeijingOrderList(beijingOrder);
    }

    /**
     * 新增北京订单
     * 
     * @param beijingOrder 北京订单
     * @return 结果
     */
    @Override
    public int insertBeijingOrder(BeijingOrder beijingOrder)
    {
        beijingOrder.setCreateTime(DateUtils.getNowDate());
        return beijingOrderMapper.insertBeijingOrder(beijingOrder);
    }

    /**
     * 修改北京订单
     * 
     * @param beijingOrder 北京订单
     * @return 结果
     */
    @Override
    public int updateBeijingOrder(BeijingOrder beijingOrder)
    {
        return beijingOrderMapper.updateBeijingOrder(beijingOrder);
    }

    /**
     * 删除北京订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBeijingOrderByIds(String ids)
    {
        return beijingOrderMapper.deleteBeijingOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除北京订单信息
     * 
     * @param id 北京订单ID
     * @return 结果
     */
    @Override
    public int deleteBeijingOrderById(Long id)
    {
        return beijingOrderMapper.deleteBeijingOrderById(id);
    }
}
