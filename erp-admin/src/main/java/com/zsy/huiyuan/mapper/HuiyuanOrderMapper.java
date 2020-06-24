package com.zsy.huiyuan.mapper;

import java.util.List;
import com.zsy.huiyuan.domain.HuiyuanOrder;

/**
 * 未来会员Mapper接口
 * 
 * @author wangbingquan
 * @date 2020-06-23
 */
public interface HuiyuanOrderMapper 
{
    /**
     * 查询未来会员
     * 
     * @param id 未来会员ID
     * @return 未来会员
     */
    public HuiyuanOrder selectHuiyuanOrderById(Long id);

    /**
     * 查询未来会员列表
     * 
     * @param huiyuanOrder 未来会员
     * @return 未来会员集合
     */
    public List<HuiyuanOrder> selectHuiyuanOrderList(HuiyuanOrder huiyuanOrder);

    /**
     * 新增未来会员
     * 
     * @param huiyuanOrder 未来会员
     * @return 结果
     */
    public int insertHuiyuanOrder(HuiyuanOrder huiyuanOrder);

    /**
     * 修改未来会员
     * 
     * @param huiyuanOrder 未来会员
     * @return 结果
     */
    public int updateHuiyuanOrder(HuiyuanOrder huiyuanOrder);

    /**
     * 删除未来会员
     * 
     * @param id 未来会员ID
     * @return 结果
     */
    public int deleteHuiyuanOrderById(Long id);

    /**
     * 批量删除未来会员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHuiyuanOrderByIds(String[] ids);
}
