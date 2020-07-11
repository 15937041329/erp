package com.zsy.pddlimitprv.service;

import java.util.List;
import com.zsy.pddlimitprv.domain.PddLimitPrv;

/**
 * 黑名单地区及年龄筛选Service接口
 * 
 * @author wbq
 * @date 2020-07-11
 */
public interface IPddLimitPrvService 
{
    /**
     * 查询黑名单地区及年龄筛选
     * 
     * @param id 黑名单地区及年龄筛选ID
     * @return 黑名单地区及年龄筛选
     */
    public PddLimitPrv selectPddLimitPrvById(Long id);

    /**
     * 查询黑名单地区及年龄筛选列表
     * 
     * @param pddLimitPrv 黑名单地区及年龄筛选
     * @return 黑名单地区及年龄筛选集合
     */
    public List<PddLimitPrv> selectPddLimitPrvList(PddLimitPrv pddLimitPrv);

    /**
     * 新增黑名单地区及年龄筛选
     * 
     * @param pddLimitPrv 黑名单地区及年龄筛选
     * @return 结果
     */
    public int insertPddLimitPrv(PddLimitPrv pddLimitPrv);

    /**
     * 修改黑名单地区及年龄筛选
     * 
     * @param pddLimitPrv 黑名单地区及年龄筛选
     * @return 结果
     */
    public int updatePddLimitPrv(PddLimitPrv pddLimitPrv);

    /**
     * 批量删除黑名单地区及年龄筛选
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePddLimitPrvByIds(String ids);

    /**
     * 删除黑名单地区及年龄筛选信息
     * 
     * @param id 黑名单地区及年龄筛选ID
     * @return 结果
     */
    public int deletePddLimitPrvById(Long id);
}
