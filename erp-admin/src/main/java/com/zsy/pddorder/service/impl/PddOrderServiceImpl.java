package com.zsy.pddorder.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.pddorder.mapper.PddOrderMapper;
import com.zsy.pddorder.domain.PddOrder;
import com.zsy.pddorder.service.IPddOrderService;
import com.zsy.common.core.text.Convert;

/**
 * 拼多多Service业务层处理
 * 
 * @author wangbingquan
 * @date 2020-06-12
 */
@Service
public class PddOrderServiceImpl implements IPddOrderService 
{
    @Autowired
    private PddOrderMapper pddOrderMapper;

    /**
     * 查询拼多多
     * 
     * @param id 拼多多ID
     * @return 拼多多
     */
    @Override
    public PddOrder selectPddOrderById(Long id)
    {
        return pddOrderMapper.selectPddOrderById(id);
    }

    /**
     * 查询拼多多列表
     * 
     * @param pddOrder 拼多多
     * @return 拼多多
     */
    @Override
    public List<PddOrder> selectPddOrderList(PddOrder pddOrder)
    {
        return pddOrderMapper.selectPddOrderList(pddOrder);
    }

    /**
     * 新增拼多多
     * 
     * @param pddOrder 拼多多
     * @return 结果
     */
    @Override
    public int insertPddOrder(PddOrder pddOrder)
    {
        return pddOrderMapper.insertPddOrder(pddOrder);
    }

    /**
     * 修改拼多多
     * 
     * @param pddOrder 拼多多
     * @return 结果
     */
    @Override
    public int updatePddOrder(PddOrder pddOrder)
    {
        return pddOrderMapper.updatePddOrder(pddOrder);
    }

    /**
     * 删除拼多多对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePddOrderByIds(String ids)
    {
        return pddOrderMapper.deletePddOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除拼多多信息
     * 
     * @param id 拼多多ID
     * @return 结果
     */
    @Override
    public int deletePddOrderById(Long id)
    {
        return pddOrderMapper.deletePddOrderById(id);
    }
}
