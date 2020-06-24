package com.zsy.huiyuan.service.impl;

import java.util.List;
import com.zsy.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.huiyuan.mapper.HuiyuanOrderMapper;
import com.zsy.huiyuan.domain.HuiyuanOrder;
import com.zsy.huiyuan.service.IHuiyuanOrderService;
import com.zsy.common.core.text.Convert;

/**
 * 未来会员Service业务层处理
 * 
 * @author wangbingquan
 * @date 2020-06-23
 */
@Service
public class HuiyuanOrderServiceImpl implements IHuiyuanOrderService 
{
    @Autowired
    private HuiyuanOrderMapper huiyuanOrderMapper;

    /**
     * 查询未来会员
     * 
     * @param id 未来会员ID
     * @return 未来会员
     */
    @Override
    public HuiyuanOrder selectHuiyuanOrderById(Long id)
    {
        return huiyuanOrderMapper.selectHuiyuanOrderById(id);
    }

    /**
     * 查询未来会员列表
     * 
     * @param huiyuanOrder 未来会员
     * @return 未来会员
     */
    @Override
    public List<HuiyuanOrder> selectHuiyuanOrderList(HuiyuanOrder huiyuanOrder)
    {
        return huiyuanOrderMapper.selectHuiyuanOrderList(huiyuanOrder);
    }

    /**
     * 新增未来会员
     * 
     * @param huiyuanOrder 未来会员
     * @return 结果
     */
    @Override
    public int insertHuiyuanOrder(HuiyuanOrder huiyuanOrder)
    {
        huiyuanOrder.setCreateTime(DateUtils.getNowDate());
        return huiyuanOrderMapper.insertHuiyuanOrder(huiyuanOrder);
    }

    /**
     * 修改未来会员
     * 
     * @param huiyuanOrder 未来会员
     * @return 结果
     */
    @Override
    public int updateHuiyuanOrder(HuiyuanOrder huiyuanOrder)
    {
        return huiyuanOrderMapper.updateHuiyuanOrder(huiyuanOrder);
    }

    /**
     * 删除未来会员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHuiyuanOrderByIds(String ids)
    {
        return huiyuanOrderMapper.deleteHuiyuanOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除未来会员信息
     * 
     * @param id 未来会员ID
     * @return 结果
     */
    @Override
    public int deleteHuiyuanOrderById(Long id)
    {
        return huiyuanOrderMapper.deleteHuiyuanOrderById(id);
    }
}
