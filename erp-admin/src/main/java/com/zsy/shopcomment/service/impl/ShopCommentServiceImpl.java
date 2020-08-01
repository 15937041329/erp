package com.zsy.shopcomment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zsy.shopcomment.mapper.ShopCommentMapper;
import com.zsy.shopcomment.domain.ShopComment;
import com.zsy.shopcomment.service.IShopCommentService;
import com.zsy.common.core.text.Convert;

/**
 * 评论Service业务层处理
 * 
 * @author wbq
 * @date 2020-07-18
 */
@Service
public class ShopCommentServiceImpl implements IShopCommentService 
{
    @Autowired
    private ShopCommentMapper shopCommentMapper;

    /**
     * 查询评论
     * 
     * @param id 评论ID
     * @return 评论
     */
    @Override
    public ShopComment selectShopCommentById(Long id)
    {
        return shopCommentMapper.selectShopCommentById(id);
    }

    /**
     * 查询评论列表
     * 
     * @param shopComment 评论
     * @return 评论
     */
    @Override
    public List<ShopComment> selectShopCommentList(ShopComment shopComment)
    {
        return shopCommentMapper.selectShopCommentList(shopComment);
    }

    /**
     * 新增评论
     * 
     * @param shopComment 评论
     * @return 结果
     */
    @Override
    public int insertShopComment(ShopComment shopComment)
    {
        return shopCommentMapper.insertShopComment(shopComment);
    }

    /**
     * 修改评论
     * 
     * @param shopComment 评论
     * @return 结果
     */
    @Override
    public int updateShopComment(ShopComment shopComment)
    {
        return shopCommentMapper.updateShopComment(shopComment);
    }

    /**
     * 删除评论对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShopCommentByIds(String ids)
    {
        return shopCommentMapper.deleteShopCommentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论信息
     * 
     * @param id 评论ID
     * @return 结果
     */
    @Override
    public int deleteShopCommentById(Long id)
    {
        return shopCommentMapper.deleteShopCommentById(id);
    }
}
