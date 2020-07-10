package com.zsy.pdd.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.pdd.mapper.PddMapper;
import com.zsy.pdd.domain.Pdd;
import com.zsy.pdd.service.IPddService;
import com.zsy.common.core.text.Convert;

/**
 * 拼多多表格导入Service业务层处理
 * 
 * @author wbq
 * @date 2020-07-09
 */
@Service
public class PddServiceImpl implements IPddService 
{
    @Autowired
    private PddMapper pddMapper;

    /**
     * 查询拼多多表格导入
     * 
     * @param id 拼多多表格导入ID
     * @return 拼多多表格导入
     */
    @Override
    public Pdd selectPddById(Long id)
    {
        return pddMapper.selectPddById(id);
    }

    /**
     * 查询拼多多表格导入列表
     * 
     * @param pdd 拼多多表格导入
     * @return 拼多多表格导入
     */
    @Override
    public List<Pdd> selectPddList(Pdd pdd)
    {
        return pddMapper.selectPddList(pdd);
    }

    /**
     * 新增拼多多表格导入
     * 
     * @param pdd 拼多多表格导入
     * @return 结果
     */
    @Override
    public int insertPdd(Pdd pdd)
    {
        return pddMapper.insertPdd(pdd);
    }

    /**
     * 修改拼多多表格导入
     * 
     * @param pdd 拼多多表格导入
     * @return 结果
     */
    @Override
    public int updatePdd(Pdd pdd)
    {
        return pddMapper.updatePdd(pdd);
    }

    /**
     * 删除拼多多表格导入对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePddByIds(String ids)
    {
        return pddMapper.deletePddByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除拼多多表格导入信息
     * 
     * @param id 拼多多表格导入ID
     * @return 结果
     */
    @Override
    public int deletePddById(Long id)
    {
        return pddMapper.deletePddById(id);
    }
}
