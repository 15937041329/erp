package com.zsy.pddlimitprv.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 黑名单地区及年龄筛选对象 pdd_limit_prv
 * 
 * @author wbq
 * @date 2020-07-11
 */
public class PddLimitPrv extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String skuName;

    /** 最小年龄 */
    @Excel(name = "最小年龄")
    private Long minAge;

    /** 最大年龄 */
    @Excel(name = "最大年龄")
    private Long maxAge;

    /** 省 */
    @Excel(name = "省")
    private String prv;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String county;

    /** 添加人 */
    @Excel(name = "添加人")
    private String userName;

    /** vdef1 */
    @Excel(name = "vdef1")
    private String vdef1;

    /** vdef2 */
    @Excel(name = "vdef2")
    private String vdef2;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSkuName(String skuName) 
    {
        this.skuName = skuName;
    }

    public String getSkuName() 
    {
        return skuName;
    }
    public void setMinAge(Long minAge) 
    {
        this.minAge = minAge;
    }

    public Long getMinAge() 
    {
        return minAge;
    }
    public void setMaxAge(Long maxAge) 
    {
        this.maxAge = maxAge;
    }

    public Long getMaxAge() 
    {
        return maxAge;
    }
    public void setPrv(String prv) 
    {
        this.prv = prv;
    }

    public String getPrv() 
    {
        return prv;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCounty(String county) 
    {
        this.county = county;
    }

    public String getCounty() 
    {
        return county;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("skuName", getSkuName())
            .append("minAge", getMinAge())
            .append("maxAge", getMaxAge())
            .append("prv", getPrv())
            .append("city", getCity())
            .append("county", getCounty())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userName", getUserName())
            .append("vdef1", getVdef1())
            .append("vdef2", getVdef2())
            .toString();
    }
}
