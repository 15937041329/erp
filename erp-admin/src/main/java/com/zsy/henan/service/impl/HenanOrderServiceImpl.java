package com.zsy.henan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.henan.mapper.HenanOrderMapper;
import com.zsy.henan.domain.HenanOrder;
import com.zsy.henan.service.IHenanOrderService;
import com.zsy.common.core.text.Convert;

/**
 * 河南订单Service业务层处理
 * 
 * @author wangbingquan
 * @date 2020-06-03
 */
@Service
public class HenanOrderServiceImpl implements IHenanOrderService 
{
    @Autowired
    private HenanOrderMapper henanOrderMapper;

    /**
     * 查询河南订单
     * 
     * @param id 河南订单ID
     * @return 河南订单
     */
    @Override
    public HenanOrder selectHenanOrderById(Long id)
    {
        return henanOrderMapper.selectHenanOrderById(id);
    }

    /**
     * 查询河南订单列表
     * 
     * @param henanOrder 河南订单
     * @return 河南订单
     */
    @Override
    public List<HenanOrder> selectHenanOrderList(HenanOrder henanOrder)
    {
        return henanOrderMapper.selectHenanOrderList(henanOrder);
    }

    /**
     * 新增河南订单
     * 
     * @param henanOrder 河南订单
     * @return 结果
     */
    @Override
    public int insertHenanOrder(HenanOrder henanOrder)
    {
        return henanOrderMapper.insertHenanOrder(henanOrder);
    }

    /**
     * 修改河南订单
     * 
     * @param henanOrder 河南订单
     * @return 结果
     */
    @Override
    public int updateHenanOrder(HenanOrder henanOrder)
    {
        return henanOrderMapper.updateHenanOrder(henanOrder);
    }

    /**
     * 删除河南订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHenanOrderByIds(String ids)
    {
        return henanOrderMapper.deleteHenanOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除河南订单信息
     * 
     * @param id 河南订单ID
     * @return 结果
     */
    @Override
    public int deleteHenanOrderById(Long id)
    {
        return henanOrderMapper.deleteHenanOrderById(id);
    }
}
