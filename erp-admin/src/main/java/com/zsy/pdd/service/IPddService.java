package com.zsy.pdd.service;

import java.util.List;
import com.zsy.pdd.domain.Pdd;

/**
 * 拼多多表格导入Service接口
 * 
 * @author wbq
 * @date 2020-07-09
 */
public interface IPddService 
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
     * 批量删除拼多多表格导入
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePddByIds(String ids);

    /**
     * 删除拼多多表格导入信息
     * 
     * @param id 拼多多表格导入ID
     * @return 结果
     */
    public int deletePddById(Long id);
}
