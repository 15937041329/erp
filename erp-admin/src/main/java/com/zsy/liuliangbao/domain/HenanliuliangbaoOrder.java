package com.zsy.liuliangbao.domain;

import com.zsy.common.annotation.Excel;
import com.zsy.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 头条抖音流量包对象 henanliuliangbao_order
 * 
 * @author wangbingquan
 * @date 2020-06-09
 */
public class HenanliuliangbaoOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序列号 */
    private Long id;

    /** 手机号 */
    @Excel(name = "手机号")
    private String svcnum;

    /** 订单号 */
    @Excel(name = "订单号")
    private String offerid;

    /** null */
    private String vdef1;

    /** 分销标识 */
    @Excel(name = "分销标识")
    private String vdef2;

    /** null */
    private String vdef3;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSvcnum(String svcnum) 
    {
        this.svcnum = svcnum;
    }

    public String getSvcnum() 
    {
        return svcnum;
    }
    public void setOfferid(String offerid) 
    {
        this.offerid = offerid;
    }

    public String getOfferid() 
    {
        return offerid;
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
            .append("svcnum", getSvcnum())
            .append("createTime", getCreateTime())
            .append("offerid", getOfferid())
            .append("vdef1", getVdef1())
            .append("vdef2", getVdef2())
            .append("vdef3", getVdef3())
            .toString();
    }
}
