package com.zsy.henan.service;

import java.util.List;
import com.zsy.henan.domain.HenanOrder;

/**
 * 河南订单Service接口
 * 
 * @author wangbingquan
 * @date 2020-06-03
 */
public interface IHenanOrderService 
{
    /**
     * 查询河南订单
     * 
     * @param id 河南订单ID
     * @return 河南订单
     */
    public HenanOrder selectHenanOrderById(Long id);

    /**
     * 查询河南订单列表
     * 
     * @param henanOrder 河南订单
     * @return 河南订单集合
     */
    public List<HenanOrder> selectHenanOrderList(HenanOrder henanOrder);

    /**
     * 新增河南订单
     * 
     * @param henanOrder 河南订单
     * @return 结果
     */
    public int insertHenanOrder(HenanOrder henanOrder);

    /**
     * 修改河南订单
     * 
     * @param henanOrder 河南订单
     * @return 结果
     */
    public int updateHenanOrder(HenanOrder henanOrder);

    /**
     * 批量删除河南订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHenanOrderByIds(String ids);

    /**
     * 删除河南订单信息
     * 
     * @param id 河南订单ID
     * @return 结果
     */
    public int deleteHenanOrderById(Long id);
}
