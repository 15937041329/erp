package com.zsy.shopcomment.service;

import java.util.List;
import com.zsy.shopcomment.domain.ShopComment;

/**
 * 评论Service接口
 * 
 * @author wbq
 * @date 2020-07-18
 */
public interface IShopCommentService 
{
    /**
     * 查询评论
     * 
     * @param id 评论ID
     * @return 评论
     */
    public ShopComment selectShopCommentById(Long id);

    /**
     * 查询评论列表
     * 
     * @param shopComment 评论
     * @return 评论集合
     */
    public List<ShopComment> selectShopCommentList(ShopComment shopComment);

    /**
     * 新增评论
     * 
     * @param shopComment 评论
     * @return 结果
     */
    public int insertShopComment(ShopComment shopComment);

    /**
     * 修改评论
     * 
     * @param shopComment 评论
     * @return 结果
     */
    public int updateShopComment(ShopComment shopComment);

    /**
     * 批量删除评论
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShopCommentByIds(String ids);

    /**
     * 删除评论信息
     * 
     * @param id 评论ID
     * @return 结果
     */
    public int deleteShopCommentById(Long id);
}
