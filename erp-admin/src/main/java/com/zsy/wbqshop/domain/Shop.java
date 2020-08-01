package com.zsy.wbqshop.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 商城对象 shop
 * 
 * @author wbq
 * @date 2020-07-17
 */
public class Shop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 价格 */
    @Excel(name = "价格")
    private Double price;

    /** 折扣价 */
    @Excel(name = "折扣价")
    private Long priceother;

    /** 运费 */
    @Excel(name = "运费")
    private Long frieight;

    /** 评分 */
    @Excel(name = "评分")
    private String comments;

    /** 已售 */
    @Excel(name = "已售")
    private Long sold;

    /** 商品主图 */
    @Excel(name = "商品主图")
    private String maingraph;

    /** 访问量 */
    @Excel(name = "访问量")
    private Long visits;

    /** 商品详情 */
    @Excel(name = "商品详情")
    private String commodityDetails;

    /** 活动剩余时间 */
    @Excel(name = "活动剩余时间")
    private Long remainingTime;

    /** 商品副图1 */
    @Excel(name = "商品副图1")
    private String picture1;

    /** 商品副图2 */
    @Excel(name = "商品副图2")
    private String picture2;

    /** 商品副图3 */
    @Excel(name = "商品副图3")
    private String picture3;

    /** 商品副图4 */
    @Excel(name = "商品副图4")
    private String picture4;

    /** 商品副图5 */
    @Excel(name = "商品副图5")
    private String picture5;

    /** 商品副图6 */
    @Excel(name = "商品副图6")
    private String picture6;

    /** vdef1 */
    @Excel(name = "vdef1")
    private String vdef1;

    /** vdef2 */
    @Excel(name = "vdef2")
    private String vdef2;

    /** vdef3 */
    @Excel(name = "vdef3")
    private String vdef3;

    /** vdef4 */
    @Excel(name = "vdef4")
    private String vdef4;

    /** vdef5 */
    @Excel(name = "vdef5")
    private String vdef5;

    /** vdef6 */
    @Excel(name = "vdef6")
    private String vdef6;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
    }
    public void setPriceother(Long priceother) 
    {
        this.priceother = priceother;
    }

    public Long getPriceother() 
    {
        return priceother;
    }
    public void setFrieight(Long frieight) 
    {
        this.frieight = frieight;
    }

    public Long getFrieight() 
    {
        return frieight;
    }
    public void setComments(String comments) 
    {
        this.comments = comments;
    }

    public String getComments() 
    {
        return comments;
    }
    public void setSold(Long sold) 
    {
        this.sold = sold;
    }

    public Long getSold() 
    {
        return sold;
    }
    public void setMaingraph(String maingraph) 
    {
        this.maingraph = maingraph;
    }

    public String getMaingraph() 
    {
        return maingraph;
    }
    public void setVisits(Long visits) 
    {
        this.visits = visits;
    }

    public Long getVisits() 
    {
        return visits;
    }
    public void setCommodityDetails(String commodityDetails) 
    {
        this.commodityDetails = commodityDetails;
    }

    public String getCommodityDetails() 
    {
        return commodityDetails;
    }
    public void setRemainingTime(Long remainingTime) 
    {
        this.remainingTime = remainingTime;
    }

    public Long getRemainingTime() 
    {
        return remainingTime;
    }
    public void setPicture1(String picture1) 
    {
        this.picture1 = picture1;
    }

    public String getPicture1() 
    {
        return picture1;
    }
    public void setPicture2(String picture2) 
    {
        this.picture2 = picture2;
    }

    public String getPicture2() 
    {
        return picture2;
    }
    public void setPicture3(String picture3) 
    {
        this.picture3 = picture3;
    }

    public String getPicture3() 
    {
        return picture3;
    }
    public void setPicture4(String picture4) 
    {
        this.picture4 = picture4;
    }

    public String getPicture4() 
    {
        return picture4;
    }
    public void setPicture5(String picture5) 
    {
        this.picture5 = picture5;
    }

    public String getPicture5() 
    {
        return picture5;
    }
    public void setPicture6(String picture6) 
    {
        this.picture6 = picture6;
    }

    public String getPicture6() 
    {
        return picture6;
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
    public void setVdef4(String vdef4) 
    {
        this.vdef4 = vdef4;
    }

    public String getVdef4() 
    {
        return vdef4;
    }
    public void setVdef5(String vdef5) 
    {
        this.vdef5 = vdef5;
    }

    public String getVdef5() 
    {
        return vdef5;
    }
    public void setVdef6(String vdef6) 
    {
        this.vdef6 = vdef6;
    }

    public String getVdef6() 
    {
        return vdef6;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("price", getPrice())
            .append("priceother", getPriceother())
            .append("frieight", getFrieight())
            .append("comments", getComments())
            .append("sold", getSold())
            .append("maingraph", getMaingraph())
            .append("visits", getVisits())
            .append("commodityDetails", getCommodityDetails())
            .append("remainingTime", getRemainingTime())
            .append("createTime", getCreateTime())
            .append("picture1", getPicture1())
            .append("picture2", getPicture2())
            .append("picture3", getPicture3())
            .append("picture4", getPicture4())
            .append("picture5", getPicture5())
            .append("picture6", getPicture6())
            .append("vdef1", getVdef1())
            .append("vdef2", getVdef2())
            .append("vdef3", getVdef3())
            .append("vdef4", getVdef4())
            .append("vdef5", getVdef5())
            .append("vdef6", getVdef6())
            .toString();
    }
}
