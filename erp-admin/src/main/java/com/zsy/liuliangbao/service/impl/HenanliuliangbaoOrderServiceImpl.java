package com.zsy.liuliangbao.service.impl;

import java.util.List;
import com.zsy.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.liuliangbao.mapper.HenanliuliangbaoOrderMapper;
import com.zsy.liuliangbao.domain.HenanliuliangbaoOrder;
import com.zsy.liuliangbao.service.IHenanliuliangbaoOrderService;
import com.zsy.common.core.text.Convert;

/**
 * 头条抖音流量包Service业务层处理
 * 
 * @author wangbingquan
 * @date 2020-06-09
 */
@Service
public class HenanliuliangbaoOrderServiceImpl implements IHenanliuliangbaoOrderService 
{
    @Autowired
    private HenanliuliangbaoOrderMapper henanliuliangbaoOrderMapper;

    /**
     * 查询头条抖音流量包
     * 
     * @param id 头条抖音流量包ID
     * @return 头条抖音流量包
     */
    @Override
    public HenanliuliangbaoOrder selectHenanliuliangbaoOrderById(Long id)
    {
        return henanliuliangbaoOrderMapper.selectHenanliuliangbaoOrderById(id);
    }

    /**
     * 查询头条抖音流量包列表
     * 
     * @param henanliuliangbaoOrder 头条抖音流量包
     * @return 头条抖音流量包
     */
    @Override
    public List<HenanliuliangbaoOrder> selectHenanliuliangbaoOrderList(HenanliuliangbaoOrder henanliuliangbaoOrder)
    {
        return henanliuliangbaoOrderMapper.selectHenanliuliangbaoOrderList(henanliuliangbaoOrder);
    }

    /**
     * 新增头条抖音流量包
     * 
     * @param henanliuliangbaoOrder 头条抖音流量包
     * @return 结果
     */
    @Override
    public int insertHenanliuliangbaoOrder(HenanliuliangbaoOrder henanliuliangbaoOrder)
    {
        henanliuliangbaoOrder.setCreateTime(DateUtils.getNowDate());
        return henanliuliangbaoOrderMapper.insertHenanliuliangbaoOrder(henanliuliangbaoOrder);
    }

    /**
     * 修改头条抖音流量包
     * 
     * @param henanliuliangbaoOrder 头条抖音流量包
     * @return 结果
     */
    @Override
    public int updateHenanliuliangbaoOrder(HenanliuliangbaoOrder henanliuliangbaoOrder)
    {
        return henanliuliangbaoOrderMapper.updateHenanliuliangbaoOrder(henanliuliangbaoOrder);
    }

    /**
     * 删除头条抖音流量包对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHenanliuliangbaoOrderByIds(String ids)
    {
        return henanliuliangbaoOrderMapper.deleteHenanliuliangbaoOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除头条抖音流量包信息
     * 
     * @param id 头条抖音流量包ID
     * @return 结果
     */
    @Override
    public int deleteHenanliuliangbaoOrderById(Long id)
    {
        return henanliuliangbaoOrderMapper.deleteHenanliuliangbaoOrderById(id);
    }
}
