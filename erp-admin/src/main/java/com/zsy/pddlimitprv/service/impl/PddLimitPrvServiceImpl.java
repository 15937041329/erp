package com.zsy.pddlimitprv.service.impl;

import java.util.List;

import com.zsy.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.pddlimitprv.mapper.PddLimitPrvMapper;
import com.zsy.pddlimitprv.domain.PddLimitPrv;
import com.zsy.pddlimitprv.service.IPddLimitPrvService;
import com.zsy.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 黑名单地区及年龄筛选Service业务层处理
 *
 * @author wbq
 * @date 2020-07-11
 */
@Service
public class PddLimitPrvServiceImpl implements IPddLimitPrvService {
    @Resource
    private PddLimitPrvMapper pddLimitPrvMapper;

    /**
     * 查询黑名单地区及年龄筛选
     *
     * @param id 黑名单地区及年龄筛选ID
     * @return 黑名单地区及年龄筛选
     */
    @Override
    public PddLimitPrv selectPddLimitPrvById(Long id) {
        return pddLimitPrvMapper.selectPddLimitPrvById(id);
    }

    /**
     * 查询黑名单地区及年龄筛选列表
     *
     * @param pddLimitPrv 黑名单地区及年龄筛选
     * @return 黑名单地区及年龄筛选
     */
    @Override
    public List<PddLimitPrv> selectPddLimitPrvList(PddLimitPrv pddLimitPrv) {
        return pddLimitPrvMapper.selectPddLimitPrvList(pddLimitPrv);
    }

    /**
     * 新增黑名单地区及年龄筛选
     *
     * @param pddLimitPrv 黑名单地区及年龄筛选
     * @return 结果
     */
    @Override
    public int insertPddLimitPrv(PddLimitPrv pddLimitPrv) {
        PddLimitPrv pddLimitPrvQuery = new PddLimitPrv();
        pddLimitPrvQuery.setSkuName(pddLimitPrv.getSkuName());

        List<PddLimitPrv> pddLimitPrvList = pddLimitPrvMapper.selectPddLimitPrvList(pddLimitPrvQuery);
        if (pddLimitPrvList.size() > 0) {
            if (!pddLimitPrvList.get(0).getMinAge().equals(pddLimitPrv.getMinAge()) || !pddLimitPrvList.get(0).getMaxAge().equals(pddLimitPrv.getMaxAge())) {
                pddLimitPrv.setMinAge(pddLimitPrvList.get(0).getMinAge());
                pddLimitPrv.setMaxAge(pddLimitPrvList.get(0).getMaxAge());
            }
        }
        pddLimitPrv.setCreateTime(DateUtils.getNowDate());
        return pddLimitPrvMapper.insertPddLimitPrv(pddLimitPrv);
    }

    /**
     * 修改黑名单地区及年龄筛选
     *
     * @param pddLimitPrv 黑名单地区及年龄筛选
     * @return 结果
     */
    @Override
    public int updatePddLimitPrv(PddLimitPrv pddLimitPrv) {
        pddLimitPrv.setUpdateTime(DateUtils.getNowDate());
        return pddLimitPrvMapper.updatePddLimitPrv(pddLimitPrv);
    }

    /**
     * 删除黑名单地区及年龄筛选对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePddLimitPrvByIds(String ids) {
        return pddLimitPrvMapper.deletePddLimitPrvByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除黑名单地区及年龄筛选信息
     *
     * @param id 黑名单地区及年龄筛选ID
     * @return 结果
     */
    @Override
    public int deletePddLimitPrvById(Long id) {
        return pddLimitPrvMapper.deletePddLimitPrvById(id);
    }
}
