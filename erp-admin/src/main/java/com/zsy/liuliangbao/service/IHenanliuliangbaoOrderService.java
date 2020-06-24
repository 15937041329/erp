package com.zsy.liuliangbao.service;

import java.util.List;
import com.zsy.liuliangbao.domain.HenanliuliangbaoOrder;

/**
 * 头条抖音流量包Service接口
 * 
 * @author wangbingquan
 * @date 2020-06-09
 */
public interface IHenanliuliangbaoOrderService 
{
    /**
     * 查询头条抖音流量包
     * 
     * @param id 头条抖音流量包ID
     * @return 头条抖音流量包
     */
    public HenanliuliangbaoOrder selectHenanliuliangbaoOrderById(Long id);

    /**
     * 查询头条抖音流量包列表
     * 
     * @param henanliuliangbaoOrder 头条抖音流量包
     * @return 头条抖音流量包集合
     */
    public List<HenanliuliangbaoOrder> selectHenanliuliangbaoOrderList(HenanliuliangbaoOrder henanliuliangbaoOrder);

    /**
     * 新增头条抖音流量包
     * 
     * @param henanliuliangbaoOrder 头条抖音流量包
     * @return 结果
     */
    public int insertHenanliuliangbaoOrder(HenanliuliangbaoOrder henanliuliangbaoOrder);

    /**
     * 修改头条抖音流量包
     * 
     * @param henanliuliangbaoOrder 头条抖音流量包
     * @return 结果
     */
    public int updateHenanliuliangbaoOrder(HenanliuliangbaoOrder henanliuliangbaoOrder);

    /**
     * 批量删除头条抖音流量包
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHenanliuliangbaoOrderByIds(String ids);

    /**
     * 删除头条抖音流量包信息
     * 
     * @param id 头条抖音流量包ID
     * @return 结果
     */
    public int deleteHenanliuliangbaoOrderById(Long id);
}
