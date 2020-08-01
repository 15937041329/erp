package com.zsy.shopcomment.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 评论对象 shop_comment
 * 
 * @author wbq
 * @date 2020-07-18
 */
public class ShopComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private String shopId;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String username;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String comment;

    /** 评论条数 */
    @Excel(name = "评论条数")
    private Long commentnum;

    /** 评论区图1 */
    @Excel(name = "评论区图1")
    private String pictureurl1;

    /** 评论区图2 */
    @Excel(name = "评论区图2")
    private String pictureurl2;

    /** vdef1 */
    @Excel(name = "vdef1")
    private String vdef1;

    /** vdef2 */
    @Excel(name = "vdef2")
    private String vdef2;

    /** vdef3 */
    @Excel(name = "vdef3")
    private String vdef3;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShopId(String shopId) 
    {
        this.shopId = shopId;
    }

    public String getShopId() 
    {
        return shopId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }
    public void setCommentnum(Long commentnum) 
    {
        this.commentnum = commentnum;
    }

    public Long getCommentnum() 
    {
        return commentnum;
    }
    public void setPictureurl1(String pictureurl1) 
    {
        this.pictureurl1 = pictureurl1;
    }

    public String getPictureurl1() 
    {
        return pictureurl1;
    }
    public void setPictureurl2(String pictureurl2) 
    {
        this.pictureurl2 = pictureurl2;
    }

    public String getPictureurl2() 
    {
        return pictureurl2;
    }
    public void setVdef1(String vdef1) 
    {
        this.vdef1 = vdef1;
    }

    public String getVdef1() 
    {
        return vdef1;
    }
    public void setVdef2(String vdef2) 
    {
        this.vdef2 = vdef2;
    }

    public String getVdef2() 
    {
        return vdef2;
    }
    public void setVdef3(String vdef3) 
    {
        this.vdef3 = vdef3;
    }

    public String getVdef3() 
    {
        return vdef3;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("username", getUsername())
            .append("comment", getComment())
            .append("commentnum", getCommentnum())
            .append("pictureurl1", getPictureurl1())
            .append("pictureurl2", getPictureurl2())
            .append("vdef1", getVdef1())
            .append("vdef2", getVdef2())
            .append("vdef3", getVdef3())
            .toString();
    }
}
