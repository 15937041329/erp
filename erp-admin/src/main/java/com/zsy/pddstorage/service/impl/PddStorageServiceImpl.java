package com.zsy.pddstorage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.pddstorage.mapper.PddStorageMapper;
import com.zsy.pddstorage.domain.PddStorage;
import com.zsy.pddstorage.service.IPddStorageService;
import com.zsy.common.core.text.Convert;

/**
 * 数据存储Service业务层处理
 * 
 * @author wbq
 * @date 2020-07-15
 */
@Service
public class PddStorageServiceImpl implements IPddStorageService 
{
    @Autowired
    private PddStorageMapper pddStorageMapper;

    /**
     * 查询数据存储
     * 
     * @param id 数据存储ID
     * @return 数据存储
     */
    @Override
    public PddStorage selectPddStorageById(Long id)
    {
        return pddStorageMapper.selectPddStorageById(id);
    }

    /**
     * 查询数据存储列表
     * 
     * @param pddStorage 数据存储
     * @return 数据存储
     */
    @Override
    public List<PddStorage> selectPddStorageList(PddStorage pddStorage)
    {
        return pddStorageMapper.selectPddStorageList(pddStorage);
    }

    /**
     * 新增数据存储
     * 
     * @param pddStorage 数据存储
     * @return 结果
     */
    @Override
    public int insertPddStorage(PddStorage pddStorage)
    {
        return pddStorageMapper.insertPddStorage(pddStorage);
    }

    /**
     * 修改数据存储
     * 
     * @param pddStorage 数据存储
     * @return 结果
     */
    @Override
    public int updatePddStorage(PddStorage pddStorage)
    {
        return pddStorageMapper.updatePddStorage(pddStorage);
    }

    /**
     * 删除数据存储对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePddStorageByIds(String ids)
    {
        return pddStorageMapper.deletePddStorageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据存储信息
     * 
     * @param id 数据存储ID
     * @return 结果
     */
    @Override
    public int deletePddStorageById(Long id)
    {
        return pddStorageMapper.deletePddStorageById(id);
    }
}
