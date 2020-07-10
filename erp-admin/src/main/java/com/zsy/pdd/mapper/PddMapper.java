package com.zsy.pdd.mapper;

import java.util.List;
import com.zsy.pdd.domain.Pdd;

/**
 * 拼多多表格导入Mapper接口
 * 
 * @author wbq
 * @date 2020-07-09
 */
public interface PddMapper 
{
    /**
     * 查询拼多多表格导入
     * 
     * @param id 拼多多表格导入ID
     * @return 拼多多表格导入
     */
    public Pdd selectPddById(Long id);

    /**
     * 查询拼多多表格导入列表
     * 
     * @param pdd 拼多多表格导入
     * @return 拼多多表格导入集合
     */
    public List<Pdd> selectPddList(Pdd pdd);

    /**
     * 新增拼多多表格导入
     * 
     * @param pdd 拼多多表格导入
     * @return 结果
     */
    public int insertPdd(Pdd pdd);

    /**
     * 修改拼多多表格导入
     * 
     * @param pdd 拼多多表格导入
     * @return 结果
     */
    public int updatePdd(Pdd pdd);

    /**
     * 删除拼多多表格导入
     * 
     * @param id 拼多多表格导入ID
     * @return 结果
     */
    public int deletePddById(Long id);

    /**
     * 批量删除拼多多表格导入
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePddByIds(String[] ids);
}
