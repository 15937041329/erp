package com.zsy.pddorder.mapper;

import java.util.List;
import com.zsy.pddorder.domain.PddOrder;

/**
 * 拼多多Mapper接口
 * 
 * @author wangbingquan
 * @date 2020-06-12
 */
public interface PddOrderMapper 
{
    /**
     * 查询拼多多
     * 
     * @param id 拼多多ID
     * @return 拼多多
     */
    public PddOrder selectPddOrderById(Long id);

    /**
     * 查询拼多多列表
     * 
     * @param pddOrder 拼多多
     * @return 拼多多集合
     */
    public List<PddOrder> selectPddOrderList(PddOrder pddOrder);

    /**
     * 新增拼多多
     * 
     * @param pddOrder 拼多多
     * @return 结果
     */
    public int insertPddOrder(PddOrder pddOrder);

    /**
     * 修改拼多多
     * 
     * @param pddOrder 拼多多
     * @return 结果
     */
    public int updatePddOrder(PddOrder pddOrder);

    /**
     * 删除拼多多
     * 
     * @param id 拼多多ID
     * @return 结果
     */
    public int deletePddOrderById(Long id);

    /**
     * 批量删除拼多多
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePddOrderByIds(String[] ids);
}
