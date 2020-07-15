package com.zsy.pddstorage.service;

import java.util.List;
import com.zsy.pddstorage.domain.PddStorage;

/**
 * 数据存储Service接口
 * 
 * @author wbq
 * @date 2020-07-15
 */
public interface IPddStorageService 
{
    /**
     * 查询数据存储
     * 
     * @param id 数据存储ID
     * @return 数据存储
     */
    public PddStorage selectPddStorageById(Long id);

    /**
     * 查询数据存储列表
     * 
     * @param pddStorage 数据存储
     * @return 数据存储集合
     */
    public List<PddStorage> selectPddStorageList(PddStorage pddStorage);

    /**
     * 新增数据存储
     * 
     * @param pddStorage 数据存储
     * @return 结果
     */
    public int insertPddStorage(PddStorage pddStorage);

    /**
     * 修改数据存储
     * 
     * @param pddStorage 数据存储
     * @return 结果
     */
    public int updatePddStorage(PddStorage pddStorage);

    /**
     * 批量删除数据存储
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePddStorageByIds(String ids);

    /**
     * 删除数据存储信息
     * 
     * @param id 数据存储ID
     * @return 结果
     */
    public int deletePddStorageById(Long id);
}
